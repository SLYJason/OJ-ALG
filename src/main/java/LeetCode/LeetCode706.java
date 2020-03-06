package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode706 {
    class MyHashMap {
        private int key_space;
        private List<Bucket> hash_table;
        /** Initialize your data structure here. */
        public MyHashMap() {
            this.key_space = 2069;
            this.hash_table = new ArrayList<Bucket>();
            for (int i = 0; i < this.key_space; ++i) {
                this.hash_table.add(new Bucket());
            }
        }

        /** value will always be non-negative. */
        public void put(int key, int value) {
            int hash_key = key % key_space;
            hash_table.get(hash_key).put(key, value);
        }

        /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
        public int get(int key) {
            int hash_key = key % key_space;
            return hash_table.get(hash_key).get(key);
        }

        /** Removes the mapping of the specified value key if this map contains a mapping for the key */
        public void remove(int key) {
            int hash_key = key % key_space;
            hash_table.get(hash_key).remove(key);
        }
    }

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
}
class Bucket {
    List<Node> bucket;
    Bucket() {
        this.bucket = new ArrayList();
    }

    public void put(int key, int value) {
        boolean existed = false;
        for(Node node : bucket) {
            if(node.key == key) {
                node.value = value;
                existed = true;
                break;
            }
        }
        if(!existed) bucket.add(new Node(key, value));
    }

    public int get(int key) {
        for(Node node : bucket) {
            if(node.key == key) {
                return node.value;
            }
        }
        return -1;
    }

    public void remove(int key) {
        for(Node node : bucket) {
            if(node.key == key) {
                bucket.remove(node);
                break;
            }
        }
    }

}
class Node {
    int key;
    int value;
    Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}
