# 93: Restore IP Addresses

### Solution: Backtrack
Couple of things need to note:
* The input string length should meet: `4 <= legnth <= 12`.
* We can only place 3 dots in the IP address.
* Each IP segment value should meet: `0 <= value <= 12`.

**Time Complexity:** `O(1)`. Because we only need to place 3 dots, and the input string length is constant value in the range `[4, 12]`, so for the first dot it has `(n-1)` choices, second is `(n-2)`, third is `(n-3)`. So total is `n^3`. Since `n` is the length of string and it's a constant value, so the time complexity is `O(1)`. 

**Space Complexity:** `O(1)`.

### Related
93: Restore IP Addresses.

468: Validate IP Address.

751: IP to CIDR.