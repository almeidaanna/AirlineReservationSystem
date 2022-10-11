package assignment.monash.edu;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Flight {
    private int flightID;
    private String departTo;
    private String departFrom;
    private String code;
    private String company;
    private Timestamp dateFrom;
    private Timestamp dateTo;
    Airplane airplane;
    public static final String DATEINPUTFORMATCHECK = "dd/MM/yyyy";

    public static final String DATEFORMATCHECKPATTERN = "^(0[1-9]|[1-2]\\d|31(?!(?:0[2469]|11))|30(?!02))\\/(0[1-9]|1[0-2])\\/([12]\\d{3})$";

    


    public Flight(int flightId, String departFrom, String departTo, String code, String company,String dateFromString, String dateToString, Airplane airplane)
    {
        this.flightID=flightId;
        setCode(code);
        setCompany(company);
        setDepartTo(departTo);
        setDepartFrom(departFrom);
        setAirplane(airplane);
        DateFormat dateFormat = new SimpleDateFormat(DATEINPUTFORMATCHECK);
        String pattern = DATEFORMATCHECKPATTERN;

        if (dateToString.matches(pattern) && dateFromString.matches(pattern))
        {
            try
            {
                Date dateFromDate = dateFormat.parse(dateFromString);
                Date dateToDate = dateFormat.parse(dateToString);
                long dateF = dateFromDate.getTime();
                long dateT = dateToDate.getTime();
                this.dateFrom =  new Timestamp(dateF);
                this.dateTo = new Timestamp(dateT);
            }
            catch (ParseException e) {
                throw new IllegalArgumentException(e);
            }

        }else {throw new IllegalArgumentException("You can not enter invalid date value, Please check it");}



    }

    public Flight() {}


    public int getFlightID() {
        return flightID;
    }

    public void setFlightID(int flightid)
    {
        if(flightid <= 0)
        {
            throw new IllegalArgumentException("FlightID can not be Zero or Empty");
        }
        else
            this.flightID = flightid;
    }

    public String getDepartTo() {
        return departTo;
    }

    public void setDepartTo(String departTo) {
        if (departTo == null)
        {
            throw new NullPointerException("DepartTo can not be Null");
        }
        else if (departTo.isBlank()||departTo.isEmpty())
        {
            throw new IllegalArgumentException("DepartTo can not be Empty");

        }

        else
        {
            this.departTo = departTo;
        }

    }

    public String getDepartFrom() {
        return departFrom;
    }

    public void setDepartFrom(String departFrom) {
        if (departFrom == null)
        {
            throw new NullPointerException("DepartFrom can not be Null");
        }
        else if (departFrom.isBlank()||departFrom.isEmpty())
        {
            throw new IllegalArgumentException("DepartFrom can not be Empty");

        }

        else
        {
            this.departFrom = departFrom;
        }
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        if (code == null)
        {
            throw new NullPointerException("Code can not be Null");
        }
        else if (code.isBlank()||code.isEmpty())
        {
            throw new IllegalArgumentException("Code can not be Empty");

        }
        else
        {
            this.code = code;
        }
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        if (company == null)
        {
            throw new NullPointerException("Company can not be Null");
        }
        else if (company.isBlank()||company.isEmpty())
        {
            throw new IllegalArgumentException("Company can not be Empty");

        }
        else
        {
            this.company = company;
        }

    }

    public Timestamp getDateFrom() {

        return dateFrom;
    }

    public void setDateFrom(String dateFromString) {
        String pattern = DATEFORMATCHECKPATTERN;
        if (dateFromString.isEmpty()|| dateFromString.isBlank())
        {
            throw new IllegalArgumentException("The Input of dateString can not be Empty or Null");
        }
        else if (!dateFromString.matches(pattern))
        {
            throw new IllegalArgumentException("This is invalid format of dateString");
        }
        else
        {
            try
            {
                DateFormat dateFormat = new SimpleDateFormat(DATEINPUTFORMATCHECK);
                Date dateFromDate = dateFormat.parse(dateFromString);
                long dateF = dateFromDate.getTime();
                this.dateFrom =  new Timestamp(dateF);
            }
            catch (ParseException cannotTransfer)
            {
                throw new IllegalArgumentException(cannotTransfer);
            }
        }


    }

    public Timestamp getDateTo() {
        return dateTo;
    }

    public void setDateTo(String dateToString) {
        String pattern = DATEFORMATCHECKPATTERN;
        if (dateToString.isEmpty()|| dateToString.isBlank())
        {
            throw new IllegalArgumentException("The Input of dateString can not be Empty or Null");
        }
        else if (!dateToString.matches(pattern))
        {
            throw new IllegalArgumentException("This is invalid format of dateString");
        }
        else {
            try
            {
                DateFormat dateFormat = new SimpleDateFormat(DATEINPUTFORMATCHECK);
                Date dateToDate = dateFormat.parse(dateToString);
                long dateT = dateToDate.getTime();
                this.dateTo =  new Timestamp(dateT);
            }
            catch (ParseException cannotTransfer)
            {
                throw new IllegalArgumentException(cannotTransfer);
            }
        }
    }

    public void setAirplane(Airplane airplane) {
        if (FlightCollection.getFlights().isEmpty() && airplane != null)
        {
            this.airplane = airplane;
        }
        else if (airplane == null)
        {
            throw new IllegalArgumentException("The airplane can not be null when you set a flight!");
        }
        else
        {
            for (Flight flight : FlightCollection.getFlights())
            {
                if (flight.getAirplane() != null && flight.getAirplane().getAirplaneID() == airplane.getAirplaneID())
                {
                    throw new IllegalArgumentException("This airplane has already used for another flight");
                }
                else
                {
                    this.airplane = airplane;
                }
            }
        }


    }

    public Airplane getAirplane() {
        return airplane;
    }

    public String toString()
    {
            return "Flight{" + airplane.toString() +
                    ", date to=" +  getDateTo() + ", " + '\'' +
                    ", date from='" + getDateFrom() + '\'' +
                    ", depart from='" + getDepartFrom() + '\'' +
                    ", depart to='" + getDepartTo() + '\'' +
                    ", code=" + getCode() + '\'' +
                    ", company=" + getCompany() + '\'' +
                    '}';
    }
}
