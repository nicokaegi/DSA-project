/**
 * Purpose: Data Structure and Algorithms Project
 * Status: Complete and Thoroughly Tested
 * Last update: 12/04/19
 * Submitted: 12/05/19
 * Comment: test suite and sample run attached
 *
 * @author: Theresa Morris - Section 2
 * @author: Nico Kaegi - Section 2
 *
 * @version: 2019.12.04
 */
import java.io.*;

import dependencies.ListArrayBasedPlus;
import dependencies.AscendinglyOrderedList;

public class AirTrafficControl
{
    /** List of current runways **/

    private ListArrayBasedPlus<Runway> runways;

    /** Binary Search Tree that holds all planes waiting for clearance to launch **/

    private AscendinglyOrderedList<Plane<?>, String> clearance = new AscendinglyOrderedList<Plane<?>, String>();

    /**Integer counting how many planes have taken off **/

    private int count = 0;

    /** Integer keeping our position when planes take off from runways that they may be incremented in a round robin fashion**/

    private int position = 0;

    /** Int holding the total amount of runways we have, so we may always find the end index. **/

    private int totalRunways = 0;

    public AirTrafficControl()
    {
        runways = new ListArrayBasedPlus<Runway>();
        //clearance = new AscendinglyOrderedList<Plane<?>, String>();
    }

    /**
     * Method to return our list of runways
     * @return the runways
     */

    public ListArrayBasedPlus<Runway> getRunways()
    {
        return runways;
    }

    /**
     * Method to take in a string representation of a runway name, and search the runway list to locate it.
     * @param runwayName
     * 		The runway we are searching for
     * @return the located runway
     */
    public Runway findRunway(String runwayName) {

        for(int pos = 0; pos < runways.size(); pos++) {

            if(runways.get(pos)!= null)
            {
                if(runways.get(pos).getName().equals(runwayName)) {

                    return runways.get(pos);
                }
            }
        }

        return null;

    }

