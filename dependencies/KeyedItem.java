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

public abstract class KeyedItem<KT extends
    Comparable<? super KT>> {
    private KT searchKey;

    public KeyedItem(KT key) {
        searchKey = key;
    }  // end constructor
/**
 * @return our comparable key
 */
    public KT getKey() {
        return searchKey;
    } // end getKey
} // end KeyedItem
