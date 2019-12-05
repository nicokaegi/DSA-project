/**
 * Purpose: Data Structure and Algorithms Project
 * Status: Complete and Thoroughly Tested
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
import dependencies.QueueSLS;

public class Runway
{
    /**A string holding the runway name **/
    String name;
    /**A queue holding all of the planes waiting for takeoff from this runway **/
    QueueSLS<Plane> planes;

    public Runway(String name) {

        this.name = name;
        planes = new QueueSLS<Plane>();
    }
    /**
    * A method to return the runway's name
    * @return the name
    */
    public String getName()
    {
        return name;
    }
    /**
     * A method to return the runway's queue of planes
     * @return the planes
     */
    public QueueSLS<Plane> getPlanes()
    {
        return planes;
    }
    /**
     * A method to set the runway's name
     * @param name the name to set
     */
    public void setName(String name)
    {
        this.name = name;
    }
    /**
     * A method to set the runway's queue of planes
     * @param planes the planes to set
     */
    public void setPlanes(QueueSLS<Plane> planes)
    {
        this.planes = planes;
    }
    @Override
    /**
     *  if we have planes at all, calls the toString method on the queue, which calls the toString method on each plane
     */
    public String toString()
    {
        if(!planes.isEmpty())
        {
            return (planes.toString());
        }
        else
        {
            return null;
        }
    }

    /**
     * A method to enqueue a plane to the planelist in the runway
     * @param plane the plane to enqueue
     */
    public void enqueueToRunway(Plane plane)
    {
        planes.enqueue(plane);
    }
    /**
     * A method to peek at the plane at the end of the queue
     * @return the plane at the end of the queue
     */
    public Plane peekRunway()
    {

        return planes.peek();

    }
    /**
     * A method to dequeue a plane from the runway
     * @return the plane at the end of the queue
     */
    public Plane dequeueFromRunway()
    {
        return planes.dequeue();
    }

    /**
     * A method to tell us if the runway is empty
     * @return true if the runway is empty, false otherwise.
     */
    public boolean isEmpty()
    {
        return planes.isEmpty();
    }

}
