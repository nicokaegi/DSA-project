package dependencies;
/*
 * Purpose: Data Structure and Algorithms Lab 2 Problem 2
 * Status: Complete and thoroughly tested
 * Last update: 09/14/19
 * Submitted:  09/17/19
 * Comment: test suite and sample run attached
 * @author: Theresa Morris - Section 2
 * @version: 2019.09.14
 */
import java.util.ArrayList;


public class ListArrayListBased<T> implements ListInterface<T>
{
    private static final int MAX_LIST=3;
    protected ArrayList<T> items;


    public ListArrayListBased()
    {
        items = new ArrayList<T>(MAX_LIST);
    }

    public boolean isEmpty()
    {
        return items.isEmpty();
    }

    public int size()
    {
        return items.size();
    }

    public void removeAll()
    {
        items.clear();
    }

    public void add (int index, T item)
    {
        items.add(index, item);
    }

    public Object get(int index)
    {
        return items.get(index);
    }

    public void remove(int index)
    {
        items.remove(index);
    }

}
