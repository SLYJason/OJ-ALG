# 267: Palindrome Permutation II

### Solution: Backtrack
Given string `s`, we count each character appearances and find it can be formed a palindrome. We use LC266 logic here. 

Then, if the string has an **odd** character count, we can fill the palindrome center. For example, string `abacc` has odd count `b`, so the palindrome must be `xxbxx`. Then we can calculate permutations on the half of the string.

**Time Complexity:** `O((N/2)!)`.

**Space Complexity:** `O(N)`.

### Related
266: Palindrome Permutation.

267: Palindrome Permutation II.

409: Longest Palindrome.