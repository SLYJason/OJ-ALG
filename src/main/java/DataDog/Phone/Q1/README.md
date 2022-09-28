# Bucket
Put a list of integers into a list of buckets, with a specific bucket width, return counter per bucket.
For example, a list of integers `[1,2,11,20, 100]`, number of bucket is `3`, bucket width `10`, the results are:
```markdown
0-9: 2(1, 2).
10-19: 1(11).
20+ 2(20, 100).
```
The last bucket contains the rest of the numbers.