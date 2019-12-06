/*
 * Purpose: Data Structure and Algorithms Lab 8 Problem 3
 * Status: Complete and thoroughly tested
 * Last update: 11/04/19
 * Submitted:  11/05/19
 * Comment: test suite and sample run attached
 * @author: Theresa Morris - Section 2
 * @version: 2019.11.04
 */

public interface AscendinglyOrderedListInterface<T,KT>
{
    /**
     * @return whether the list is empty
     */
    boolean isEmpty();
    /**
     * @return the size of the array
     */
    int size();
    /**
     * Takes an item, searches through the list, and adds it where it needs to go.
     * @param item the item we are looking to add
     * @throws ListIndexOutOfBoundsException
     */
    void add(T item) throws ListIndexOutOfBoundsException;
    /**
     * Takes in an index, and returns the item found AT that index.
     * @param index the index we are looking for
     * @return the item we are retrieving
     * @throws ListIndexOutOfBoundsException
     */
    T get(int index) throws ListIndexOutOfBoundsException;
    /**
     * takes in an index, removes relevant item.
     * @param index the index we want to remove
     * @throws ListIndexOutOfBoundsException
     */
    void remove(int index) throws ListIndexOutOfBoundsException;
    /**
     * Takes in an item, and locates the index where it is found
     * @param item the item we are looking for
     * @return the index the item is found... or not found
     */
    int search(T item);
    /**
     * Clears the array
     */
    void clear();
}