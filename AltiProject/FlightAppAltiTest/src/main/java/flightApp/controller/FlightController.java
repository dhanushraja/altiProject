package flightApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import flightApp.parser.FlightEntity;
import flightApp.service.FlightService;

@RestController
public class FlightController {
	
	@Autowired
	private FlightService flightService;

	
	@RequestMapping(value  = "/getFlightDetails", method = RequestMethod.GET)
	public List<FlightEntity> getFlightDetails(@RequestParam String sourceCity, @RequestParam String destCity, @RequestParam String travelDate, @RequestParam(required = false) String returnDate) {
		return flightService.giveFlightDetails(sourceCity, destCity, travelDate, returnDate);
	}
}
