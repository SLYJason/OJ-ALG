# Minimum Steps to Generate Number
Given an integer `n`. You can use only 2 operations:

 - multiply by 2.
 - integer division by 3 (e.g. 10 / 3 = 3).
 
Find the minimum number of steps required to generate `n` from `1`.

Example 1:
```
Input: 10.
Output: 6.

Explanation: 1 * 2 * 2 * 2 * 2 / 3 * 2
6 steps required, as we have used 5 multiplications by 2, and one division by 3.
```

Example 2:
```
Input: 3.
Output: 7.

Explanation: 1 * 2 * 2 * 2 * 2 * 2 / 3 / 3
7 steps required, as we have used 5 multiplications by 2 and 2 divisions by 3.
```