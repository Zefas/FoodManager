package lt.vaidotas.food.business.voting;

import lt.vaidotas.food.business.TimeCalculator;
import lt.vaidotas.food.business.voting.model.Vote;
import lt.vaidotas.food.business.voting.model.VoteResult;
import lt.vaidotas.food.business.voting.services.VotePersistence;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

public class VoteManager {

    private final VotePersistence votePersistence;
    private final TimeCalculator timeCalculator;

    public VoteManager(final VotePersistence votePersistence, final TimeCalculator timeCalculator) {
        this.votePersistence = votePersistence;
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

    public Optional<VoteResult> getVoteResult(final LocalDate date) {
        List<Vote> votes = votePersistence.loadVotes(date);
        if(votes.isEmpty()) {
            return Optional.empty();
        }

        Map<Integer, Long> collect = votes.stream()
                .collect(Collectors.groupingBy(Vote::getRestaurantId, Collectors.counting()));

        // TODO
        return Optional.empty();
    }

}
