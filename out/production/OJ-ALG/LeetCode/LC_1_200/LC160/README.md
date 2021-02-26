# 160: Intersection of Two Linked Lists

### Solution 2 Logic
Assuming shared parts of List A and B is `c`, A has different part `a` and B has different part `b`. So both `A` and `B` can be denoted as:
```
A = a + c.
B = b + c.
``` 
Initialize `p1` starts from A and `p2` starts from B. If there has an intersection, `p1` will walk through `a + c + b` and `p2` will walk through `b + c + a` which means they walk same length! We can find an intersection here. If they do not have an intersection, they still walk the same length, but `p1` and `p2` will get `null` eventually. 