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
package dependencies;

public class ListArrayBasedPlus<T> extends ListArrayBased<T>
{
    /**
     * Takes in an index and an item, and if our array is full, resizes before adding
     * @param index the index we are adding at
     * @param item the item we are adding
     */
    public void add(int index, T item) throws ListIndexOutOfBoundsException
    {
        if (numItems >= items.length)
        {
            resize();
        }
        super.add(index, item);

    }
/**
 * If our array is full, resizes the array to half again its size.
 */
    private void resize()
    {
        T []temp = (T[]) new Object[items.length + (items.length/2)];

        for (int i = 0; i < items.length; i++)
        {
            temp[i] = items[i];
        }
        items = temp;

    }
/**
 * Reverses the array.
 */
    public void reverse()
    {
        T []temp = (T[]) new Object[items.length];

        for (int i = 0; i < numItems; i++)
        {
            temp[(numItems-i)-1] = items[i];
        }
        items = temp;
    }
@Override
/**
 * Parses through the array and creates a sting representation of all of the items in it.
 * @return the string repersentation of the list.
 */
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
