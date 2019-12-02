package dependencies;
/*
 * Purpose: Data Structure and Algorithms Lab 6 Problem 0
 * Status: Complete and thoroughly tested
 * Last update: 10/10/19
 * Submitted:  10/11/19
 * Comment: test suite and sample run attached
 * @author: Theresa Morris - Section 2
 * @version: 2019.10.10
 */
public class QueueCRAB<T> implements QueueInterface<T>
{
    private static final int MAX_LIST = 3;
    protected T[]items;
    protected int front;
    protected int back;
    protected int numItems;

    public QueueCRAB()
    {
        items = (T[]) new Object[MAX_LIST];
        front = 0;
        back = 0;
        numItems = 0;
    }

    public boolean isEmpty()
    {
        return numItems == 0;
    }

    public T peek() throws QueueException
    {
        if(numItems!=0)
        {
            return items[front];
        }
        else
        {
            throw new QueueException("Queue Exception on peek!");
        }
    }

    public void enqueue(T newItem) throws QueueException
    {
        if (numItems == items.length)
        {
            resize();
        }
        items[back] = newItem;
        back = (back +1) % items.length;
        numItems++;
    }

    public T dequeue() throws QueueException
    {
        if(numItems != 0)
        {
            T result = items[front];
            items[front] = null;
            front = (front +1) % items.length;
            numItems--;
            return result;
        }
        else
        {
            throw new QueueException("Queue Exception on dequeue!");
        }
    }

    public void dequeueAll()
    {
        items = (T[]) new Object[MAX_LIST];
        front = 0;
        back = 0;
        numItems = 0;
    }

    public String toString()
    {
        StringBuilder buildList = new StringBuilder();

        for (int i = 0; i < numItems; i++)
        {
            buildList.append(items[(front + i) % items.length].toString() + "\n");
        }
        return buildList.toString();
    }

    protected void resize()
    {
        T []tempList = (T[]) new Object[((numItems + (numItems/2)))];

        for (int i = 0; i < numItems; i++)
        {
            tempList[i] = items[(front + i) % items.length];
        }
        items = tempList;
        front = 0;
        back = numItems;
    }
}
