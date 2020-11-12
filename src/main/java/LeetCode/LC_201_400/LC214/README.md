# 214: Shortest Palindrome

### Solution
The idea is to find the longest palindrome of `s` substring from index 0. If found, just need to append reverse substring `[0, i]` to `s`.
```
Example: "abacd"

s.substring(0, len-i)   reverse.substring(i)
abacd                   dcaba
abac                    caba
aba                     aba
```
**Time complexity:** `O(N ^ 2)`, N is the length of the `s`.

**Space complexity:** `O(N ^ 2)`, N is the length of the `s`.