# 3: Longest Substring Without Repeating Characters

### Solution 1: Sliding Window HashMap
Using `window`(Map) to maintain all unique characters. 

Map: `K` -> `character`, `V` -> `count of character`.

**Time Complexity:** `O(N)`.

**Space Complexity:** `O(N)`.

### Solution 2: Sliding Window HashSet
Using `window`(Set) to maintain all unique characters.

**Time Complexity:** `O(N)`.

**Space Complexity:** `O(N)`.

### Solution 3: Sliding Window HashMap Optimized
Using `window`(Map) to maintain all unique characters. 

Map: `K` -> `character`, `V` -> `index of character`.

**Time Complexity:** `O(N)`.

**Space Complexity:** `O(N)`.

### Related
3: Longest Substring Without Repeating Characters.

159: Longest Substring with At Most Two Distinct Characters.

340: Longest Substring with At Most K Distinct Characters.