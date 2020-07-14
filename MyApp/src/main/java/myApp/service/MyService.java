package myApp.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import myApp.Entity.MyFlightDetails;
import myApp.exception.NoFlightDetailsFoundException;

@Service
public class MyService {

	private RestTemplate restTemplate = new RestTemplate();
	
	private List<MyFlightDetails> flightDetails = new ArrayList<>();

	public List<MyFlightDetails> getFlightData(String sourceCity, String destCity, String travelDate,
			String returnDate) throws ParseException {
		
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);

		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl("http://localhost:9000/getFlightDetails")
		        .queryParam("sourceCity", sourceCity)
		        .queryParam("destCity", destCity)
		        .queryParam("travelDate", travelDate);

		HttpEntity<Object> entity = new HttpEntity<>(headers);
		
		HttpEntity<String> response = restTemplate.exchange(
		        builder.toUriString(), 
		        HttpMethod.GET, 
		        entity, 
		        String.class);
	
		JSONArray jsonArray = (JSONArray) new JSONParser().parse(response.getBody());
		
		@SuppressWarnings("unchecked")
		Iterator<Object> itr = jsonArray.iterator();
		
		
		while(itr.hasNext()) {
			JSONObject jo = (JSONObject) itr.next();
			MyFlightDetails flightDetail = new MyFlightDetails((Long)jo.get("flightNumber"),
					(String)jo.get("airlineName"), LocalDateTime.parse((String)jo.get("deptTime"),DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm")), 
					LocalDateTime.parse((String)jo.get("arrivalTime"),DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm")), (Long)jo.get("duration"),
					(Long)jo.get("no_of_stops"), (Double)jo.get("price"));
			flightDetails.add(flightDetail);
		}
		
		return flightDetails;
		
	}

	public List<MyFlightDetails> getFlightDetailsSortedBy(String variable) throws NoFlightDetailsFoundException {
		if(flightDetails.isEmpty()) {
			throw new NoFlightDetailsFoundException("Flight Details Not Found");
		}
		
		switch(variable) {
		case "flightNumber" : {
			flightDetails.sort((c1,c2) -> Long.valueOf(c2.getFlightNumber()).compareTo(Long.valueOf(c1.getFlightNumber())));
			return flightDetails;
		}
		case "airlineName" : {
			flightDetails.sort((c1,c2) -> c2.getAirlineName().compareTo(c1.getAirlineName()));
			return flightDetails;
		}
		case "deptTime" : {
			flightDetails.sort((c1,c2) -> c2.getDeptTime().compareTo(c1.getDeptTime()));
			return flightDetails;
		}
		case "arrivalTime" : {
			flightDetails.sort((c1,c2) -> c2.getArrivalTime().compareTo(c1.getArrivalTime()));
			return flightDetails;
		}
		case "no_of_stops" : {
			flightDetails.sort((c1,c2) -> Long.valueOf(c2.getFlightNumber()).compareTo(Long.valueOf(c1.getFlightNumber())));
			return flightDetails;
		}
		case "duration" : {
			flightDetails.sort((c1,c2) -> Long.valueOf(c2.getDuration()).compareTo(Long.valueOf(c1.getDuration())));
			return flightDetails;
		}
		case "price" : {
			flightDetails.sort((c1,c2) -> Double.valueOf(c2.getPrice()).compareTo(Double.valueOf(c1.getPrice())));
			return flightDetails;
		}
		default:
			return flightDetails;
		}
	}
}
