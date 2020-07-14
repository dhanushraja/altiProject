package flightApp.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import flightApp.parser.FlightEntity;

@Service
public class FlightService {

	public List<FlightEntity> giveFlightDetails(String sourceCity, String destCity, String travelDate,  String returnDate) {
		if(sourceCity.equals("Chennai") && destCity.equals("Delhi")) {
			FlightEntity fe1 = new FlightEntity(1, "Indian Airlines",
					"08/01/2020 05:30", "08/01/2020 06:30", 1, 1, 30000.0);
			FlightEntity fe2 = new FlightEntity(2, "Jet Airways",
					"08/01/2020 05:30", "08/01/2020 06:45", 1, 1, 35000.0);
			FlightEntity fe3 = new FlightEntity(3, "Luftansa",
					"08/01/2020 05:30", "08/01/2020 08:30", 1, 2, 40000.0);
			
			return new ArrayList<>(Arrays.asList(fe1,fe2,fe3));
		}else {
			return new ArrayList<>();
		}
	}
}
