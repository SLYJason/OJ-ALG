# API Rate Limiter
Design a low level API rate limiter.

Need to consider:
1. Caller may call the API multiple time same time, e.g. caller A call API 5 times at single timestamp X.
2. Maintain a window only last X seconds allowed to call Y times.
3. Similar to [Design Hit Counter](https://leetcode.com/problems/design-hit-counter/).
4. 