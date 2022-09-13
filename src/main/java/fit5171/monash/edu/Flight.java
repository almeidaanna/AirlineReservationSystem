package fit5171.monash.edu;

import java.sql.Timestamp;
import java.util.Calendar;

public class Flight {
    private int flightID;
    private String departTo;
    private String departFrom;
    private String code;
    private String company;
    private Timestamp dateFrom;
    private Timestamp dateTo;
    Airplane airplane;

    


    public Flight(int flight_id, String departTo, String departFrom, String code, String company, Timestamp dateFrom,Timestamp dateTo, Airplane airplane)
    {
            this.flightID=flight_id;
            this.departTo = departTo;
            this.departFrom = departFrom;
            this.code = code;
            this.company = company;
            this.airplane = airplane;
            this.dateTo = dateTo;
            this.dateFrom = dateFrom;
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

    public void setDateFrom(Timestamp dateFrom) {

        this.dateFrom = dateFrom;
    }

    public Timestamp getDateTo() {
        return dateTo;
    }

    public void setDateTo(Timestamp dateTo) {
        this.dateTo = dateTo;
    }

    public void setAirplane(Airplane airplane) {
        this.airplane = airplane;
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
                    ", code=" + getCode() + '\'' +
                    '}';
    }
}
