package lt.vaidotas.food.business.voting;

import lt.vaidotas.food.business.voting.model.Vote;
import lt.vaidotas.food.business.voting.services.VotePersistence;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Objects;

public class VoteManager {

    private final VotePersistence votePersistence;

    public VoteManager(final VotePersistence votePersistence) {
        this.votePersistence = votePersistence;
    }

    public void vote(final Integer userId, final Integer restaurantId) throws BusinessValidationException {
        Objects.requireNonNull(userId, "USer ID cannot be null.");
        Objects.requireNonNull(restaurantId, "Restaurant ID cannot be null.");

        if (shouldGoToNextDaysVote()) {
            votePersistence.addVote(userId, restaurantId, LocalDate.now().plusDays(1));
            return;
        }

        votePersistence.addVote(userId, restaurantId, LocalDate.now());
    }

    private boolean shouldGoToNextDaysVote() {
        return LocalTime.now().isAfter(LocalTime.of(11, 0, 0, 0));
    }


    public List<Vote> getVotes(final LocalDate date) {
        return votePersistence.loadVotes(date);
    }

}
