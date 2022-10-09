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
    	Flight findedFlight = null;
		for(Flight flight: flights)
			if (flight.getDepartTo().equals(city1) && flight.getDepartFrom().equals(city2))
			{
				findedFlight = flight;
			}
			else {
				throw new IllegalArgumentException("Can not find flights you want by two city you entered.");
			}

    	return findedFlight;
    }
    
    public static Flight getFlightInfo(String city) {
    	//SELECT a flight where depart_to = city
		Flight findedFlight = null;
		for(Flight flight: flights)
			if (flight.getDepartTo().equals(city))
			{
				findedFlight = flight;
			}
			else {
				throw new IllegalArgumentException("Can not find flights you want by departTo city you entered.");
			}

		return findedFlight;

    }
    public static Flight getFlightInfo(int flightId) {
    	Flight certainedflight = null;
		for(Flight flight: flights)
			if (flight.getFlightID() == flightId)
			{
				certainedflight = flight;
				break;
			}else
				throw new IllegalArgumentException("Can not find flights you want by FlightID you entered.");
    	return certainedflight;
    }
    

}
