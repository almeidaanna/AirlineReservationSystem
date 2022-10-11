package assignment.monash.edu;

import java.util.*;

public class BuyTicket {
    Passenger passenger;
    Ticket ticket;
    Flight flight;
    Scanner in;

    public BuyTicket() {
        passenger = new Passenger();
        ticket = new Ticket();
        flight = new Flight();
        in = new Scanner(System.in);
    }
    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public void showTicket() {
        System.out.println("You have bought a ticket for flight " + ticket.flight.getDepartFrom() + " - " + ticket.flight.getDepartTo() + "\n\nDetails:");
        System.out.println(this.ticket.toString());
    }

    public void buyTicket(int ticketId) {
        //method for buying one ticket with direct flight
        int flightId;
        //select ticket where ticketId="+ticketId"
        Ticket validTicket = TicketCollection.getTicketInfo(ticketId);
        //if there is a valid ticket id was input then we buy it, otherwise show message
        if(validTicket == null)
            System.out.println("This ticket does not exist.");
        else{
            flightId = validTicket.getFlight().getFlightID();
                setPassengerDetails();
                String tempInput;
                System.out.println("Do you want to purchase?\n 1-YES 0-NO");
                tempInput = in.nextLine();
                int purch = Integer.parseInt(tempInput);
                if (purch == 0)
                    return;
                else {
                    flight = FlightCollection.getFlightInfo(flightId);
                    int airplaneId = flight.getAirplane().getAirplaneID();
                    Airplane airplane = Airplane.getAirPlaneInfo(airplaneId);
                    ticket = TicketCollection.getTicketInfo(ticketId);
                    ticket.setPassenger(passenger);
                    ticket.setTicketId(ticketId);
                    ticket.setFlight(flight);
                    ticket.setPrice(ticket.getPrice());
                    ticket.setClassVip(ticket.getClassVip());
                    ticket.setTicketStatus(true);
                    if (ticket.getClassVip())
                        airplane.setBusinessSitsNumber(airplane.getBusinessSitsNumber() - 1);
                    else
                        airplane.setEconomySitsNumber(airplane.getEconomySitsNumber() - 1);
                }
                System.out.println("Your bill: " + ticket.getPrice() + "\n");
                setPassengerCardDetails();
        }
    }

    private void setPassengerCardDetails() {
        String tempInput;
        System.out.println("Enter your card number:");
        String cardNumber = in.nextLine();
        passenger.setCardNumber(cardNumber);
        System.out.println("Enter your security code:");
        tempInput = in.nextLine();
        int securityCode = Integer.parseInt(tempInput);
        passenger.setSecurityCode(securityCode);
    }

    private void setPassengerDetails() {
        System.out.println("Enter your First Name: ");
        String firstName = in.nextLine();
        passenger.setFirstName(firstName);
        System.out.println("Enter your Second name:");
        String secondName = in.nextLine();
        passenger.setSecondName(secondName); //setting passengers info
        System.out.println("Enter your age:");
        String tempInput = in.nextLine();
        int age = Integer.parseInt(tempInput);
        in.nextLine();
        passenger.setAge(age);
        System.out.println("Enter your gender: ");
        String gender = in.nextLine();
        passenger.setGender(gender);
        System.out.println("Enter your e-mail address: ");
        String email = in.nextLine();
        passenger.setEmail(email);
        System.out.println("Enter your phone number: ");
        String phoneNumber = in.nextLine();
        passenger.setPhoneNumber(phoneNumber);
        System.out.println("Enter your passport number: ");
        String passportNumber = in.nextLine();
        passenger.setPassport(passportNumber);
    }

    @SuppressWarnings("null")
	public void buyTicket(int ticketIdFirst, int ticketIdSecond) {
		 //method for buying two tickets with transfer flight
        int flightIdFirst = 0;
        int flightIdSecond = 0;
        System.out.println(ticketIdFirst + " " + ticketIdSecond);
        Ticket validTicketFirst = TicketCollection.getTicketInfo(ticketIdFirst);
        Ticket validTicketSecond = TicketCollection.getTicketInfo(ticketIdSecond);
        System.out.println("Processing...");
        if(validTicketFirst == null || validTicketSecond == null)
            System.out.println("This ticket does not exist.");
        else {
        	flightIdFirst = validTicketFirst.getFlight().getFlightID();
        	flightIdSecond = validTicketSecond.getFlight().getFlightID();
            setPassengerDetails();
            System.out.println("Do you want to purchase?\n 1-YES 0-NO");
            String tempInput = in.nextLine();
            int purch = Integer.parseInt(tempInput);
            if (purch == 1){
                Flight flightFirst = FlightCollection.getFlightInfo(flightIdFirst);
                int airplaneIdFirst = flightFirst.getAirplane().getAirplaneID();
                Airplane airplaneFirst = Airplane.getAirPlaneInfo(airplaneIdFirst);
                Flight flightSecond = FlightCollection.getFlightInfo(flightIdSecond);
                int airplaneIdSecond = flightSecond.getAirplane().getAirplaneID();
                Airplane airplaneSecond  = Airplane.getAirPlaneInfo(airplaneIdSecond);
                Ticket ticketFirst = TicketCollection.getTicketInfo(ticketIdFirst);
                Ticket ticketSecond = TicketCollection.getTicketInfo(ticketIdSecond);
                ticketFirst.setPassenger(passenger);
                ticketFirst.setTicketId(ticketIdFirst);
                ticketFirst.setFlight(flightFirst);
                ticketFirst.setClassVip(ticketFirst.getClassVip());
                ticketFirst.setTicketStatus(true);
                if (ticketFirst.getClassVip())
                    airplaneFirst.setBusinessSitsNumber(airplaneFirst.getBusinessSitsNumber() - 1);
                else
                    airplaneFirst.setEconomySitsNumber(airplaneFirst.getEconomySitsNumber() - 1);
                System.out.println("--*-*-");
                ticketSecond.setPassenger(passenger);
                ticketSecond.setTicketId(ticketIdSecond);
                ticketSecond.setFlight(flightSecond);
                ticketSecond.setClassVip(ticketSecond.getClassVip());
                ticketSecond.setTicketStatus(true);
                if (ticketSecond.getClassVip())
                    airplaneSecond.setBusinessSitsNumber(airplaneSecond.getBusinessSitsNumber() - 1);
                else
                    airplaneSecond.setEconomySitsNumber(airplaneSecond.getEconomySitsNumber() - 1);
                System.out.println("--*-*-");
                ticket.setPassenger(passenger);
                ticket.setPrice(ticketFirst.getPrice() + ticketSecond.getPrice());
                System.out.println("Your bill: " + ticket.getPrice() + "\n");
                setPassengerCardDetails();
            }
        }
    }
}
