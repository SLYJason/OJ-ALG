package LeetCode.LC_201_400.LC284;

import java.util.Iterator;

/**
 * Solution 2: using Iterator properties.
 */
public class Solution_2 {
    class PeekingIterator implements Iterator<Integer> {
        Iterator<Integer> ite;
        Integer peek;
        public PeekingIterator(Iterator<Integer> iterator) {
            // initialize any member here.
            ite = iterator;
            if(iterator.hasNext()) {
                peek = iterator.next();
            }
        }

        // Returns the next element in the iteration without advancing the iterator.
        public Integer peek() {
            return peek;
        }

        // hasNext() and next() should behave the same as in the Iterator interface.
        // Override them if needed.
        @Override
        public Integer next() {
            if(!hasNext()) return null;
            int next = peek;
            peek = ite.hasNext() ? ite.next() : null;
            return next;
        }

        @Override
        public boolean hasNext() {
            return peek != null;
        }
    }
}
