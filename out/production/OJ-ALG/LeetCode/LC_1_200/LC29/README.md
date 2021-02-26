# 29: Divide Two Integers

### Solution 1: Brute Force
In Java, `int` range is `[-2^31, 2^31-1]` which is `[-2147483648, 2147483647]`, so we need to handle the overflow here. Since the negative range can represent more integers, so we will convert the input to the negative integer.

A corner case need to handle here is `dividend=-2147483648`, `divisor=-1`, since we can not represent `2147483648` in Java, so will return `MAX_VALUE=2147483647` here directly.

**Time Complexity:** `O(N)`, `N` is the absolute value of the `dividend`.

**Space Complexity:** `O(1)`.

### Solution 2: Bit Manipulation
Similar to Solution 1, we will convert `dividend` and `divisor` both to negative since negative has larger range. Keep in mind `Math.abs(MIN_VALUE) = MIN_VALUE = -2147483648`.

For example, calculate `divide(29, 3)`:

Step 1:
```
29 - 3 > 0;
29 - 3*2 = 29 - 6 > 0;
29 - 3*2*2 = 29 - 12 > 0;
29 - 3*2*2*2 = 29 - 24 > 0; -> we have multiply 2*2*2=8 here so 8 is part of the answer.
29 - 3*2*2*2*2 = 29 - 48 < 0; stop here!

we now know the answer is between 2*2*2=8 and 2*2*2*2=16.
```

Step 2:
```
new dividend = 29 - 24 = 5;
5 - 3 > 0; -> we have multiply 2*0 here so we only need to add 1 to the answer.
5 - 3*2 < 0; stop here!

So final quotient = 8 + 1 = 9.
```

**Time Complexity:** `O(logN)`.

**Space Complexity:** `O(1)`.

