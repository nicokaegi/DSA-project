package dependencies;
/*
 * Purpose: Data Structure and Algorithms Lab 5 Problem 1
 * Status: Complete and thoroughly tested
 * Last update: 10/07/19
 * Submitted:  10/08/19
 * Comment: test suite and sample run attached
 * @author: Theresa Morris - Section 2
 * @version: 2019.10.07
 */

public class StackSLS<T> implements StackInterface<T>
{
    private Node<T> top;

    public StackSLS()
    {
        top = null;
    }

    public boolean isEmpty()
    {
        return top == null;
    }

    public void popAll()
    {
        top = null;
    }

    public void push(T newItem) throws StackException
    {
        top = new Node<>(newItem, top);
    }

    public T pop() throws StackException
    {
        if (top != null)
        {
            T result = top.getItem();
            top = top.getNext();
            return result;
        }
        else
        {
            throw new StackException("Stack Exception on pop");
        }
    }
    public T peek() throws StackException
    {
        if (top!=null)
        {
            return top.getItem();
        }
        else
        {
            throw new StackException("Stack Exception on peek");
        }
    }

    public String toString()
    {
        StringBuilder buildList = new StringBuilder();
        Node<T> curr = top;

        while (curr != null)
        {
            buildList.append(curr.getItem().toString() + "\n");
            curr = curr.getNext();
        }

        return buildList.toString();
    }
}