    /**
     * Method to enter a plane that has been created into an already existing runway.
     * @param newPlane
     * 		the plane we are entering into a runway
     * @return whether the plane successfully entered or not.
     */
    public boolean enterAirPlane(Plane<?> newPlane) {

        //it's boolean because im to lazy to add trycatch blocks
        //create a new excpetion; plus this provideds a easy way to exit the method;

        Runway temp = findRunway(newPlane.getRunway());

        if(temp != null) {
            temp.enqueueToRunway(newPlane);
            return true;
        }
        else {
            return false;
        }
    }
    /**
     * Method to add a new runway at the end of the runway list, then return whether it was successful.
     * @param name
     * 	A string representation of a runway name
     * @return whether the runway was added or not
     */
    public boolean addRunWay(String name) {

        if(findRunway(name) == null) {
            runways.add(totalRunways, new Runway(name));
            totalRunways++;
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * MEthod that looks at what runway we need to take off from.
     * @return Plane
     * 		The plane that has taken off
     */
    public Plane<?> currentTakeOfPlane() {

        for(int n = 0; n < runways.size(); n++ ) {

            if(runways.get(position).isEmpty()) {

                position = (position + 1) % runways.size();
            }
            else {
                return runways.get(position).peekRunway();
            }
        }

        return null;
    }

    /**
     * Method that accepts whether a plane has clearance to launch or not, and then either launches it, or puts it in the clearance list.
     * @param clearnce
     * 		Whether the plane has clearance to launch
     */
    public void takeOff(boolean clearnce) {

        if(clearnce) {
            Plane tempPlane = runways.get(position).peekRunway();
            runways.get(position).dequeueFromRunway();
            System.out.println("Flight " + tempPlane.getFlightNumber() + " has now taken off from runway " + tempPlane.getRunway());
            position = (position + 1) % (runways.size());
            count++;
        } else {
            Plane tempPlane = runways.get(position).peekRunway();
            clearance.add(runways.get(position).dequeueFromRunway());
            System.out.println("Flight " + tempPlane.getFlightNumber() + " is now waiting to be allowed to re-enter a runway.");
            position = (position + 1) % (runways.size());

        }
    }

    /**
     * MEthod to return the list of planes waiting for clearance.
     * @return the clearance list
     */
    public AscendinglyOrderedList<Plane<?>, String> getClearance()
    {
        return clearance;
    }
    /**
     * method to return the count of planes launched
     * @return the count
     */
    public int getCount()
    {
        return count;
    }
    /**
     * method to return the current position in the runway list
     * @return the position
     */
    public int getPosition()
    {
        return position;
    }
    /**
     * method to set the runway list
     * @param runways
     * 		a list of runways
     */
    public void setRunways(ListArrayBasedPlus<Runway> runways)
    {
        this.runways = runways;
    }
    /**
     * method to set the clearance list
     * @param clearance
     * 		a clearance list.
     */
    public void setClearance(AscendinglyOrderedList<Plane<?>, String> clearance)
    {
        this.clearance = clearance;
    }
    /**
     * method to set the current count.
     * @param count
     * 		the current count of planes launched
     */
    public void setCount(int count)
    {
        this.count = count;
    }
    /**
     * method to set the current position in the runway list.
     * @param position
     * 		the current position in the runway list
     */
    public void setPosition(int position)
    {
        this.position = position;
    }

    /**
     * Method to have a plane from the clearance list re-enter a runway
     *
     * This is done by creating a temporary plane, retrieving the plane from the clearance list by searching by it's flight number, re-enqueuing it if it exists at all, then deleting it from the clearance list.
     *
     * @param flight
     * 		The flight number of the plane we are looking for.
     * @return whether the flight was successfully added
     */
    public boolean reEnterRunway(Plane<?> flight)
    {
        int tempIndex = clearance.search(flight);

        if(tempIndex < 0)
        {
            System.out.println("Flight " + flight.getFlightNumber() + " is not waiting for clearance.");
            return false;

        }
        else
        {
            Plane<?> tempPlane = clearance.get(tempIndex);
            clearance.remove(tempIndex);

            findRunway(tempPlane.getRunway()).enqueueToRunway(tempPlane);
            System.out.println("Flight " + tempPlane.getFlightNumber() + " is now waiting for takeoff on runway " + tempPlane.getRunway());
            return true;
        }

    }

    /**
     * Method to loop through the runway being closed to reassign all planes to new runways.
     * @param oldRunway
     * 		The runway being closed down
     * @param stdin
     * 		Our standard input, as we only need one buffered reader
     * @throws IOException
     */
    public void runwayLoop(String oldRunway, BufferedReader stdin) throws IOException
    {
        if(findRunway(oldRunway) != null)
        {
            while(!findRunway(oldRunway).isEmpty())
            {
                Plane tempPlane = findRunway(oldRunway).peekRunway();

                System.out.print("Enter new runway for plane " + tempPlane.getFlightNumber() + " : ");
                String newRunway = stdin.readLine();
                System.out.println(newRunway);

                if(findRunway(newRunway) != null)
                {
                    if(newRunway.equals(oldRunway))
                    {
                        System.out.println("This is the runway that is closing!");
                    }
                    else
                    {
                        tempPlane.setRunway(newRunway);
                        findRunway(newRunway).enqueueToRunway(tempPlane);
                        System.out.println("Flight " +tempPlane.getFlightNumber() + " is now waiting for takeoff on runway " + tempPlane.getRunway());
                        findRunway(oldRunway).dequeueFromRunway();
                    }
                }
                else
                {
                    System.out.println("No such runway!");
                }
            }
        }
    }

    /**
     * Method to look through the clearance list for any runway matching the closing runway, then reassign any of those planes to new runways, without re-enqueueing them for launch.
     * @param oldRunway
     * 		The runway being closed
     * @param stdin
     * 		The bufferedreader handling input
     * @throws IOException
     */
    public void clearanceLoop(String oldRunway, BufferedReader stdin) throws IOException
    {
        for(int i = 0; i < clearance.size(); i++)
        {
            if(clearance.get(i).getRunway().equals(oldRunway))
            {
                Plane tempPlane = clearance.get(i);
                System.out.print("Enter new runway for plane " + tempPlane.getFlightNumber() + " : ");
                String newRunway = stdin.readLine();
                System.out.println(newRunway);

                if(findRunway(newRunway) != null)
                {

                    if(newRunway.equals(oldRunway))
                    {
                        System.out.println("This is the runway that is closing!");
                    }
                    else
                    {
                        clearance.get(i).setRunway(newRunway);

                        System.out.println("Flight " + tempPlane.getFlightNumber() + " is now waiting for takeoff on Runway " + tempPlane.getRunway());
                    }
                }
                else
                {
                    System.out.println("No such runway!");
                }
            }
        }
    }
    /**
     * A method to print out the amount of planes who have taken off.
     */
    public void printCount()
    {
        System.out.println(count + " planes have taken off from the airport");
    }

    /**
     * A method to print everything waiting on the clearance list for takeoff.
     */
    public void printClearance()
    {
        if(!clearance.isEmpty())
        {
            System.out.println("These planes are waiting to be cleared to re-enter a runway:");
            System.out.println(clearance.toString());
        }
        else
        {
            System.out.println("No planes are waiting to be cleared to re-enter a runway!");
        }

    }

    /**
     * A method to print everything currently waiting on all of the runways.
     */
    public void printRunways()
    {

        for(int i = 0; i < runways.size(); i++)
        {
            if(runways.get(i).isEmpty())
            {
                System.out.println("No planes are waiting for takeoff on runway " + runways.get(i).getName() + "!");
            }
            else
            {
                System.out.println("These planes are waiting for takeoff on runway " + runways.get(i).getName());
                System.out.print(runways.get(i).toString());
            }
        }
    }

    /**
     * A method to delete a runway from the list
     * @param runway the runway we are looking to delete
     */

    public void deleteRunway(String runway)
    {
        if (findRunway(runway) != null)
        {
            runways.remove(findRunwayIndex(runway));
        }
    }

    /**
     *A method to find the INDEX of the runway we are looking to delete.
     *@param runway the runway we are looking to delete
     */
    public Integer findRunwayIndex(String runway)
    {
        for(int pos = 0; pos < runways.size(); pos++) {

            if(runways.get(pos)!=null)
            {
                if(runways.get(pos).getName().equals(runway)) {
                    return new Integer(pos);
                }
            }
        }
        return null;
    }

}
