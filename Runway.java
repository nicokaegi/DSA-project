public class Runway
{
    String name;
    //Figuring out how to get this to work tbh.
    QueueSLS<Plane> planes;
    /**
     * @return the name
     */
    
    public Runway(String name){
    
    	this.name = name;
    
    }
    
    public String getName()
        {
    	return name;
        }
    /**
     * @return the planes
     */
    public QueueSLS<Plane> getPlanes()
        {
    	return planes;
        }
    /**
     * @param name the name to set
     */
    public void setName(String name)
        {
    	this.name = name;
        }
    /**
     * @param planes the planes to set
     */
    public void setPlanes(QueueSLS<Plane> planes)
        {
    	this.planes = planes;
        }
    @Override
    public String toString()
	{
	    return "Runway [name=" + name + ", planes=" + planes + "]";
	}
    
    public void enqueueToRunway(Plane plane)
    {
	planes.enqueue(plane);
    }

    public Plane peekRunway()
    {
    
    	return planes.peek();
    
    }


    public Plane dequeueFromRunway()
    {
	return planes.dequeue();
    }

}