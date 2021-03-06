# 227: Basic Calculator II

### Solution
For input `"3+2*3*4-4+5/2"`, we can think to convert it to `"(3)+(2*3*4)+(-4)+(5/2)"`. 
Each parenthesis can be an individual value in the stack. 
So the stack become `[3, 24, -4, 2]`. Finally, sum up the value in the stack.

**Time Complexity:** `O(N)`.

**Space Complexity:** `O(N)`.

### Related: 
224: Basic Calculator.

227: Basic Calculator II.

772: Basic Calculator III.