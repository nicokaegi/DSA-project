/*
 * Purpose: Data Structure and Algorithms Lab 6 Problem 1
 * Status: Incomplete
 * Last update: 10/11/19
 * Submitted:  10/14/19
 * Comment: test suite and sample run attached
 * @author: Theresa Morris - Section 2
 * @version: 2019.10.11
 */

public class QueueSLS<T> implements QueueInterface<T>
{
    protected Node<T> front;
    protected Node<T> back;

    public QueueSLS()
    {
        front = null;
        back = null;
    }

    public boolean isEmpty()
    {
        return front == null;
    }

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

    public void dequeueAll()
    {
        front = null;
        back = null;
    }

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

    public String toString()
    {
        StringBuilder buildList = new StringBuilder();
        Node<T> curr = front;

        while (curr != null)
        {
            buildList.append(curr.getItem().toString() + " ");
            curr = curr.getNext();
        }

        return buildList.toString();
    }
}
