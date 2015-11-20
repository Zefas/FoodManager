package lt.vaidotas.food.business.voting.services;

import lt.vaidotas.food.business.voting.model.Vote;

import java.time.LocalDate;
import java.util.List;

public interface VoteRegistration {

    void addVote(final Integer userId, final Integer restaurantId, final LocalDate date);

    List<Vote> loadVotes(LocalDate date);
}
