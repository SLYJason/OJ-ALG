# 385: Mini Parser

### Solution: Stack
The rule to push char into Stack is:
* When meet `[`: push a new `NestedInteger` into stack.
* When meet `,` or `]`: it means we got a number end. Parse the number and add it to the top of the stack `NestedInteger`. If it is `]`, we need also pop the stack.

**Time Complexity:** `O(N)`.

**Space Complexity:** `O(N)`.