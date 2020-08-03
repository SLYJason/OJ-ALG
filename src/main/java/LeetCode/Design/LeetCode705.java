package LeetCode.Design;

import java.util.List;
import java.util.LinkedList;

public class LeetCode705 {
    class MyHashSet {
        int capacity = 128;
        Bucket[] bucketArray;
        /** Initialize your data structure here. */
        public MyHashSet() {
            bucketArray = new Bucket[capacity];
            for(int i=0; i<capacity; i++) {
                bucketArray[i] = new Bucket();
            }
        }

        // hash function
        private int hash(int key) {
            return key % capacity;
        }

        public void add(int key) {
            int pos = hash(key);
            bucketArray[pos].add(key);
        }

        public void remove(int key) {
            int pos = hash(key);
            bucketArray[pos].remove(key);
        }

        /** Returns true if this set contains the specified element */
        public boolean contains(int key) {
            int pos = hash(key);
            return bucketArray[pos].contains(key);
        }
    }

    class Bucket {
        public List<Integer> list;
        public Bucket() {
            list = new LinkedList();
        }

        public void add(int key) {
            if(list.contains(key)) return;
            list.add(key);
        }

        public void remove(int key) {
            if(!list.contains(key)) return;
            int index = list.indexOf(key);
            list.remove(index);
        }

        public boolean contains(int key) {
            return list.contains(key);
        }
    }
}
