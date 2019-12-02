import dependencies.AscendinglyOrderedList;
import dependencies.ListArrayBasedPlus;

public class AirTrafficControl
{
    private ListArrayBasedPlus<Runway> runways;
    private AscendinglyOrderedList<Plane<?>, String> clearance;
    private int count = 0;
    private int position = 0;// assuming position refered to runways
    /**
     * @return the runways
     */
    public ListArrayBasedPlus<Runway> getRunways()
        {
    	return runways;
        }

    public Runway findRunway(String runwayName){
    
	for(int pos = 0; pos < runways.size(); pos++){
	
		if(runways.get(pos).getName().equals(runwayName)){
		
			return runways.get(pos);
		}
	
	}

	return null;	

    }
    
    public boolean enterAirPlane(Plane newPlane){

      //it's boolean because im to lazy to add trycatch blocks
      //create a new excpetion; plus this provideds a easy way to exit the method;

		Runway temp = findRunway(newPlane.getRunway());

		if(temp != null){
		
			temp.enqueueToRunway(newPlane);

			return true;	
		
		}
		else{
		
			return false;
		
		}	
      

    }
    /**
     * @return the clearance
     */

    public boolean addRunWay(String name){
    
    		if(findRunway(name) == null){
		

			runways.add(runways.size(), new Runway(name));
		
			return true;		
		
		}
		else{
		
		 	return false;
		
		}
    
    }

    public Plane currentTakeOfPlane(){

	    return runways.get(position).peekRunway();
    }

    public void takeOff(boolean clearnce){
    
   	if(clearnce){	
		
		position = (position + 1) % runways.size();
		
                runways.get(position).dequeueFromRunway();

	}else{
		
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
		Plane tempPlane = verifyRunway(flight);

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

    private Plane verifyRunway(String flight)
	{
    //I'm still working on this function, however I want this to be able to at least not spit out errors.
    //Basically I got another idea and am gonna run with it.
	    return null;
	}
/*
 Not using htis because find runway is the same thing.
 
    private Runway matchRunway(String runway)
    {
	Runway retrievedRunway = null;

	return retrievedRunway;
    }
*/



}
