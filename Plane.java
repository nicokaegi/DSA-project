public class Plane
{
    private String flightNumber;
    private String destination;
    private String runway;

    public Plane(String flight, String dest, String run)
    {
	flightNumber = flight;
	destination = dest;
	runway = run;
    }

    /**
     * @return the flightNumber
     */
    public String getFlightNumber()
        {
    	return flightNumber;
        }

    /**
     * @return the destination
     */
    public String getDestination()
        {
    	return destination;
        }

    /**
     * @return the runway
     */
    public String getRunway()
        {
    	return runway;
        }

    /**
     * @param flightNumber the flightNumber to set
     */
    public void setFlightNumber(String flightNumber)
        {
    	this.flightNumber = flightNumber;
        }

    /**
     * @param destination the destination to set
     */
    public void setDestination(String destination)
        {
    	this.destination = destination;
        }

    /**
     * @param runway the runway to set
     */
    public void setRunway(String runway)
        {
    	this.runway = runway;
        }

    @Override
    public String toString()
	{
	    return "Plane [flightNumber=" + flightNumber + ", destination=" + destination + ", runway=" + runway + "]";
	}



}
