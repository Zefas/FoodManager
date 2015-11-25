package lt.vaidotas.food.app.front.controllers;

import lt.vaidotas.food.app.front.rest.VoteRequest;
import lt.vaidotas.food.app.front.rest.generic.GenericResponse;
import lt.vaidotas.food.business.voting.BusinessValidationException;
import lt.vaidotas.food.business.voting.VoteManager;
import lt.vaidotas.food.business.voting.model.Vote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.ZoneId;
import java.util.Date;
import java.util.List;

@Controller
public class VoteController {

    @Autowired
    private VoteManager voteManager;


    @RequestMapping(value = "/votes/add", method = RequestMethod.POST)
    @ResponseBody
    public GenericResponse<?> addVote(@RequestBody final VoteRequest vote) {
        try {
            voteManager.vote(vote.getUserId(), vote.getRestaurantId());
            return GenericResponse.ok(null);

        } catch (BusinessValidationException ex) {
            return GenericResponse.fail(null);
        } catch (Exception ex) {
            return GenericResponse.error(null);
        }
    }

    @RequestMapping(value = "/votes/get/{date}", method = RequestMethod.GET)
    @ResponseBody
    public GenericResponse<List<Vote>> getVotes(@PathVariable("date") @DateTimeFormat(iso= DateTimeFormat.ISO.DATE) Date date) {
        List<Vote> votes = voteManager.getVotesAll(date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
        return GenericResponse.ok(votes);
    }

}
