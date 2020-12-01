# 567: Permutation in String

### Solution 1: Sliding Window - Fixed Window Size
We are using `Arrays.equals` every time to compare the window with the target string.

**Time Complexity**: `O(L1 + L2 * 26)`, `L1` is the length of `s1`, `L2` is the length of `s2`.

**Space Complexity**: `O(1)`.

### Solution 2: Sliding Window - Changed Window Size
Using LC76 logic here, window size is keeping changing.

**Time Complexity**: `O(|L1| + |L2|)`, `L1` is the length of `s1`, `L2` is the length of `s2`.

**Space Complexity**: `O(1)`.

### Related
76: Minimum Window Substring.

438: Find All Anagrams in a String.

567: Permutation in String.

727: Minimum Window Subsequence.