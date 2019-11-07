/*
 * Purpose: Data Structure and Algorithms Lab 6 Problem 2
 * Status: Complete and Thoroughly Tested
 * Last update: 10/11/19
 * Submitted:  10/14/19
 * Comment: test suite and sample run attached
 * @author: Theresa Morris - Section 2
 * @version: 2019.10.11
 */

public class DEQ<T> extends QueueCRAB<T> implements ExtendedQueueInterface<T>
{

    public void enqueueFirst(T newItem) throws ExtendedQueueException
    {
        if (numItems == items.length)
        {
            resize();
        }
        front = ((front + items.length -1) % items.length);
        items[front] = newItem;
        numItems++;
    }

    public T dequeueLast() throws ExtendedQueueException
    {
        if(numItems != 0)
        {
            back = ((back + items.length - 1) % items.length);
            T result = items[back];
            items[back] = null;
            numItems--;
            return result;
        }
        else
        {
            throw new ExtendedQueueException("ExtendedQueueException on dequeueLast!");
        }
    }

    public T peekLast() throws ExtendedQueueException
    {
        if(numItems !=0)
        {
            return items[((back + items.length - 1) % items.length)];
        }
        else
        {
            throw new ExtendedQueueException("ExtendedQueueException on peeklast!");
        }
    }
}
