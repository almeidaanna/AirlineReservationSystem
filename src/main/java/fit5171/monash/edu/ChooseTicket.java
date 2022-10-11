package fit5171.monash.edu;
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
				if (ticket.getTicketId() == ticketId)
					exists = true;
			}
			if (!exists)
				throw new IllegalArgumentException("This ticket does not exist!");
	        //buy ticket here
	        buyTicket.buyTicket(ticketId);
        }
        else{
            //in case there is no direct ticket from city1 to city2
        	//SELECT a flight where depart_to = city2
        	Flight departTo = FlightCollection.getFlightInfo(city2);
        	//and search for city with depart_from as connector city
        	String connectCity = departTo.getDepartFrom();
        	//SELECT * from flight where depart_to = '" + connectCity + "' and depart_from = '" + city1+"'"
        	Flight flightConnectingTwoCities = FlightCollection.getFlightInfo(city1, connectCity);
        	if(flightConnectingTwoCities != null){
        		System.out.println("There is special way to go there. And it is transfer way, like above. Way №" + counter);
        		idFirst = departTo.getFlightID();
        		idSecond = flightConnectingTwoCities.getFlightID();
            }
        	counter++;
        	buyTicket.buyTicket(idFirst, idSecond); //pass two tickets and buy them
        	if(counter == 1)
                System.out.println("There is no possible variants.");
		}
    }
}