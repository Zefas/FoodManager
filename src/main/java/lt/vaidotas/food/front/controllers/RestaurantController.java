package lt.vaidotas.food.front.controllers;

import lt.vaidotas.food.business.restaurant.RestaurantManager;
import lt.vaidotas.food.business.voting.BusinessValidationException;
import lt.vaidotas.food.front.rest.RestaurantRequestResponse;
import lt.vaidotas.food.front.rest.generic.GenericResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class RestaurantController {

    @Autowired
    private RestaurantManager restaurantManager;

    @Autowired
    private RestaurantMapper restaurantMapper;

    @RequestMapping(value = "/restaurant/get", method = RequestMethod.GET)
    @ResponseBody
    public GenericResponse<List<RestaurantRequestResponse>> getRestaurants() {
        return GenericResponse.error(restaurantManager.getAllRestaurants());
    }

    @RequestMapping(value = "/restaurant/add", method = RequestMethod.POST)
    @ResponseBody
    public GenericResponse<String> addRestaurant(@RequestBody RestaurantRequestResponse data) {
        if(data.getId() != null) {
            return GenericResponse.error("Cannot use existing Restaurant!");
        }

        try {
            restaurantManager.addNewRestaurant(restaurantMapper.mapTo(data));
            return GenericResponse.ok("");
        } catch (BusinessValidationException e) {
            return GenericResponse.fail("Not Implemented!");
        }
    }

    @RequestMapping(value = "/restaurant/update", method = RequestMethod.POST)
    @ResponseBody
    public GenericResponse<String> updateRestaurant(@RequestBody RestaurantRequestResponse data) {
        if(data.getId() == null) {
            return GenericResponse.error("Must use existing Restaurant!");
        }

        try {
            restaurantManager.updateRestaurant(restaurantMapper.mapTo(data));
            return GenericResponse.ok("");
        } catch (BusinessValidationException e) {
            return GenericResponse.fail("Not Implemented!");
        }
    }


}
