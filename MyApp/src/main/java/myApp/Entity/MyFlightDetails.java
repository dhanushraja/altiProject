package myApp.Entity;

import java.time.LocalDateTime;

public class MyFlightDetails {
	
	private long flightNumber;
	
	private String airlineName;
	
	private LocalDateTime deptTime;
	
	private LocalDateTime arrivalTime;
	
	private long duration;
	
	private long no_of_stops;
	
	private double price;
	
	public MyFlightDetails() {
		// TODO Auto-generated constructor stub
	}

	public MyFlightDetails(Long long2, String airlineName, LocalDateTime deptTime, LocalDateTime arrivalTime,
			Long long1, Long long3, double price) {
		super();
		this.flightNumber = long2;
		this.airlineName = airlineName;
		this.deptTime = deptTime;
		this.arrivalTime = arrivalTime;
		this.duration = long1;
		this.no_of_stops = long3;
		this.price = price;
	}

	public long getFlightNumber() {
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

	public LocalDateTime getDeptTime() {
		return deptTime;
	}

	public void setDeptTime(LocalDateTime deptTime) {
		this.deptTime = deptTime;
	}

	public LocalDateTime getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(LocalDateTime arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public long getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public long getNo_of_stops() {
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
