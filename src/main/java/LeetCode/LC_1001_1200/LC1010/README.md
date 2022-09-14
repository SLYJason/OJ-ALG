# 1010: Pairs of Songs With Total Durations Divisible by 60

### Solution: Two Sum
The idea is need to get the each `time[i] % 60` first, and the another matching will be `60 - time[i] % 60`. Build a map to record already processed songs and keeping add the result.

**Time Complexity:** `O(N)`.

**Space Complexity:** `O(1)`. Constant space since the size of the map will never above 60.
