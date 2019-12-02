import dependencies.AscendinglyOrderedList;
import dependencies.ListArrayBasedPlus;

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
public class AirTrafficControl
{
    private ListArrayBasedPlus<Runway> runways = new ListArrayBasedPlus<Runway>();
    private AscendinglyOrderedList<Plane<?>, String> clearance = new AscendinglyOrderedList<Plane<?>, String>();
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
            clearance.add(runways.get(position).dequeueFromRunway());

            position = (position + 1) % runways.size();

        }

    }

    public AscendinglyOrderedList<Plane<?>, String> getClearance()
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
    public void setClearance(AscendinglyOrderedList<Plane<?>, String> clearance)
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
        Plane tempPlane = getFromClearance(flight);

        if (tempPlane != null)
        {
            Runway tempRunway = findRunway(tempPlane.getRunway());

            tempRunway.enqueueToRunway(tempPlane);

            // clearance.remove();
        } else
        {
            System.out.println("Flight " + flight + " is not waiting for clearance.");
        }
    }

    private Plane getFromClearance(String flight)
    {
    	//clearance.search(flight);
    	
    	return null;
    }
    
    public void runwayClosure(String oldRunway, String newRunway)
    {
    	
    	
    }
    /*
     Not using htis because find runway is the same thing.

        private Runway matchRunway(String runway)
        {
    	Runway retrievedRunway = null;

    	return retrievedRunway;
        }
    */
    
    public void printCount()
    {
    	System.out.println(count + " planes have taken off from the airport");
    }

    public void printClearance()
    {
    	for(int i = 0; i < clearance.size(); i++)
    	{
    		System.out.println(clearance.get(i).toString());
    	}
    }
    
    public void printRunways()
    {
    	for(int i = 0; i < runways.size(); i++)
    	{
    		System.out.println("These planes are waiting for takeoff on runway " + runways.get(i).getName());
    		runways.get(i).toString();		
    	}
    }
   


}
