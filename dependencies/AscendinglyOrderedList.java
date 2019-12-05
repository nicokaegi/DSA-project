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

import dependencies.AscendinglyOrderedListInterface;
import dependencies.KeyedItem;
import dependencies.ListIndexOutOfBoundsException;

public class AscendinglyOrderedList<T extends KeyedItem<KT>, KT extends Comparable
    <? super KT>> implements AscendinglyOrderedListInterface<T, KT> {
	/**Initial size of the Ascendingly Ordered List **/
    private static final int MAX_LIST = 3;
    /** array of generic items **/
    protected T[] items;  
    /** how many items are stored (as opposed to repeatedly counting) **/
    protected int numItems; 
    /** Whether we succussfully added something**/
    boolean success = false;

    public AscendinglyOrderedList()
    {
        items = (T[]) new KeyedItem[MAX_LIST];
        numItems = 0;
    }
    /**
     * returns whether the array is empty
     * @return whether the array is empty
     */
    public boolean isEmpty() {
        return (numItems == 0);
    }

/**
 * returns number of items in the array
 * @return number of items in the array
 */
    public int size() {
        return numItems;
    }

/**
 * takes a generic item, searches for where it should be located (in this case lexicographically), and inserts it in place.
 * @param item the item we are looking to add
 */
    public void add(T item) throws ListIndexOutOfBoundsException {
        if (numItems >= items.length)
        {
            resize();
        }
        int index = search(item);

        if(!success)
        {
	    if(index < 0)
		{
		    //convert negative index back to a positive.
		    index = index -(index*2);
		}
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
                items[index] = (T) item;
                numItems++;
            }
            else
            {
                // index out of range
                throw new ListIndexOutOfBoundsException(
                    "ListIndexOutOfBoundsException on add");
            }  // end if
        }
        else
        {
            System.out.println("Item already exists in list!");
        }
    }
    //end add



/**
 * takes in the index of an item we are looking for, and returns that item.
 * @param index the index of the item we want
 * @return the item we are retrieving
 */
    public T get(int index) throws ListIndexOutOfBoundsException {
        {
            if (index >= 0 && index < numItems)
            {
                return (T) items[index];
            }
            else
            {
                // index out of range
                throw new ListIndexOutOfBoundsException(
                    "ListIndexOutOfBoundsException on get");
            }  // end if
        } // end get
    }

/**
 * Takes in an index and deletes the relevant item, shifting everything to accomidate.
 * @param index the index we are removing
 */
    public void remove(int index) throws ListIndexOutOfBoundsException {
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
    }

/**
 * Searches for an item in teh array.  If it finds it, it just tells us where it was and does not allow us to insert a duplcate.
 * If the item isn't found at all, it returns a negative version of the high index (the negative indicates the item was not succssfully located)
 * @param item a generic item we are searching for
 * @return The index where we found the item, or the index where we need to insert it.
 */
    public int search(T item) {

        int low = 0;
        int high = numItems - 1;
        int mid = 0;
        //Special case one, we have nothing in the list...
        if (numItems == 0)
        {
            return 0;
        }
        //handling this as a special case because no matter which way I would check, I would get a
        //0,0 check, which messes EVERYTHING up.
        if (numItems == 1)
        {
            if(item.getKey().compareTo((items[mid]).getKey()) > 0)
            {
                return 1;
            }
            else
            {
                return 0;
            }
        }

        while (low < high)
        {
            mid = (low + high)/2;
            if(item.getKey().compareTo((items[mid]).getKey()) > 0)
            {
                low = mid + 1;
            }
            else
            {
                high = mid;
            }
        }

        if(item.equals(items[low]))
        {
            success = true;
            return low;
        }
        else
        {
            success = false;
            if(item.getKey().compareTo((items[low]).getKey()) > 0)
            {
                return -(high + 1);
            }
            else
            {
                return - high;
            }
        }
    }
/**
 * Empties the array by deleting it
 */
    public void clear() {
        items = (T[]) new KeyedItem[MAX_LIST];
        numItems = 0;
    }
/**
 * When the array is full, resizes it as needed.
 */
    private void resize()
    {
        T []temp = (T[]) new KeyedItem[items.length + (items.length/2)];

        for (int i = 0; i < items.length; i++)
        {
            temp[i] = items[i];
        }
        items = temp;

    }
/**
 * parses through all of the array and concatinates it into one string.
 * @return a string representation of the array
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
