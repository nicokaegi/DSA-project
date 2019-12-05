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
// ********************************************************
// Array-based implementation of the ADT list.
// *********************************************************
public class ListArrayBased<T> implements ListInterface<T>
{
/** the initial size of the array **/
    private static final int MAX_LIST = 3;
    /** our list of items **/
    protected T []items;  
    /** how many items we are holding **/
    protected int numItems;  

    public ListArrayBased()
    {
        items = (T[]) new Object[MAX_LIST];
        numItems = 0;
    }  // end default constructor
/**
 * @return true if the array is empty
 */
    public boolean isEmpty()
    {
        return (numItems == 0);
    } // end isEmpty
    /**
     * @return how many items are in the array
     */
    public int size()
    {
        return numItems;
    }  // end size
/**
 * Creates a new array, deleting the old one.
 */
    public void removeAll()
    {
        // Creates a new array; marks old array for
        // garbage collection.
        items = (T[])new Object[MAX_LIST];
        numItems = 0;
    } // end removeAll
/**
 * takes in an index and an item, and adds them to the array.
 * @param index the index we are adding at
 * @param item the item we are adding
 */
    public void add(int index, T item)
    throws  ListIndexOutOfBoundsException
    {
        if (numItems == items.length) //Fixes Implementation Error and programming style
        {
            throw new ListException("ListException on add");
        }  // end if
        if (index >= 0 && index <= numItems)
        {
            // make room for new element by shifting all items at
            // positions >= index toward the end of the
            // list (no shift if index == numItems+1)
            for (int pos = numItems-1; pos >= index; pos--)  //textbook code modified to eliminate logic error causing ArrayIndexOutOfBoundsException
            {
                items[pos+1] = items[pos];
            } // end for
            // insert new item
            items[index] = item;
            numItems++;
        }
        else
        {
            // index out of range
            throw new ListIndexOutOfBoundsException(
                "ListIndexOutOfBoundsException on add");
        }  // end if
    } //end add
/**
 * takes in an index and returns the item stored there.
 * @param index the index of the item we are looking for
 * @return the item we are searching for
 */
    public T get(int index)
    throws ListIndexOutOfBoundsException
    {
        if (index >= 0 && index < numItems)
        {
            return items[index];
        }
        else
        {
            // index out of range
            throw new ListIndexOutOfBoundsException(
                "ListIndexOutOfBoundsException on get");
        }  // end if
    } // end get
/**
 * takes in an index and removes the item at that index
 * @param index the index to be removed
 */
    public void remove(int index)
    throws ListIndexOutOfBoundsException
    {
        if (index >= 0 && index < numItems)
        {
            // delete item by shifting all items at
            // positions > index toward the beginning of the list
            // (no shift if index == size)
            for (int pos = index+1; pos < numItems; pos++) //textbook code modified to eliminate logic error causing ArrayIndexOutOfBoundsException

            {
                items[pos-1] = items[pos];
            }  // end for

            items[--numItems] = null; //Fixes memory leak (Hopefully)

        }
        else
        {
            // index out of range
            throw new ListIndexOutOfBoundsException(
                "ListIndexOutOfBoundsException on remove");
        }  // end if
    } //end remove
@Override
/**
 * Parses through the array and returns a string representation of all of the items in it.
 */
    public String toString()
    {
        StringBuilder buildItems = new StringBuilder();

        for(int i = 0; i<numItems; i++)
        {
            buildItems.append(items[i] + "\n");
        }

        return buildItems.toString();
    }
}
