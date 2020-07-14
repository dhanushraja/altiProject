package flightApp.parser;

public class FlightEntity {
   
	private int flightNumber;
	
	private String airlineName;
	
	private String deptTime;
	
	private String arrivalTime;
	
	private int duration;
	
	private int no_of_stops;
	
	private double price;
	
	public FlightEntity() {
		// TODO Auto-generated constructor stub
	}
	

	public FlightEntity(int flightNumber, String string, String deptTime, String arrivalTime,
			int duration, int no_of_stops, double price) {
		super();
		this.flightNumber = flightNumber;
		this.airlineName = string;
		this.deptTime = deptTime;
		this.arrivalTime = arrivalTime;
		this.duration = duration;
		this.no_of_stops = no_of_stops;
		this.price = price;
	}


	public int getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(int flightNumber) {
		this.flightNumber = flightNumber;
	}

	public String getAirlineName() {
		return airlineName;
	}

	public void setAirlineName(String airlineName) {
		this.airlineName = airlineName;
	}
	
	

	public String getDeptTime() {
		return deptTime;
	}


	public void setDeptTime(String deptTime) {
		this.deptTime = deptTime;
	}


	public String getArrivalTime() {
		return arrivalTime;
	}


	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}


	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public int getNo_of_stops() {
		return no_of_stops;
	}

	public void setNo_of_stops(int no_of_stops) {
		this.no_of_stops = no_of_stops;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	
	
}
