import java.io.*;

import dependencies.AscendinglyOrderedList;
import dependencies.ListArrayBasedPlus;
import dependencies.MyBinarySearchTreePlus;

/*
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
/**
 * @author morris85
 *
 */
public class AirTrafficControl
{
    private ListArrayBasedPlus<Runway> runways = new ListArrayBasedPlus<Runway>();
    private MyBinarySearchTreePlus<Plane<?>, String> clearance = new MyBinarySearchTreePlus<Plane<?>, String>();
    private int count = 0;
    private int position = 0;// This is our position in the runway list.
    private int totalRunways = 0;//need this to keep adding runways to the end of the list.
    /**
     * @return the runways
     */
    public ListArrayBasedPlus<Runway> getRunways()
    {
        return runways;
    }

    /**
     * @param runwayName
     * @return
     */
    public Runway findRunway(String runwayName) {

        if(runways.size() == 0)
        {
            return null;
        }
        for(int pos = 0; pos < runways.size(); pos++) {

            if(runways.get(pos)!=null)
            {
                if(runways.get(pos).getName().equals(runwayName)) {

                    return runways.get(pos);
                }
            }
        }

        return null;

    }

    public boolean enterAirPlane(Plane newPlane) {

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
     * @return the clearance
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

    public Plane currentTakeOfPlane() {

        return runways.get(position).peekRunway();
    }

    public void takeOff(boolean clearnce) {

        if(clearnce) {

            position = (position + 1) % runways.size();

            runways.get(position).dequeueFromRunway();

        } else {

            //this is temporary since i belive you had an idea to make this more effeciant
            //I HOPEFULLY have the ascendingly ordered list genericed, so adding to it we just add and it'll sort in fine.
            clearance.insert(runways.get(position).dequeueFromRunway());

            position = (position + 1) % runways.size();

        }

    }

    public MyBinarySearchTreePlus<Plane<?>, String> getClearance()
    {
        return clearance;
    }
    /**
     * @return the count
     */
    public int getCount()
    {
        return count;
    }
    /**
     * @return the position
     */
    public int getPositioni()
    {
        return position;
    }
    /**
     * @param runways the runways to set
     */
    public void setRunways(ListArrayBasedPlus<Runway> runways)
    {
        this.runways = runways;
    }
    /**
     * @param clearance the clearance to set
     */
    public void setClearance(MyBinarySearchTreePlus<Plane<?>, String> clearance)
    {
        this.clearance = clearance;
    }
    /**
     * @param count the count to set
     */
    public void setCount(int count)
    {
        this.count = count;
    }
    /**
     * @param position the position to set
     */
    public void setPosition(int position)
    {
        this.position = position;
    }

    public void reEnterRunway(String flight)
    {
        Plane tempPlane = clearance.retrieve(flight);

        if (tempPlane != null)
        {
            Runway tempRunway = findRunway(tempPlane.getRunway());

            tempRunway.enqueueToRunway(tempPlane);
            System.out.println("Flight " + flight + " is now waiting for takeoff on runway " + tempPlane.getRunway());

            // clearance.remove();
        } else
        {
            System.out.println("Flight " + flight + " is not waiting for clearance.");
        }
    }
    
    /**
     * @param oldRunway
     * @param stdin
     * @throws IOException
     */
    public void runwayLoop(String oldRunway, BufferedReader stdin) throws IOException
    {
    	Runway tempRunway = findRunway(oldRunway);
    	
    	while(!tempRunway.isEmpty())
    	{
    		Plane tempPlane = tempRunway.dequeueFromRunway();
    		
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
    
    public void closureLoop(String oldRunway, BufferedReader stdin)
    {
    	ListArrayBasedPlus tempClosure = new ListArrayBasedPlus();
    	
    	Plane tempPlane = clearance.retrieve(oldRunway);
    	
    	while(tempPlane != null)
    	{
    		tempClosure.add(0, tempPlane);
    		tempPlane = clearance.retrieve(oldRunway);
    	}
    }

    
    public void printCount()
    {
    	System.out.println(count + " planes have taken off from the airport");
    }

    public void printClearance()
    {
    	System.out.println("These planes are waiting to be cleared to re-enter a runway:");
    	System.out.println(clearance.toStringInorder());
    	/*for(int i = 0; i < clearance.size(); i++)
    	{
    		System.out.println(clearance.get(i).toString());
    	}
    	*/
    }
    
    public void printRunways()
    {
    	for(int i = 0; i < runways.size(); i++)
    	{
    		System.out.println("These planes are waiting for takeoff on runway " + runways.get(i).getName());
    		System.out.print(runways.get(i).toString());		
    	}
    }
   


}
