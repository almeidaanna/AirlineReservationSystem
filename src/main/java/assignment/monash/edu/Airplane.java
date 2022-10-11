package assignment.monash.edu;

public class Airplane
{
    private int airplaneID;
    private String airplaneModel;
    private int businessSitsNumber;
    private int economySitsNumber;
    private int crewSitsNumber;

    public Airplane(int airplaneID, String airplaneModel, int businessSitsNumber, int economySitsNumber, int crewSitsNumber)
    {
        this.airplaneID=airplaneID;
        this.airplaneModel = airplaneModel;
        this.businessSitsNumber = businessSitsNumber;
        this.economySitsNumber = economySitsNumber;
        this.crewSitsNumber = crewSitsNumber;
        totalSitNumber(this.economySitsNumber, this.crewSitsNumber, this.businessSitsNumber);
    }

    public Airplane()
    {
    }

    public int getAirplaneID() {
        return airplaneID;
    }

    public void setAirplaneID(int airplaneID) {
        if (airplaneID <= 0 )
            throw new IllegalArgumentException("AirplaneID can not be Zero or Empty");
        else
            this.airplaneID = airplaneID;
    }

    public String getAirplaneModel() {
        return airplaneModel;
    }

    public void setAirplaneModel(String airplaneModel) {

        if (airplaneModel == null)
        {
            throw new NullPointerException("AirplaneModel can not be Null");
        }
        else if (airplaneModel.isBlank()||airplaneModel.isEmpty())
        {
            throw new IllegalArgumentException("AirplaneModel can not be Empty");

        }

        else
        {
            this.airplaneModel = airplaneModel;
        }
    }

    public int getBusinessSitsNumber() {
        return businessSitsNumber;
    }

    public void setBusinessSitsNumber(int businessSitsNumber) {
        if (businessSitsNumber <= 0 || businessSitsNumber > 300)
            throw new IllegalArgumentException("BusinessSitsNumber can not be Zero or Empty");
        else
            this.businessSitsNumber = businessSitsNumber;
    }

    public int getEconomySitsNumber() {
        return economySitsNumber;
    }

    public void setEconomySitsNumber(int economySitsNumber) {
        if(economySitsNumber <= 0 || economySitsNumber > 300)
            throw new IllegalArgumentException("EconomySitsNumber can not be Zero or Empty");
        else
            this.economySitsNumber = economySitsNumber;
    }

    public int getCrewSitsNumber() {
        return crewSitsNumber;
    }

    public void setCrewSitsNumber(int crewSitsNumber) {
        if (crewSitsNumber <= 0 || crewSitsNumber >300)
            throw new IllegalArgumentException("CrewSitsNumber can not be Zero or Empty");
        else
            this.crewSitsNumber = crewSitsNumber;
    }

    public void totalSitNumber(int economySitsNumber, int crewSitsNumber , int businessSitsNumber)
    {
        int totalSits = economySitsNumber + crewSitsNumber + businessSitsNumber;
        if (totalSits < 1 || totalSits > 300)
            throw new IllegalArgumentException("Total number of sits should between 1 to 300");
        else
        {
            this.economySitsNumber = economySitsNumber;
            this.businessSitsNumber = businessSitsNumber;
            this.crewSitsNumber = crewSitsNumber;
        }

    }

    public String toString()
    {
        return "Airplane{" +
                "model=" + getAirplaneModel() + '\'' +
                ", business sits=" + getBusinessSitsNumber() + '\'' +
                ", economy sits=" + getEconomySitsNumber() + '\'' +
                ", crew sits=" + getCrewSitsNumber() + '\'' +
                '}';
    }

	public static Airplane getAirPlaneInfo(int airplaneId) {
        for (Flight flight:FlightCollection.getFlights())
            if (flight.getAirplane().airplaneID == airplaneId)
                return flight.getAirplane();
		return null;
	}
}