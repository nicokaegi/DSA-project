/*
 * Purpose: Data Structure and Algorithms Lab 8 Problem 3
 * Status: Complete and thoroughly tested
 * Last update: 11/04/19
 * Submitted:  11/05/19
 * Comment: test suite and sample run attached
 * @author: Theresa Morris - Section 2
 * @version: 2019.11.04
 */
public interface AscendinglyOrderedStringListInterface
{
    boolean isEmpty();
    int size();
    void add(String item) throws ListIndexOutOfBoundsException;
    String get(int index) throws ListIndexOutOfBoundsException;
    void remove(int index) throws ListIndexOutOfBoundsException;
    int search(String item);
    void clear();
}