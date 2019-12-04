/**
 * Purpose: Data Structure and Algorithms Project
 * Status: Barely started
 * Last update: 12/04/19
 * Submitted: 12/05/19
 * Comment: test suite and sample run attached
 *
 * @author: Theresa Morris - Section 2
 *
 * @author: Nico Kaegi - Section 2
 *
 * @version: 2019.12.04
 */
import dependencies.KeyedItem;

public class Plane<KT> extends KeyedItem<String>
{
    /** A string to hold our flight number (this is our comparable field) **/
    private String flightNumber;
    /** A string to hold our destination **/
    private String destination;
    /** a string representation of the runway this belongs on. for use in reentering runways **/
    private String runway;

    public Plane(String flight, String dest, String run)
    {
        super(flight);
        flightNumber = flight;
        destination = dest;
        runway = run;
    }

    /**
     * A method to return the flight number
     * @return the flightNumber
     */
    public String getFlightNumber()
    {
        return flightNumber;
    }

    /**
     * a method to return the destination
     *
     * @return the destination
     */
    public String getDestination()
    {
        return destination;
    }

    /**
     * A method to return the name of the runway
     * @return the runway
     */
    public String getRunway()
    {
        return runway;
    }

    /**
     * a method to set the flight number
     * @param flightNumber the flightNumber to set
     */
    public void setFlightNumber(String flightNumber)
    {
        this.flightNumber = flightNumber;
    }

    /**
     * a method to set the desination
     * @param destination the destination to set
     */
    public void setDestination(String destination)
    {
        this.destination = destination;
    }

    /**
     * a method to set the runway
     * @param runway the runway to set
     */
    public void setRunway(String runway)
    {
        this.runway = runway;
    }

    @Override
    /**
     * toString takes the flight number and destination, and concatinates them into a single string.
     */
    public String toString()
    {
        return "Flight " + flightNumber + " to " + destination + ".";
    }



}
