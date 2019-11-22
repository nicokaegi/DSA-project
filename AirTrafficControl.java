public class AirTrafficControl
{
    private ListArrayBasedPlus<Runway> runways;
    private ListArrayBasedPlus<Plane> clearance;
    private int count = 0;
    private int position = 0;
    /**
     * @return the runways
     */
    public ListArrayBasedPlus<Runway> getRunways()
        {
    	return runways;
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
    
    
}