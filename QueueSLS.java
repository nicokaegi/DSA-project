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


public class QueueSLS<T> implements QueueInterface<T>
{
    /** the front of the queue */
    protected Node<T> front;
    /** the back of the queue */
    protected Node<T> back;

    public QueueSLS()
    {
        front = null;
        back = null;
    }

    /**
     * @return whether the queue is empty.
     */
    public boolean isEmpty()
    {
        return front == null;
    }

    /**
     * adds an item at the back of the queue.
     * @param newItem the item we are adding
     */
    public void enqueue(T newItem) throws QueueException
    {
        if (front == null)
        {
            front = new Node<>(newItem, back);
            back = front;
        }
        else
        {
            Node<T> temp = new Node<T>(newItem);
            back.setNext(temp);
            back = temp;
        }
    }
    /**
     * Returns to us the item at the front of the queue.
     * @return the item we are dequeueing
     * @throws QueueException
     */
    public T dequeue() throws QueueException
    {
        if(front != null)
        {
            T temp = front.getItem();
            if (front == back)
            {
                front = null;
                back = null;
            }
            else
            {
                front = front.getNext();
            }
            return temp;
        }
        else
        {
            throw new QueueException("Queue Exception on dequeue!");
        }
    }
    /**
     * empties the queue by creating a new one.
     */
    public void dequeueAll()
    {
        front = null;
        back = null;
    }
    /**
     * @return the item at the front of the queue
     */
    public T peek() throws QueueException
    {
        if (front != null)
        {
            return front.getItem();
        }
        else
        {
            throw new QueueException("Queue Exception on peek!");
        }
    }
    @Override
    /**
     * parses through the queue and returns a string representation of it.
     * @return a string representation of the queue
     */
    public String toString()
    {
        StringBuilder buildList = new StringBuilder();
        Node<T> curr = front;

        while (curr != null)
        {
            buildList.append(curr.getItem().toString() + "\n ");
            curr = curr.getNext();
        }

        return buildList.toString();
    }
}
