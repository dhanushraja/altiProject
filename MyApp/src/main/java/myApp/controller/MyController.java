package myApp.controller;

import java.util.List;

import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import myApp.Entity.MyFlightDetails;
import myApp.exception.NoFlightDetailsFoundException;
import myApp.service.MyService;

@RestController
public class MyController {
	
	@Autowired
	private MyService myFlightService;
	
	@RequestMapping(value  = "/getFlightDetails", method = RequestMethod.GET)
	public List<MyFlightDetails> getFlightDetails(@RequestParam String sourceCity, @RequestParam String destCity, @RequestParam String travelDate, @RequestParam(required = false) String returnDate) throws ParseException {
		return myFlightService.getFlightData(sourceCity, destCity, travelDate, returnDate);
	}
	
	@RequestMapping(value  = "/getFlightDetailsSortedBy", method = RequestMethod.GET)
	public List<MyFlightDetails> getFlightDetailsSortedBy(@RequestParam String variable) throws NoFlightDetailsFoundException{
		return myFlightService.getFlightDetailsSortedBy(variable);	
	}

}
