package fit5171.monash.edu;

import java.util.ArrayList;

public class FlightCollection {
	
	public static ArrayList<Flight> flights = new ArrayList<>();

	public static ArrayList<Flight> getFlights() {
		return flights;
	}

	public FlightCollection()
	{
		flights = new ArrayList<>();
	}

	public static void addFlights(Flight newFlight)
	{
		flights.add(newFlight);
	}
	
	public static Flight getFlightInfo(String city1, String city2) {
    	Flight find_flight = null;
		for(Flight flight: flights)
			if (flight.getDepartTo().equals(city1) && flight.getDepartFrom().equals(city2))
			{
				find_flight = flight;
			}
			else {
				throw new IllegalArgumentException("Can not find flights you want by two city you entered.");
			}

    	return find_flight;
    }
    
    public static Flight getFlightInfo(String city) {
    	//SELECT a flight where depart_to = city
		Flight find_flight = null;
		for(Flight flight: flights)
			if (flight.getDepartTo().equals(city))
			{
				find_flight = flight;
			}
			else {
				throw new IllegalArgumentException("Can not find flights you want by departTo city you entered.");
			}

		return find_flight;

    }
    public static Flight getFlightInfo(int flight_id) {
    	Flight certain_flight = null;
		for(Flight flight: flights)
			if (flight.getFlightID() == flight_id)
			{
				certain_flight = flight;
			}else
			{
				throw new IllegalArgumentException("Can not find flights you want by FlightID you entered.");
			}
    	return certain_flight;

    }
    

}
