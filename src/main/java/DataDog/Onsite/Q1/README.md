# Filter List
Given a list of strings arrays and filter list, output the remaining tags. Example: given `['apple, facebook, google', 'banana, facebook', 'facebook, google, tesla', 'intuit, google, facebook']`,
filter by `['apple']` should return `['facebook', 'google']`, filter by `['facebook', 'google']` should return `['apple', 'tesla', 'intuit']`.

### TagsFilter1 Implementation
Build a `map` based on the stream.
```
key -> tag.
value -> a stream that includes that tag
```
`filter()` functions needs to extract all streams that contain all keywords, then get the remaining tags, which takes `O(N * K)`. `N` is the stream size and `k` is the keywords size.

### TagsFilter1 Implementation
Build a `map` based on the stream.
```
key -> stream tag permutation. For example, given [a, b, c] it will have [a], [b], [c], [a, b], [b, c], [a, b, c].
value -> a list of tags that not includes that permutation.
```
`filter()` functions now gives `O(1)`.