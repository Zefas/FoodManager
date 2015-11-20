package lt.vaidotas.food.business.voting;

import lt.vaidotas.food.business.TimeCalculator;
import lt.vaidotas.food.business.voting.model.Vote;
import lt.vaidotas.food.business.voting.services.VotePersistence;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

public class VoteManagerTest {

    @InjectMocks
    private VoteManager voteManager;
    @Mock
    private VotePersistence votePersistence;
    @Mock
    private TimeCalculator timeCalculator;

    @Before
    public void initMocks() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void userVoteIsBeingPersisted() throws Exception {
        when(timeCalculator.currentLocalTime()).thenReturn(LocalTime.of(10, 30, 0));
        when(votePersistence.loadVote(any(), any())).thenReturn(Optional.empty());

        voteManager.vote(11, 101);

        ArgumentCaptor<LocalDate> args = ArgumentCaptor.forClass(LocalDate.class);
        Mockito.verify(votePersistence).addVote(eq(11), eq(101), args.capture());

        assertEquals("User vote should be added to this day.", LocalDate.now(), args.getValue());
    }

    @Test
    public void onlyLastUserVoteIsBeingPersisted() throws Exception {
        when(timeCalculator.currentLocalTime()).thenReturn(LocalTime.of(10, 30, 0));
        when(votePersistence.loadVote(any(), any())).thenReturn(Optional.of(new Vote(11, 109, LocalDateTime.now())));

        voteManager.vote(11, 101);

        Mockito.verify(votePersistence, times(0)).addVote(any(), any(), any());
        ArgumentCaptor<LocalDate> args = ArgumentCaptor.forClass(LocalDate.class);
        Mockito.verify(votePersistence, times(1)).replaceVote(any(), any(), args.capture());

        assertEquals("User vote should be added to this day.", LocalDate.now(), args.getValue());
    }

    @Test
    public void userVoteIsBeingPushedToOtherDayIfTimeIsAfter11() throws Exception {
        when(timeCalculator.currentLocalTime()).thenReturn(LocalTime.of(11, 1, 0));
        when(votePersistence.loadVote(any(), any())).thenReturn(Optional.empty());

        voteManager.vote(11, 101);

        ArgumentCaptor<LocalDate> args = ArgumentCaptor.forClass(LocalDate.class);
        Mockito.verify(votePersistence).addVote(eq(11), eq(101), args.capture());

        assertEquals("User vote should be added to next day.", LocalDate.now().plusDays(1), args.getValue());
    }

    @Test
    public void voteResultsAreCorrect() throws Exception {
        // TODO
        //voteManager.getVotesAll();
    }

}