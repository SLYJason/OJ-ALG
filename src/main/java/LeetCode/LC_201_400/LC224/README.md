# 224: Basic Calculator

### Warm Up
Implement a basic calculator that only contains numbers, plus `+` and `-` sign and empty spaces.

Example 1:
```
Input: "1 + 1"
Output: 2
```
Example 2:
```
Input: " 2-1 + 2 "
Output: 3
```
**Time Complexity:** `O(N)`.

**Space Complexity:** `O(1)`.

### Solution
The idea is using a stack. We iterate the whole string and there has **5** possible characters we may meed:
* `digit`: it is a number, we have to get the whole number using a loop.
* `+`: we need to add the number. Keep in mind the number should be added or subtracted is depends on one the previous sign, i.e. `3 + 5`, `5` is depends on `+`.
* `-`: we need to subtract the number. Subtract logic same as `+`.
* `(`: we need to push the previous sum to a stack, then set the `res` to `0` to calculate the inner parenthesis `res`.
* `)`: we need to pop the outside sum from the stack and then calculate the sum of inner sum with it.

**Time Complexity:** `O(N)`.

**Space Complexity:** `O(N)`.

### Related: 
224: Basic Calculator.

227: Basic Calculator II.

772: Basic Calculator III.
