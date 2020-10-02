# 74: Search a 2D Matrix

**Solution 2**:
Treat 2D as 1D array and using binary search. 
For a 1D array element `a[i]`, if we want to convert to 2D `m*n` matrix coordinate `x` and `y` , we can use:  `x*n+y=i`.
So `x=i/n`, `y=i%n`.

Related: 

[74: Search a 2D Matrix](../LC74).

[240: Search a 2D Matrix II](../LC240).