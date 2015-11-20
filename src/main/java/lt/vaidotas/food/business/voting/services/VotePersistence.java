package lt.vaidotas.food.business.voting.services;

import lt.vaidotas.food.business.voting.model.Vote;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface VotePersistence {

    void addVote(final Integer userId, final Integer restaurantId, final LocalDate date);

    List<Vote> loadVotes(LocalDate date);

    Optional<Vote> loadVote(LocalDate day, Integer userId);

    void replaceVote(Integer userId, Integer restaurantId, LocalDate day);
}
