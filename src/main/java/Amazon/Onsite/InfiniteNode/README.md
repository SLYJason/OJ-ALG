# InfiniteNode
We are given this interface for a tree:
```java
interface InfiniteNode<T>{
    T value();
    Iterable<InfiniteNode<T>> children();
}
```
Every node in the tree has infinite children.

- Let's write a function that returns an `InfiniteNode<String>` instance
- The root node has a value of "0"
- Each child node has value "<parent-value>:<i>" where "i" is the offset of the child among its siblings.
  
Example: printing root and its first 10 children of the root should produce:
```markdown
0
0:0
0:1
0:2
0:3
0:4
0:5
0:6
0:7
0:8
0:9
```
