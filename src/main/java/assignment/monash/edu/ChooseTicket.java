package assignment.monash.edu;
import java.util.Scanner;

public class ChooseTicket{
	BuyTicket buyTicket;

	Scanner in;

	public ChooseTicket(){
		in = new Scanner(System.in);
		buyTicket = new BuyTicket();
	}

	public BuyTicket getBuyTicket() {
		return buyTicket;
	}

	public void setBuyTicket(BuyTicket buyTicket) {
		this.buyTicket = buyTicket;
	}

    public void chooseTicket(String city1, String city2)
    {
    	int counter = 1;
    	int idFirst = 0;
        int idSecond = 0;
    	
        Flight flight = FlightCollection.getFlightInfo(city1, city2);

        //search for direct flight from city1 to city2
        if(flight != null) {
        	TicketCollection.getAllTickets();
	        System.out.println("Enter ID of ticket you want to choose:");
			String input = in.nextLine();
	        int ticketId = Integer.parseInt(input);
			boolean exists = false;
			for (Ticket ticket: TicketCollection.getTickets()) {
				if (ticket.getTicketId() == ticketId) {
					exists = true;
					break;
				}
			}
			if (!exists)
				throw new IllegalArgumentException("This ticket does not exist!");
	        buyTicket.buyTicket(ticketId);
        } else {
			Flight departTo = FlightCollection.getFlightInfo(city2);
			int destinationTicketId = 0;
			int connectingTicketId = 0;
			if (departTo == null)
				throw new IllegalArgumentException("No Flights exist to the input city");
			String connectCity = departTo.getDepartFrom();
			Flight flightConnectingTwoCities = FlightCollection.getFlightInfo(city1, connectCity);
			if (flightConnectingTwoCities != null) {
				System.out.println("There is special way to go there. And it is transfer way, like above. Way №" + counter);
				idFirst = departTo.getFlightID();
				idSecond = flightConnectingTwoCities.getFlightID();
				for (Ticket ticket : TicketCollection.getTickets()) {
					if (ticket.getFlight().getFlightID() == idFirst)
						destinationTicketId = ticket.getTicketId();
					else if (ticket.getFlight().getFlightID() == idSecond)
						connectingTicketId = ticket.getTicketId();
				}
				counter++;
			}
			if (counter == 1) {
				throw new IllegalArgumentException("Cannot find a flight between the two input cities");
			}
			buyTicket.buyTicket(destinationTicketId, connectingTicketId); //pass two tickets and buy them
		}
	}
}