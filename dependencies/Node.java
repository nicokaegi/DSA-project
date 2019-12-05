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
//please note that this code is different from the textbook code, because the data is encapsulated!

public class Node<T>
{
    /** The generic item the node holds **/
    private T item;
    /** the next node in the list from the current one **/
    private Node<T> next;

    public Node(T newItem)
    {
        item = newItem;
        next = null;
    } // end constructor

    public Node(T newItem, Node<T> nextNode)
    {
        item = newItem;
        next = nextNode;
    } // end constructor

    /**
     * Sets the item in the node
     * @param newItem the item to be set
     */
    public void setItem(T newItem)
    {
        item = newItem;
    } // end setItem

    /**
     * @return the item in the node
     */
    public T getItem()
    {
        return item;
    } // end getItem

    /**
     * sets the next node in the list
     * @param nextNode the next node in the list
     */
    public void setNext(Node<T> nextNode)
    {
        next = nextNode;
    } // end setNext
/*
 * @return the next node in the list
 */
    public Node<T> getNext()
    {
        return next;
    } // end getNext
} // end class Node
