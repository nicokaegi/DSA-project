package dependencies;

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
public interface AscendinglyOrderedListInterface<T,KT>
{
    boolean isEmpty();
    int size();
    void add(T item) throws ListIndexOutOfBoundsException;
    T get(int index) throws ListIndexOutOfBoundsException;
    void remove(int index) throws ListIndexOutOfBoundsException;
    int search(T item);
    void clear();
}