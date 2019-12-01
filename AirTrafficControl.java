public class AirTrafficControl
{
    private ListArrayBasedPlus<Runway> runways;
    private ListArrayBasedPlus<Plane> clearance;
    private int count = 0;
    private int setToTakeOf = 0;// assuming position refered to runways
    /**
     * @return the runways
     */
    public ListArrayBasedPlus<Runway> getRunways()
        {
    	return runways;
        }

    public boolean enterAirPlane(Plane newPlane){

      //it's boolean because im to lazy to add trycatch blocks
      //create a new excpetion; plus this provideds a easy way to exit the method;

      for(int pos = 0; pos < runways.size(); pos++){

            if(runways.get(pos).getName().equals(newPlane.getRunway())){

                    runways.enqueueToRunway(newPlane);

                    return true;

            }

            return false;

      }

    }
    /**
     * @return the clearance
     */
    public ListArrayBasedPlus<Plane> getClearance()
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
    public int getPosition()
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
    public void setClearance(ListArrayBasedPlus<Plane> clearance)
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

	if(tempPlane != null)
	    {
		Runway tempRunway = matchRunway(tempPlane.getRunway());

		tempRunway.enqueueToRunway(tempPlane);

		//clearance.remove();
	    }
	else
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

    private Runway matchRunway(String runway)
    {
	Runway retrievedRunway = null;

	return retrievedRunway;
    }




}
