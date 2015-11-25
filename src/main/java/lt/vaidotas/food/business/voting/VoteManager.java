package lt.vaidotas.food.business.voting;

import lt.vaidotas.food.business.TimeCalculator;
import lt.vaidotas.food.business.restaurant.services.RestaurantPersistence;
import lt.vaidotas.food.business.voting.model.Vote;
import lt.vaidotas.food.business.voting.model.VoteResult;
import lt.vaidotas.food.business.voting.services.VotePersistence;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;
import java.util.stream.Collectors;

public class VoteManager {

    private final VotePersistence votePersistence;
    private final RestaurantPersistence restaurantPersistence;
    private final TimeCalculator timeCalculator;

    public VoteManager(final VotePersistence votePersistence, final RestaurantPersistence restaurantPersistence, final TimeCalculator timeCalculator) {
        this.votePersistence = votePersistence;
        this.restaurantPersistence = restaurantPersistence;
        this.timeCalculator = timeCalculator;
    }

    public void vote(final Integer userId, final Integer restaurantId) throws BusinessValidationException {
        Objects.requireNonNull(userId, "USer ID cannot be null.");
        Objects.requireNonNull(restaurantId, "Restaurant ID cannot be null.");

        final LocalDate day = shouldGoToNextDaysVote() ? LocalDate.now().plusDays(1) : LocalDate.now();
        addOrReplaceVote(userId, restaurantId, day);
    }

    private void addOrReplaceVote(final Integer userId, final Integer restaurantId, final LocalDate day) {
        Optional<Vote> vote = votePersistence.loadVote(day, userId);
        if (vote.isPresent()) {
            votePersistence.replaceVote(userId, restaurantId, day);
        } else {
            votePersistence.addVote(userId, restaurantId, day);
        }
    }

    private boolean shouldGoToNextDaysVote() {
        return timeCalculator.currentLocalTime().isAfter(LocalTime.of(11, 0, 0, 0));
    }

    public List<Vote> getVotesAll(final LocalDate date) {
        return votePersistence.loadVotes(date);
    }

    public List<VoteResult> getVoteResult(final LocalDate date) {
        List<Vote> votes = votePersistence.loadVotes(date);
        if(votes.isEmpty()) {
            return Collections.emptyList();
        }

        return findWinners(votes);
    }

    private List<VoteResult> findWinners(final List<Vote> votes) {
        if(votes.isEmpty()) return Collections.emptyList();

        Map<Integer, Long> groupedByVotes = votes.stream()
                .collect(Collectors.groupingBy(Vote::getRestaurantId, Collectors.counting()));


        List<Map.Entry<Integer, Long>> sorted = groupedByVotes.entrySet().stream()
                .sorted((e1, e2) -> -1 * e1.getValue().compareTo(e2.getValue()))
                .collect(Collectors.toList());


        Long topScore = sorted.get(0).getValue();
        return sorted.stream()
                .filter(e -> e.getValue().equals(topScore))
                .map(e -> new VoteResult(restaurantPersistence.findById(e.getKey()).orElse(null), e.getValue()))
                .collect(Collectors.toList());
    }

}
