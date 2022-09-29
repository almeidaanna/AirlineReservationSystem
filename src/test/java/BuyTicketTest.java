import fit5171.monash.edu.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

@DisplayName("Test class for BuyTicket")
public class BuyTicketTest {
    private BuyTicket buyTicket;
    //https://stackoverflow.com/questions/1647907/junit-how-to-simulate-system-in-testing
//    private final InputStream systemIn = System.in;
//    private final PrintStream systemOut = System.out;
//
//    private ByteArrayInputStream testIn;
//    private ByteArrayOutputStream testOut;

    Passenger passenger;
    Ticket ticket;
    Flight flight;
    Scanner userInput;
    TicketCollection ticketCollection;

    @BeforeAll
    static  void initAll(){
        BuyTicketTest buyTicketTest = new BuyTicketTest();
    }

    @BeforeEach
    public void init(){
        buyTicket = new BuyTicket();
        passenger = spy(Passenger.class);
        ticket = spy(Ticket.class);
        flight = mock(Flight.class);
//        userInput = mock(Scanner.class);

//        final String testString = "Hello!";
//        provideInput(testString);
//
//        BuyTicket.main(new String[0]);
//
//        assertEquals(testString, getOutput());
//        ticketCollection = mock(TicketCollection.class);

    }
    @Test
    void testPassengerInformation()
    {

    }

    @Test
    void testFlightInformation()
    {

    }

    @Test
    void testTicketInformation()
    {

    }
//    @Test
//    void testBuyTicketValidity() throws Exception {
//        int inputTicketId = 10024;
//        Ticket ticket = new Ticket(10024, 1000, flight, true, passenger);
//        when(TicketCollection.getTicketInfo()).thenReturn(ticket);
//        when(ticket.getFlight().getFlightID()).thenReturn(1001);
//        when(FlightCollection.getFlightInfo(1254));
//        Airplane airplane = new Airplane(101, "Airbus", 30, 60, 4);
//        when(Airplane.getAirPlaneInfo(101)).thenReturn(airplane);
//        when(ticket.getClassVip()).thenReturn(true);
//        when(ticket.getPrice()).thenReturn(1120);
//        buyTicket.buyTicket(inputTicketId);
//    }

//    @Test
//    void testTicketValid()
//    {
////        passenger = mock(Passenger.class);
////        ticket = spy(Ticket.class);
////        flight = mock(Flight.class);
////        Airplane airplane = new Airplane(101, "Airbus", 30, 60, 4);
////        Passenger newPassenger = new Passenger("Jane", "Doe", 43, "Female", "janedoe@gmail.com", "0458353978", "M79843234","1234567891012345", 123);
////        Flight newflight = new Flight(34567, "Mel", "Syd", "A342", "Boeing", "12/09/2022","18/09/2022", airplane );
////        Ticket newticket = new Ticket(1234, 1000,newflight, false,newPassenger);
//
////        TicketCollection.addTicket(newticket);
////
////        try {
////            buyTicket.buyTicket(1234);
////        } catch (Exception e) {
////            throw new RuntimeException(e);
////        }
//
////        assertTrue(newticket.ticketStatus());
//        buyTicket.setTicket(ticket);
//        buyTicket.getTicket().setTicket_id(10136);
//        buyTicket.getTicket().setPrice(1000);
//        buyTicket.getTicket().setFlight(flight);
//        buyTicket.getTicket().setClassVip(false);
//        buyTicket.getTicket().setTicketStatus(false);
//        buyTicket.getTicket().setPassenger((passenger));
//
//        assertEquals(10136, buyTicket.getTicket().getTicket_id());
//        assertEquals(1000*1.12, buyTicket.getTicket());
//        assertEquals(flight, buyTicket.getTicket().getFlight());
//        assertEquals(false, buyTicket.getTicket().getClassVip());
//        assertEquals(false, buyTicket.getTicket().ticketStatus());
//        assertEquals(10136, buyTicket.getTicket().getTicket_id());
//    }

}