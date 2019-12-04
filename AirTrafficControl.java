/**
 * Purpose: Data Structure and Algorithms Project
 * Status: Barely started
 * Last update: 12/02/19
 * Submitted: 12/05/19
 * Comment: test suite and sample run attached
 *
 * @author: Theresa Morris - Section 2
 *
 * @author: Nico Kaegi - Section 2
 *
 * @version: 2019.12.02 AirTrafficControl.java
 */
import java.io.*;

import dependencies.ListArrayBasedPlus;
import dependencies.MyBinarySearchTreePlus;

public class AirTrafficControl
{
    /** List of current runways **/

    private ListArrayBasedPlus<Runway> runways = new ListArrayBasedPlus<Runway>();
    
    /** Binary Search Tree that holds all planes waiting for clearance to launch **/
    
    private MyBinarySearchTreePlus<Plane<?>, String> clearance = new MyBinarySearchTreePlus<Plane<?>, String>();
    
    /**Integer counting how many planes have taken off **/
    
    private int count = 0;
    
    /** Integer keeping our position when planes take off from runways that they may be incremented in a round robin fashion**/
    
    private int position = 0;
    
    /** Int holding the total amount of runways we have, so we may always find the end index. **/
    
    private int totalRunways = 0;
    
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


	try{
            return runways.get(position).peekRunway();

        }
        catch( Exception E ){

            position = (position + 1) % runways.size();

            return null;


        }
    }

    /**
     * Method that accepts whether a plane has clearance to launch or not, and then either launches it, or puts it in the clearance list.
     * @param clearnce
     * 		Whether the plane has clearance to launch
     */
    public void takeOff(boolean clearnce) {

        if(clearnce) {

            position = (position + 1) % runways.size();

            runways.get(position).dequeueFromRunway();

            count++;

        } else {

            clearance.insert(runways.get(position).dequeueFromRunway());

            position = (position + 1) % runways.size();

        }

    }

    /**
     * MEthod to return the list of planes waiting for clearance.
     * @return the clearance list
     */
    public MyBinarySearchTreePlus<Plane<?>, String> getClearance()
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
    public void setClearance(MyBinarySearchTreePlus<Plane<?>, String> clearance)
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
     */
    public void reEnterRunway(String flight)
    {
        Plane<?> tempPlane = clearance.retrieve(flight);

        if (tempPlane != null)
        {
            Runway tempRunway = findRunway(tempPlane.getRunway());

            tempRunway.enqueueToRunway(tempPlane);
            System.out.println("Flight " + flight + " is now waiting for takeoff on runway " + tempPlane.getRunway());
            clearance.delete(flight);
        } else
        {
            System.out.println("Flight " + flight + " is not waiting for clearance.");
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
        Runway tempRunway = findRunway(oldRunway);

        while(!tempRunway.isEmpty())
        {
            Plane<?> tempPlane = tempRunway.dequeueFromRunway();

            System.out.println("Enter new runway for plane " + tempPlane.getFlightNumber() + " : ");
            String newRunway = stdin.readLine();

            if(newRunway.equals(oldRunway))
            {
                System.out.println("This is the runway that is closing!");
            }
            else if(findRunway(newRunway) != null)
            {
                tempPlane.setRunway(newRunway);

                System.out.println("Flight " + tempPlane.getFlightNumber() + " is now waiting for takeoff on Runway " + tempPlane.getRunway());
            }
            else
            {
                System.out.println("No such runway!");
            }

        }

    }

    /**
     * Method to flatten the clearance list (into a new list), look through that for anything matching the runway being closed, then reassign any of those planes to new runways, without re-enqueueing them for launch.
     * @param oldRunway
     * 		The runway being closed
     * @param stdin
     * 		The bufferedreader handling input
     * @throws IOException
     */
    public void clearanceLoop(String oldRunway, BufferedReader stdin) throws IOException
    {
        ListArrayBasedPlus<Plane<?>> tempClosure = new ListArrayBasedPlus<Plane<?>>();

        ListArrayBasedPlus<Plane<?>> flatTree = clearance.flattenTree();

        for(int i = 0; i < flatTree.size(); i++)
        {
            if(flatTree.get(i).getRunway().equals(oldRunway))
            {
                tempClosure.add(0,  flatTree.get(i));
            }
        }

        for(int i = 0; i<tempClosure.size(); i++)
        {
            Plane tempPlane = tempClosure.get(i);

            System.out.println("Enter new runway for plane " + tempPlane.getFlightNumber() + " : ");
            String newRunway = stdin.readLine();

            if(newRunway.equals(oldRunway))
            {
                System.out.println("This is the runway that is closing!");
            }
            else if(findRunway(newRunway) != null)
            {
                tempPlane.setRunway(newRunway);

                System.out.println("Flight " + tempPlane.getFlightNumber() + " is now waiting for takeoff on Runway " + tempPlane.getRunway());
            }
            else
            {
                System.out.println("No such runway!");
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
        System.out.println("These planes are waiting to be cleared to re-enter a runway:");
        System.out.println(clearance.toStringInorder());
    }

    /**
     * A method to print everything currently waiting on all of the runways.
     */
    public void printRunways()
    {
        for(int i = 0; i < runways.size(); i++)
        {
            System.out.println("These planes are waiting for takeoff on runway " + runways.get(i).getName());
            System.out.print(runways.get(i).toString());
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


    public Integer findRunwayIndex(String runway)
    {
        for(int pos = 0; pos < runways.size(); pos++) {

            if(runways.get(pos)!=null)
            {
                if(runways.get(pos).getName().equals(runway)) {

                    return pos;
                }
            }

        }

        return null;
    }


}
