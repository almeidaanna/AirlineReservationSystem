package fit5171.monash.edu;

import java.util.ArrayList;

public class TicketCollection {
	
	public static ArrayList<Ticket> tickets;

	public TicketCollection(){
		tickets = new ArrayList<>();
	}

	public static ArrayList<Ticket> getTickets() {
		return tickets;
	}

	public static void addTicket(Ticket newTicket){
		if (newTicket == null)
			throw new NullPointerException("Invalid Ticket");
		for (Ticket ticket : tickets)
			if (ticket.getTicket_id() == newTicket.getTicket_id())
				throw new RuntimeException("Duplicate Ticket");
		tickets.add(newTicket);
	}

	public static void addTickets(ArrayList<Ticket> tickets_db) {
		TicketCollection.tickets.addAll(tickets_db);
	}
	
	public static void getAllTickets() {
    	//display all available tickets from the Ticket collection
    }
	public static Ticket getTicketInfo(int ticket_id) {
    	//SELECT a ticket where ticket id = ticket_id
		Ticket new_ticket = null;
		for (Ticket ticket: getTickets())
			if (ticket.getTicket_id() == ticket_id)
				new_ticket = ticket;
		if (new_ticket == null)
			throw new NullPointerException("Ticket does not exist");
		return new_ticket;
    }
}
