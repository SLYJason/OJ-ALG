# 355: Design Twitter

### Solution
`userFollowers`: `userId` -> `a list of users that userId followed`.

`userTweets`: `userId` -> `a list of tweets that userId tweeted`.

**postTweet**: **Time Complexity** -> `O(1)`.

**mergeTweets**: Keep in mind we only need to extract each user's **top 10** tweets and push each into the min-heap. And the heap size is always 10 here, so insertion into the heap takes constant time, so overall **Time Complexity** -> `O(N)`, `N` here means the total number of users and tweets.

**follow**: **Time Complexity** -> `O(1)`.

**unfollow**: **Time Complexity** -> `O(1)`.

**Space Complexity**: `O(N)`, `N` here means the total number of users and tweets.

### Related
23: Merge k Sorted Lists.

355: Design Twitter.