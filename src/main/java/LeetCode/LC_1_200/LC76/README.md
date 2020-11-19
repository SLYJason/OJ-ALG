# 76: Minimum Window Substring

### Solution: Sliding Window
The idea is maintain a window, expand the right pointer `j` as much as possible to include all `t` characters. Here we use `distance` to denote how many characters of `t` we have included. If `distance == t.length()`, we are sure the window included all `t` characters, so we need to contract the window, i.e. move left pointer `i`. Whenever the `distance != t.length()`, we then need to expand the window again. Repeat the process once we find the minimum window substring.

`distance` here looks like: [Hamming Distance](https://en.wikipedia.org/wiki/Hamming_distance).

**Time Complexity:** `O(∣S∣+∣T∣)`, `|S|` is the length of `s`, `|T|` is the length of `t`.

**Space Complexity:** `O(1)`.

### Related
76: Minimum Window Substring.

438: Find All Anagrams in a String.

567: Permutation in String.