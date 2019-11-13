/*
 * Purpose: Data Structure and Algorithms Lab 5 Problem 3
 * Status: Complete and Thoroughly Tested
 * Last update: 10/07/19
 * Submitted:  10/08/19
 * Comment: test suite and sample run attached
 * @author: Theresa Morris - Section 2
 * @version: 2019.10.08
 */

public class ListCDLSBased<T> implements ListInterface<T>
{
    private DNode<T> tail;
    private int numItems;

    public ListCDLSBased()
    {
        tail = null;
        numItems = 0;
    }

    public boolean isEmpty()
    {
        return numItems == 0;
    }

    public int size()
    {
        return numItems;
    }

    private DNode<T> find(int index)
    {
        DNode<T> current = null;

        if(index <= (numItems/2))
        {
            current = tail.getNext();
            for (int i = 0; (i < index); i++)
            {
                current = current.getNext();
            }
        }
        else if (index > (numItems/2))
        {
            current = tail;
            for (int i = (numItems-1); (i > index); i--)
            {
                current = current.getBack();
            }

        }

        /*current = tail.getNext();
        for (int i = 0; (i < index); i++)
        {
            current = current.getNext();
        }
        */

        return current;
    }

    public T get(int index) throws ListIndexOutOfBoundsException
    {
        if (index >= 0 && index < numItems)
        {
            return find(index).getItem();
        }
        else
        {
            throw new ListIndexOutOfBoundsException("List index out of bounds exception on get");
        }

    }

    public void add(int index, T item) throws ListIndexOutOfBoundsException
    {
        if(index >= 0 && (index <= numItems || numItems == 0))
        {
            if(index <= numItems && index != 0)
            {

                DNode<T> prev = find(index - 1);
                prev.getNext().setBack(new DNode(item, prev.getNext(), prev));
                //Get prev's current next node's back link, which now leads to our new node
                //set prev's next to that backlink.
                prev.setNext(prev.getNext().getBack());
                if (index == (numItems))
                {
                    tail = prev.getNext();
                }
            }
            else if (numItems == 0)
            {
                tail = new DNode<T>(item);
            }
            else if (index == 0)
            {
                DNode<T> prev = tail;
                prev.getNext().setBack(new DNode<>(item, prev.getNext(), prev));
                prev.setNext(prev.getNext().getBack());
            }

            numItems++;
        }


        else
        {
            throw new ListIndexOutOfBoundsException("List index out of bounds exception on add");
        }
    }//end add

    public void remove(int index) throws ListIndexOutOfBoundsException
    {
        if(index >=0 && (index <= numItems-1 || numItems == 1))
        {
            if (numItems == 1)
            {
                tail = null;
            }
            else if (index == 0)
            {
                //index 0 = tail.getNext()
                tail.setNext(tail.getNext().getNext());
                tail.getNext().setBack(tail);
            }
            else
            {
                DNode<T> prev = find(index - 1);
                prev.setNext(prev.getNext().getNext());
                prev.getNext().setBack(prev);
                if (index == (numItems - 1))
                {
                    tail = tail.getBack();
                }
            }
            numItems--;
        }
        else
        {
            throw new ListIndexOutOfBoundsException("List index out of bounds exception on remove");
        }

    }//end remove

    public void removeAll()
    {
        tail = null;
        numItems = 0;
    }//end removeAll

    public String toString()
    {
        StringBuilder buildList = new StringBuilder();

        DNode<T> curr = tail.getNext();

        do
        {
            buildList.append(curr.getItem().toString() + " ");
            curr = curr.getNext();
        }
        while (curr != tail.getNext());

        return buildList.toString();
    }
}
