package dependencies;
/*
 * Purpose: Data Structure and Algorithms Lab 5 Problem 1
 * Status: Complete and thoroughly tested
 * Last update: 10/05/19
 * Submitted:  10/08/19
 * Comment: test suite and sample run attached
 * @author: Theresa Morris - Section 2
 * @version: 2019.10.05
 */

public class StackRAB<T> implements StackInterface<T>
{
    private static final int MAX_LIST = 3;
    private T []items;
    private int top;

    public StackRAB()
    {
        items = (T[]) new Object[MAX_LIST];
        top = -1;
    }

    public boolean isEmpty()
    {
        return top == -1;
    }

    public T peek() throws StackException
    {
        if (top != -1)
        {
            T result = items[top];
            return result;
        }
        else
        {
            throw new StackException("Stack Exception on peek");
        }
    }

    public void push(T newItem) throws StackException
    {
        if (top >= (items.length-1))
        {
            resize();
            items[++top] = newItem;
        }
        else
        {
            items[++top] = newItem;
        }
    }

    public T pop() throws StackException
    {
        if (top != -1)
        {
            T result = items[top];
            items[top--] = null;
            return result;
        }
        else
        {
            throw new StackException("Stack Exception on pop");
        }
    }

    public void popAll()
    {
        items = (T[]) new Object[MAX_LIST];
        top = -1;
    }

    public String toString()
    {
        StringBuilder buildList = new StringBuilder();

        for (int i = items.length-1; i >=0 ; i--)
        {
            if(items[i]!=null)
            {
                buildList.append(items[i] + " ");
            }
        }
        return buildList.toString();
    }

    private void resize()
    {
        T []temp = (T[]) new Object[(items.length + (items.length/2))];

        for (int i = 0; i < items.length; i++)
        {
            temp[i] = items[i];
        }

        items = temp;

    }

}
