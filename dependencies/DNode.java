package dependencies;
/*
 * Purpose: Data Structure and Algorithms Lab 4 Problem 1
 * Status: Complete and Thoroughly Tested
 * Last update: 09/26/19
 * Submitted:  10/01/19
 * Comment: test suite and sample run attached
 * @author: Theresa Morris - Section 2
 * @version: 2019.09.26
 */

public class DNode<T> extends Node<T>
{
    private DNode<T> back;

    public DNode(T newItem)
    {
        super(newItem);
        super.setNext(this);
        back = this;

    }

    public DNode(T newItem, DNode<T> nextNode, DNode<T> backNode)
    {
        super(newItem,nextNode);
        back = backNode;
    }

    public void setBack(DNode<T> backNode)
    {
        back = backNode;
    }

    public DNode<T> getBack()
    {
        return back;
    }

    public DNode<T> getNext()
    {
        return (DNode<T>)super.getNext();
    }
}
