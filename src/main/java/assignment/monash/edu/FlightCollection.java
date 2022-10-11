package assignment.monash.edu;

import java.util.ArrayList;
import java.util.List;

public class FlightCollection {
	
	private static final List<Flight> flights = new ArrayList<>();

	public static List<Flight> getFlights() {
		return flights;
	}

	private FlightCollection()
	{
	}

	public static void addFlights(Flight newFlight)
	{
		flights.add(newFlight);
	}
	
	public static Flight getFlightInfo(String city1, String city2) {
    	Flight findedFlight = null;
		for(Flight flight: flights)
			if (flight.getDepartFrom().equals(city1) && flight.getDepartTo().equals(city2))
				findedFlight = flight;
    	return findedFlight;
    }
    
    public static Flight getFlightInfo(String city) {
    	//SELECT a flight where depart_to = city
		Flight findedFlight = null;
		for(Flight flight: flights)
			if (flight.getDepartTo().equals(city))
				findedFlight = flight;
		return findedFlight;

    }
    public static Flight getFlightInfo(int flightId) {
    	Flight certainedflight = null;
		for(Flight flight: flights)
			if (flight.getFlightID() == flightId) {
				certainedflight = flight;
				break;
			}
		if (certainedflight == null)
			throw new IllegalArgumentException("Can not find flights you want by FlightID you entered.");
    	return certainedflight;
    }
    

}
