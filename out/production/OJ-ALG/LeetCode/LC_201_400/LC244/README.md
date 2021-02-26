# 244: Shortest Word Distance II

### Solution: HashMap
`Map` data structure: `K` -> `words[i]`, `V` -> list of indices of `i`.

**Time Complexity:** `construction` takes `O(N)`. `shortest` takes `O(m + n)`, where `m` and `n` are the number of indices of `word1` and `word2` respectively.

**Space Complexity:** `construction` takes `O(N)`. `shortest` takes `O(1)`.

### Related
243: Shortest Word Distance.

244: Shortest Word Distance II.

245: Shortest Word Distance III.