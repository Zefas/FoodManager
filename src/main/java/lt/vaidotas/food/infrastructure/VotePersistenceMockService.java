package lt.vaidotas.food.infrastructure;

import lt.vaidotas.food.business.voting.model.Vote;
import lt.vaidotas.food.business.voting.services.VotePersistence;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class VotePersistenceMockService implements VotePersistence {
    @Override
    public void addVote(final Integer userId, final Integer restaurantId, final LocalDate date) {

    }

    @Override
    public List<Vote> loadVotes(final LocalDate date) {
        return Arrays.asList(new Vote(-1, -1, LocalDateTime.now()), new Vote(-2, -2, LocalDateTime.now()), new Vote(-3, -3, LocalDateTime.now()));
    }

    @Override
    public Optional<Vote> loadVote(final LocalDate day, final Integer userId) {
        return null;
    }

    @Override
    public void replaceVote(final Integer userId, final Integer restaurantId, final LocalDate day) {

    }
}
