package lt.vaidotas.food.app.persistence.repository;

import lt.vaidotas.food.app.persistence.model.VoteEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface VoteRepository  extends CrudRepository<VoteEntity, Integer> {

    @Query("from VoteEntity v where v.userId = ?1 and v.time >= ?2 and v.time < ?3")
    List<VoteEntity> findByUserIdAndTime(final Integer userId, final Date start, final Date end);

    @Query("from VoteEntity v where v.time >= ?1 and v.time < ?2")
    List<VoteEntity> findByTime(final Date start, final Date end);
}
