/*
 * Purpose: Data Structure and Algorithms Lab 5 Problem 3
 * Status: Complete and Thoroughly Tested
 * Last update: 09/20/19 - Redo: 10/2/19
 * Submitted:  09/24/19 - Redo: 10/3/19
 * Comment: Test suite with differences attached
 * @author: Theresa Morris - Section 2
 * @version: 2019.10.08
 */

public class ListReferenceBased<T> implements ListInterface<T>
{
    private Node<T> head;

    public ListReferenceBased()
    {
        head = null;
    }

    public boolean isEmpty()
    {
        return head == null;
    }

    public int size()
    {
        int size = 0;
        Node<T> curr = head;

        while (curr!=null)
        {
            size++;
            curr = curr.getNext();
        }

        return size;
    }

    private Node<T> find(int index)
    {
        Node current = head;
        for (int i = 0; i < index; i++)
        {
            current = current.getNext();
        }
        return current;
    }

    public T get(int index) throws ListIndexOutOfBoundsException
    {
        if (index >= 0 && index < size())
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
        if(index >= 0 && index <= size())
        {
            if(index == 0)
            {
                head = new Node<>(item, head);
            }
            else
            {
                Node<T> prev = find(index-1);
                prev.setNext(new Node<>(item,prev.getNext()));
            }
        }
        else
        {
            throw new ListIndexOutOfBoundsException("List index out of bounds exception on add");
        }
    }

    public void remove(int index) throws ListIndexOutOfBoundsException
    {
        if(index >=0 && index < size())
        {
            if(index == 0)
            {
                head = head.getNext();
            }
            else
            {
                Node<T> prev = find(index - 1);
                prev.setNext(prev.getNext().getNext());
            }
        }
        else
        {
            throw new ListIndexOutOfBoundsException("List index out of bounds exception on remove");
        }
    }

    public void removeAll()
    {
        head = null;
    }

    public String toString()
    {
        StringBuilder buildList = new StringBuilder();
        Node curr = head;

        while(curr != null)
        {
            buildList.append(curr.getItem().toString() + " ");
            curr = curr.getNext();
        }

        return buildList.toString();
    }
}
