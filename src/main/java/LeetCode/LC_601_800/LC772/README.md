# 772: Basic Calculator III

### Solution
Using same logic as LC227, the only exception is when meet open `(`, we need to find its matched `)`. Then we recursively call `calculate(substring between open and closing parentheses)` to get the inner parentheses sum. 

**Time Complexity:** `O(N)`.

**Space Complexity:** `O(N)`.

### Related: 
224: Basic Calculator.

227: Basic Calculator II.

772: Basic Calculator III.