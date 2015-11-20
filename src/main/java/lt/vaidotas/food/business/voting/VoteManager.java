package lt.vaidotas.food.business.voting;

import lt.vaidotas.food.business.voting.model.Vote;
import lt.vaidotas.food.business.voting.services.VoteRegistration;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Objects;

public class VoteManager {

    private final VoteRegistration voteRegistration;

    public VoteManager(final VoteRegistration voteRegistration) {
        this.voteRegistration = voteRegistration;
    }

    public void vote(final Integer userId, final Integer restaurantId) throws BusinessValidationException {
        Objects.requireNonNull(userId, "USer ID cannot be null.");
        Objects.requireNonNull(restaurantId, "Restaurant ID cannot be null.");

        if (shouldGoToNextDaysVote()) {
            voteRegistration.addVote(userId, restaurantId, LocalDate.now().plusDays(1));
            return;
        }

        voteRegistration.addVote(userId, restaurantId, LocalDate.now());
    }

    private boolean shouldGoToNextDaysVote() {
        return LocalTime.now().isAfter(LocalTime.of(11, 0, 0, 0));
    }


    public List<Vote> getVotes(final LocalDate date) {
        return voteRegistration.loadVotes(date);
    }

}
