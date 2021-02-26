# 451: Sort Characters By Frequency

### Solution 1
String is **immutable!** For example, in solution 1 if we want to build the final result we can write this: 
```
String res = "";
while(!maxHeap.isEmpty()) {
    Map.Entry<Character, Integer> pair = maxHeap.poll();
    char ch = pair.getKey();
    int count = pair.getValue();
    while(count-- > 0) res += ch;
}
```
This is bad because in the line `res += ch;`, each time a character is added to `res`, a new String is created. 
Creating a new String has a time cost of `n`. So overall time complexity is `O(n^2)`. Thus, we need to use `StringBuilder` here.
