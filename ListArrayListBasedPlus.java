/*
 * Purpose: Data Structure and Algorithms Lab 5 Problem 3
 * Status: Complete and thoroughly tested
 * Last update: 10/05/19
 * Submitted:  10/08/19
 * Comment: test suite and sample run attached
 * @author: Theresa Morris - Section 2
 * @version: 2019.10.05
 */
import java.util.ArrayList;

public class ListArrayListBasedPlus<T> extends ListArrayListBased<T>
{

    public void reverse()
    {
        ArrayList<T> reverse = new ArrayList<>();

        for(int i = (items.size()-1); i >=0; i--)
        {
            reverse.add(items.get(i));
        }

        items = reverse;
    }

    public String toString()
    {
        StringBuilder temp = new StringBuilder();

        for (int i = 0; i < size(); i++)
        {
            temp.append(items.get(i) + " ");
        }

        return new String(temp);
    }

}
