# Closed Location and Discount Price

### Question 1
When customers order from Amazon.com, to fulfill quick delivery Amazon must locate the closest distribution centers.
Amazon is looking for an efficient program to find k the closest distribution centers locations to a given customer location.
Locations have two dimensions (x,y) and the distance between locations is calculated by a provided function.

The distance between two locations (x0, y0) and (x1, y1) is the formula `math.sqrt((x0 - x1) ^ 2 + (y0 - y1) ^ 2)`.

For Example , If you have the distribution center locations `[[1,0], [2,0], [3,0], [4,0], [5,0]]` with a customer location of `[4,0]` and
`k = 3` you would return `[[3,0], [4,0], [5,0]]`.

**Order of the output does not matter.**

### Question 2
Amazon is having a site-wide sale; everything is 20% off.
Can you write me a function that takes a sentence found on the Amazon retail website,
discounts the price if there is a price present, and finally returns the modified sentence.
Example
```markdown
"Amazon Echos are $50 today." > "Amazon Echos are $40 today."
Buy the Ke$ha alb$1um for $13.00  >  Buy the Ke$ha alb$1um for $10.40
Buy the Ke$ha album for Rs.13.00  >   Buy the Ke$ha album for Rs.10.40
```

