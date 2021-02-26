# 1177: Can Make Palindrome from Substring

### Solution: Prefix Sum
`count[i]` means substring with length `i` each character's count. Similarly, `count[i][j]` means character `'a' + j`'s count in the substring with length `i`.

For substring `[left, right]` each characters' count, it equals `count[right+1] - count[left]`. So to find substring can be rearranged and replaced become a palindrome, we need to count each character's **odds** count.

For the odds, we only need to replace half of the odds, that is `odds / 2`.

**Time Complexity:** `O(n + N)`, `n` is the length of `s`, `N` is the length of `queries`.

**Space Complexity:** `O(n + N)`.