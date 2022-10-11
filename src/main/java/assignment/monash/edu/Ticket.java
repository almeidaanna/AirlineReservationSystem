package assignment.monash.edu;
public class Ticket
{
    private int ticketId;
    private int price;
    Flight flight;
    private boolean classVip; //indicates if this is bussiness class ticket or not
    private boolean status; //indicates status of ticket: if it is bought by someone or not
    Passenger passenger;

    public Ticket(int ticketId, int price, Flight flight, boolean classVip, Passenger passenger)
    {
        this.ticketId = ticketId;
        this.price = price;
        this.flight = flight;
        this.classVip = classVip;
        this.status = false;
        this.passenger=passenger;
    }

    public Ticket() {

    }

    public int getTicketId() {
        return ticketId;
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }

    public int getPrice() { return price; }

    public void setPrice(int price)
    {
        if(price > 0) {
            this.price = price;
            saleByAge(passenger.getAge()); //changes price of the ticket according to the age category of passenger
            serviceTax(); //changes price by adding service tax to the ticket
        }
        else
            throw new IllegalArgumentException("Invalid Price");

    }

    public void saleByAge(int age)
    {
        int salePrice = getPrice();
        if(age == 0)
            throw new IllegalArgumentException("Invalid age");
        else if(age < 15)
        {
            salePrice-= salePrice*0.5;//50% sale for children under 15
            this.price=salePrice;

        } else if(age>=60){
            this.price=0; //100% sale for elder people
        }
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public boolean getClassVip() {
        return classVip;
    }

    public void setClassVip(boolean classVip) {
        this.classVip = classVip;
    }

    public boolean ticketStatus()
    {
        return status;
    }

    public void setTicketStatus(boolean status)
    {
        if(flight == null || passenger == null)
            throw new IllegalArgumentException();
        else
            this.status = status;
    }

    public void serviceTax(){
        this.price *= 1.12;
    } //12% service tax

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    public String toString()
    {
        return"Ticket{" +'\n'+
                "Price=" + getPrice() + "KZT, " + '\n' +
                getFlight() +'\n'+ "Vip status=" + getClassVip() + '\n' +
                getPassenger()+'\n'+ "Ticket was purchased=" + ticketStatus() + "\n}";
    }
}
