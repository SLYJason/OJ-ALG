# 1657: Determine if Two Strings Are Close

### Solution: HashMap
Two strings are close need to meet:
1. Have the same length: `cabbba` => 6, `abbccc` => 6.
2. Have the same char set: `cabbba` => `(a, b, c)`, `abbccc` => `(a, b, c)`.
3. Have the same sorted char frequencies: `cabbba` => `(c:1, a:2, b:3)`, `abbccc` => `(a:1, b:2, c:3)`.

**Time Complexity:** `O(N)`.

**Space Complexity:** `O(1)`.