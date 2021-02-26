# 974: Subarray Sums Divisible by K

### Modulo Operation in Java
A negative number modulo operation always has a negative number in Java, for example:
```
-1 % 4 = -1
-3 % 5 = -3
-8 % 3 = -2
```
This because `%` is treated as reminder in Java, so we need to transform the reminder to mod.

### Solution: Prefix Sum
To use the prefixSum to solve this problem, we have to find an important feature. If there exists `i < j` that meets following requirement:
```
(prefixSum[j] - prefixSum[i]) % K == 0 ===> prefixSum[i] % K == prefixSum[j] % K.
```
Then we know subarray `[i+1, j]` is divisible by `K`. So we have to store the `mod`, i.e. `prefixSum % K` and occurrence of `mod` in the Map.

**Time Complexity:** `O(N)`.

**Space Complexity:** `O(N)`.

### Related:
560: Subarray Sum Equals K.

974: Subarray Sums Divisible by K.