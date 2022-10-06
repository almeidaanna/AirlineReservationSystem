import fit5171.monash.edu.*;
import junit.framework.Assert;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;
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
 //   Scanner in;
 //   TicketCollection ticketCollection;

    @BeforeAll
    static  void initAll(){
        BuyTicketTest buyTicketTest = new BuyTicketTest();
    }

    @BeforeEach
    public void init(){
        //buyTicket = new BuyTicket();
        //passenger = spy(Passenger.class);
//        ticket = spy(Ticket.class);
//        flight = mock(Flight.class);
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
    void testValidPassenger()
    {
        int inputTicketId = 10024;
        Passenger expectedPassenger = new Passenger("Jane", "Doe", 43, "Female", "janedoe@gmail.com", "0458353978", "M79843234","1234567891012345", 123);
        String expected = expectedPassenger.toString();
        Airplane airplane = new Airplane(101, "Airbus", 30, 60, 4);
        flight = new Flight(34567, "Mel", "Syd", "A342", "Boeing", "12/09/2022","18/09/2022", airplane );
        FlightCollection.addFlights(flight);
        Ticket ticket = new Ticket(10024, 1000, flight, true, passenger);
        TicketCollection.addTicket(ticket);
        try {
            String userInput = "Jane\nDoe\n43\n\nFemale\njanedoe@gmail.com\n0458353978\nM79843234\n1\n1234567891012345\n123";
            System.setIn(new ByteArrayInputStream(userInput.getBytes()));
            buyTicket = new BuyTicket();
            buyTicket.buyTicket(inputTicketId);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        String actual = buyTicket.getPassenger().toString();
        assertEquals(expected, actual);
    }

    @Test
    void testInvalidPassenger()
    {
        int inputTicketId = 10024;
        Airplane airplane = new Airplane(101, "Airbus", 30, 60, 4);
        flight = new Flight(34567, "Mel", "Syd", "A342", "Boeing", "12/09/2022","18/09/2022", airplane );
        FlightCollection.addFlights(flight);
        Ticket ticket = new Ticket(10024, 1000, flight, true, passenger);
        TicketCollection.addTicket(ticket);
        String userInput = "Jane\nDoe\n43\n\nFemale\n\n\n0458353978\nM79843234\n1\n1234567891012345\n123";
        Throwable actual = assertThrows(java.lang.IllegalArgumentException.class, () ->{
            try {
                System.setIn(new ByteArrayInputStream(userInput.getBytes()));
                buyTicket = new BuyTicket();
                buyTicket.buyTicket(inputTicketId);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
        String expected = "Email can not be empty";
        assertEquals(expected, actual.getMessage());
    }

    @Test
    void testFlightInformation()
    {

    }

    @Test
    void testTicketInformation()
    {

    }
    @Test
    void testBuyTicketValidity() throws Exception {
    }

    @Test
    void testTicketValid()
    {
    }

}