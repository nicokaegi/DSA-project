package dependencies;
/*
 * Purpose: Data Structure and Algorithms Lab 2 Problem 1
 * Status: Complete and thoroughly tested
 * Last update: 09/23/19
 * Submitted:  09/17/19 - Redo 9/24/19
 * Comment: test suite and sample run attached
 * @author: Theresa Morris
 * @version: 2019.09.23
 */

public class ListArrayBasedPlus<T> extends ListArrayBased<T>
{

    public void add(int index, T item) throws ListIndexOutOfBoundsException
    {
        if (numItems >= items.length)
        {
            resize();
        }
        super.add(index, item);

    }

    private void resize()
    {
        T []temp = (T[]) new Object[items.length + (items.length/2)];

        for (int i = 0; i < items.length; i++)
        {
            temp[i] = items[i];
        }
        items = temp;

    }

    public void reverse()
    {
        T []temp = (T[]) new Object[items.length];

        for (int i = 0; i < numItems; i++)
        {
            temp[(numItems-i)-1] = items[i];
        }
        items = temp;
    }

    public String toString()
    {
        StringBuilder buildList = new StringBuilder();

        for (int i = 0; i < numItems; i++)
        {
            buildList.append(items[i] + "\n");
        }

        return buildList.toString();
    }
}
