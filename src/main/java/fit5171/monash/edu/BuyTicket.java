package fit5171.monash.edu;

import java.util.*;
import java.util.regex.PatternSyntaxException;

public class BuyTicket <T>
{

    Passenger passenger;
    Ticket ticket;
    Flight flight;
    Scanner in;

    public BuyTicket()
    {
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

    public void buyTicket(int ticket_id) throws Exception{
        //method for buying one ticket with direct flight
        int flight_id = 0;

        //select ticket where ticket_id="+ticket_id"
        Ticket validTicket = TicketCollection.getTicketInfo(ticket_id);

        //if there is a valid ticket id was input then we buy it, otherwise show message
        if(validTicket == null)
            System.out.println("This ticket does not exist.");
        else{
        	//select flight_id from ticket where ticket_id=" + ticket_id
        
            flight_id = validTicket.getFlight().getFlightID();
            
            try
            {
                getPassengerDetails();
                String tempInput;

                System.out.println("Do you want to purchase?\n 1-YES 0-NO");
                tempInput = in.nextLine();
                int purch = Integer.parseInt(tempInput);
                if (purch == 0)
                    return;
                else
                {
                    flight = FlightCollection.getFlightInfo(flight_id);
                    int airplane_id = flight.getAirplane().getAirplaneID();
                    Airplane airplane = Airplane.getAirPlaneInfo(airplane_id);

                    ticket = TicketCollection.getTicketInfo(ticket_id);
                    ticket.setPassenger(passenger);
                    ticket.setTicketId(ticket_id);
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

                getPassengerCardDetails();
            }
            catch (PatternSyntaxException patternException) {
                patternException.printStackTrace();
            }
        }
    }

    private void getPassengerCardDetails() {
        String tempInput;
        System.out.println("Enter your card number:");
        String cardNumber = in.nextLine();
        passenger.setCardNumber(cardNumber);

        System.out.println("Enter your security code:");
        tempInput = in.nextLine();
        int securityCode = Integer.parseInt(tempInput);
        passenger.setSecurityCode(securityCode);
    }

    private void getPassengerDetails() {
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

        System.out.println("Enter your e-mail address");
        String email = in.nextLine();
        passenger.setEmail(email);

        System.out.println("Enter your phone number (+7):");
        String phoneNumber = in.nextLine();
        passenger.setPhoneNumber(phoneNumber);

        System.out.println("Enter your passport number:");
        String passportNumber = in.nextLine();
        passenger.setPassport(passportNumber);
    }

    @SuppressWarnings("null")
	public void buyTicket(int ticket_id_first, int ticket_id_second) throws Exception{
		 //method for buying two tickets with transfer flight
        int flight_id_first = 0;
        
        int flight_id_second = 0;

   
        System.out.println(ticket_id_first + " " + ticket_id_second);
        
        Ticket validTicketfirst = TicketCollection.getTicketInfo(ticket_id_first);
        
        Ticket validTicketSecond = TicketCollection.getTicketInfo(ticket_id_first);
        
      
        System.out.println("Processing...");
        
        //if there is a valid ticket id was input then we buy it, otherwise show message
        
         if(validTicketfirst!=null || validTicketSecond!=null)
        {
            System.out.println("This ticket does not exist.");
            return;
        }

        else
        {
        	flight_id_first = validTicketfirst.getFlight().getFlightID();
        	
        	flight_id_second = validTicketfirst.getFlight().getFlightID();

            try{
                getPassengerDetails();
                
                System.out.println("Do you want to purchase?\n 1-YES 0-NO");
                int purch = in.nextInt();
                if (purch == 0)
                    return;
                else {
                  //  "select * from flight, airplane where flight_id=" + flight_id_first + " and flight.airplane_id=airplane.airplane_id");
                    Flight flight_first = FlightCollection.getFlightInfo(flight_id_first);
                	int airplane_id_first = flight_first.getAirplane().getAirplaneID();
                    Airplane airplane_first = Airplane.getAirPlaneInfo(airplane_id_first);

                    Flight flight_second = FlightCollection.getFlightInfo(flight_id_second);
                	int airplane_id_second = flight_second.getAirplane().getAirplaneID();
                    Airplane airpairplane_second  = Airplane.getAirPlaneInfo(airplane_id_second);
                 
                    Ticket ticket_first = TicketCollection.getTicketInfo(ticket_id_first);
                    
                    Ticket ticket_second = TicketCollection.getTicketInfo(ticket_id_second);
    	             
                    ticket_first.setPassenger(passenger);
                    ticket_first.setTicketId(ticket_id_first);
                    ticket_first.setFlight(flight_first);
                    ticket_first.setPrice(ticket_first.getPrice());
                    ticket_first.setClassVip(ticket_first.getClassVip());
                    ticket_first.setTicketStatus(true);
                    
                    if (ticket_first.getClassVip())
                    	airplane_first.setBusinessSitsNumber(airplane_first.getBusinessSitsNumber() - 1);
                    else
                    	airplane_first.setEconomySitsNumber(airplane_first.getEconomySitsNumber() - 1);

                    System.out.println("--*-*-");
                    
                    ticket_second.setPassenger(passenger);
                    ticket_second.setTicketId(ticket_id_second);
                    ticket_second.setFlight(flight_first);
                    ticket_second.setPrice(ticket_second.getPrice());
                    ticket_second.setClassVip(ticket_second.getClassVip());
                    ticket_second.setTicketStatus(true);

                    if (ticket_second.getClassVip())
                    	airpairplane_second.setBusinessSitsNumber(airpairplane_second.getBusinessSitsNumber() - 1);
                    else
                    	airpairplane_second.setEconomySitsNumber(airpairplane_second.getEconomySitsNumber() - 1);
                    
                    System.out.println("--*-*-");

                    ticket.setPrice(ticket_first.getPrice() + ticket_second.getPrice());
                    
                    System.out.println("Your bill: " + ticket.getPrice() + "\n");
                    getPassengerCardDetails();
                }
            }
            catch (PatternSyntaxException patternException){
                patternException.printStackTrace();
            }
        }
    }
}
