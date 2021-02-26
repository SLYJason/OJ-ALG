# Top N Competitors
Given a list of `reviews`, list of `competitors`, `topNCompetitors`, return the list of `topNCompetitors` whose name appears most in the reviews (count competitor only once if it appears multiple times in a review).

Example:
```
reviews: ['I love Google', 'I love Apple', 'I love Google more than Apple but Apple products are nice as well', 'Apple products are great', 'I love Microsoft'].
competitors: ['Google', 'Apple', 'Netflix', 'Microsoft'].
topNCompetitors: 2.

Answer: ['Apple', 'Google'].
```

**Note**: Also, assuming in a set of reviews `[Apple, Netflix, Facebook, Google]` is appearing same number of times, but we need to return only top 2 competitors, then return the top 2 competitors in alphabetical order. 
So the answer will be `[Apple, Facebook]`.