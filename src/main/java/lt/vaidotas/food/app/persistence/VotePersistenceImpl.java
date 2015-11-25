package lt.vaidotas.food.app.persistence;

import com.google.common.collect.Lists;
import lt.vaidotas.food.app.generic.DateUtil;
import lt.vaidotas.food.app.persistence.mappers.VotePersistenceMapper;
import lt.vaidotas.food.app.persistence.model.VoteEntity;
import lt.vaidotas.food.app.persistence.repository.VoteRepository;
import lt.vaidotas.food.business.voting.model.Vote;
import lt.vaidotas.food.business.voting.services.VotePersistence;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class VotePersistenceImpl implements VotePersistence {

    @Autowired
    private VoteRepository voteRepository;

    @Autowired
    private VotePersistenceMapper mapper;

    @Override
    public void addVote(Integer userId, Integer restaurantId, LocalDate date) {
        VoteEntity entity = new VoteEntity(null, restaurantId, userId, DateUtil.toDate(date));
        voteRepository.save(entity);
    }

    @Override
    public List<Vote> loadVotes(LocalDate date) {
        Iterable<VoteEntity> all = voteRepository.findByTime(DateUtil.toDate(date), DateUtil.toDate(date.plusDays(1)));
        return new ArrayList<>(mapper.to(Lists.newArrayList(all)));
    }

    @Override
    public Optional<Vote> loadVote(LocalDate day, Integer userId) {
        Optional<VoteEntity> voteEntity = loadVoteEntity(day, userId);

        return voteEntity.map(entity -> mapper.to(entity));
    }

    private Optional<VoteEntity> loadVoteEntity(final LocalDate day, final Integer userId) {
        List<VoteEntity> votes = voteRepository.findByUserIdAndTime(userId, DateUtil.toDate(day), DateUtil.toDate(day.plusDays(1)));

        if(votes.size() > 1) {
            throw new IllegalStateException("Should be no more than one vote per day for user.");
        }

        if(votes.isEmpty()) {
            return Optional.empty();
        }

        return Optional.of(votes.get(0));
    }

    @Override
    public void replaceVote(Integer userId, Integer restaurantId, LocalDate day) {
        Optional<VoteEntity> vote = loadVoteEntity(day, userId);

        vote.ifPresent(v -> {
            v.setRestaurantId(restaurantId);
            voteRepository.save(v);
        });
    }
}
