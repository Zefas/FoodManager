package lt.vaidotas.food.front.controllers;

import lt.vaidotas.food.business.voting.BusinessValidationException;
import lt.vaidotas.food.business.voting.VoteManager;
import lt.vaidotas.food.business.voting.model.Vote;
import lt.vaidotas.food.front.rest.GenericResponse;
import lt.vaidotas.food.front.rest.VoteRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.ZoneId;
import java.util.Date;
import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private VoteManager voteManager;


    @RequestMapping(value = "/votes/add", method = RequestMethod.POST)
    @ResponseBody
    public GenericResponse addVote(@RequestBody final VoteRequest vote) {
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
    public List<Vote> getVotes(@PathVariable("date") @DateTimeFormat(iso= DateTimeFormat.ISO.DATE) Date date) {
        return voteManager.getVotes(date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
    }

}
