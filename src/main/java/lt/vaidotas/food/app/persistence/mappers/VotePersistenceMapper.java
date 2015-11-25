package lt.vaidotas.food.app.persistence.mappers;

import lt.vaidotas.food.app.generic.DateUtil;
import lt.vaidotas.food.app.generic.Mapper;
import lt.vaidotas.food.app.persistence.model.VoteEntity;
import lt.vaidotas.food.business.voting.model.Vote;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.ZoneId;

@Component
public class VotePersistenceMapper implements Mapper<VoteEntity, Vote> {
    @Override
    public Vote to(VoteEntity from) {
        LocalDateTime localDateTime = LocalDateTime.ofInstant(from.getTime().toInstant(), ZoneId.systemDefault());
        return new Vote(from.getUserId(), from.getRestaurantId(), localDateTime);
    }

    @Override
    public VoteEntity from(Vote to) {
        return new VoteEntity(to.getRestaurantId(), to.getUserId(), DateUtil.toDate(to.getDateAndTime()));
    }
}
