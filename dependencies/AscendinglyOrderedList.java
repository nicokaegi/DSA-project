package dependencies;

import dependencies.AscendinglyOrderedListInterface;
import dependencies.KeyedItem;
import dependencies.ListIndexOutOfBoundsException;

/*
 * Purpose: Data Structure and Algorithms Lab 8 Problem 3
 * Status: Complete and thoroughly tested
 * Last update: 11/04/19
 * Submitted:  11/05/19
 * Comment: test suite and sample run attached
 * @author: Theresa Morris - Section 2
 * @version: 2019.11.04
 */
public class AscendinglyOrderedList<T extends KeyedItem<KT>, KT extends Comparable
    <? super KT>> implements AscendinglyOrderedListInterface<T, KT> {
    private static final int MAX_LIST = 3;
    protected T[] items;  // an array of list items
    protected int numItems;  // number of items in list
    boolean success = false;

    public AscendinglyOrderedList()
    {
        items = (T[]) new KeyedItem[MAX_LIST];
        numItems = 0;
    }
    public boolean isEmpty() {
        return (numItems == 0);
    }


    public int size() {
        return numItems;
    }


    public void add(T item) throws ListIndexOutOfBoundsException {
        if (numItems >= items.length)
        {
            resize();
        }
        int index = search(item);

        if(!success)
        {
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
                return high + 1;
            }
            else
            {
                return high;
            }
        }
    }

    public void clear() {
        items = (T[]) new KeyedItem[MAX_LIST];
        numItems = 0;
    }

    private void resize()
    {
        T []temp = (T[]) new KeyedItem[items.length + (items.length/2)];

        for (int i = 0; i < items.length; i++)
        {
            temp[i] = items[i];
        }
        items = temp;

    }

    public String toString()
    {
        StringBuilder buildList = new StringBuilder();

        for (int i = 0; i < numItems; i++)
        {
            buildList.append(items[i] + " ");
        }

        return buildList.toString();
    }

}
