# 152: Maximum Product SubArray

Thinking Process:

1. If the array has positive numbers or negative numbers only, the solution is easy. 
Or it will be easy if the array has a mix of positive and negative numbers, because the sub array with the maximum product will be either start at the whole array or end at the whole array(see POC.java). 
But if the array has a mix of positive numbers, negative numbers and zero, this can be tough.
2. Say we already have a maximum sub array product, if encounter a negative number, it will flip the maximum product to minimum product. 
But there has a chance we can still get the maximum if we encounter another negative number.
3. But in situation 2, if we meet a zero, we will need to start again to get the maximum product.

Related: 

53: Maximum SubArray.

152: Maximum Product SubArray.