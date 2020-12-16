package LeetCode.LC_201_400.LC385;

import java.util.ArrayList;
import java.util.List;

// This is the interface that allows for creating nested lists.
// You should not implement it, or speculate about its implementation
public class NestedInteger {
    // Constructor initializes an empty nested list.
    public NestedInteger() {};

    // Constructor initializes a single integer.
    public NestedInteger(int value) {};

    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    boolean isInteger() {
        return true;
    };

    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    Integer getInteger() {
        return 1;
    };

    // Set this NestedInteger to hold a single integer.
    void setInteger(int value) {};

    // Set this NestedInteger to hold a nested list and adds a nested integer to it.
    void add(NestedInteger ni) {};

    // @return the nested list that this NestedInteger holds, if it holds a nested list
    // Return null if this NestedInteger holds a single integer
    List<NestedInteger> getList() {
        return new ArrayList<>();
    }
}
