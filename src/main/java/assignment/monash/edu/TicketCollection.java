package assignment.monash.edu;

import java.util.ArrayList;
import java.util.List;

public class TicketCollection {
	private static final List<Ticket> tickets = new ArrayList<>();
	public static List<Ticket> getTickets() {
		return tickets;
	}

	TicketCollection(){

	}
	public static void addTicket(Ticket newTicket){
		if (newTicket == null)
			throw new NullPointerException("Invalid Ticket");
		for (Ticket ticket : tickets)
			if (ticket.getTicketId() == newTicket.getTicketId())
				throw new IllegalArgumentException("Duplicate Ticket");
		tickets.add(newTicket);
	}

	public static void addTickets(List<Ticket> ticketsDb) {
		if (ticketsDb == null)
			throw new NullPointerException("Invalid Tickets, Cannot be added to list");
		TicketCollection.tickets.addAll(ticketsDb);
	}
	
	public static void getAllTickets() {
    	//display all available tickets from the Ticket collection
		for (Ticket ticket:getTickets())
			System.out.println(ticket);
    }

	public static Ticket getTicketInfo(int ticketId) {
    	//SELECT a ticket where ticket id = ticketId
		Ticket newTicket = null;
		for (Ticket ticket: tickets)
			if (ticket.getTicketId() == ticketId)
				newTicket = ticket;
		if (newTicket == null)
			throw new NullPointerException("Ticket does not exist");
		return newTicket;
    }
}
