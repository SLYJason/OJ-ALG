# 398: Random Pick Index

### Solution 1: Brute Force
**Time Complexity:** construction takes `O(N)`, `pick` takes `O(1)`.

**Space Complexity:** construction takes `O(N)`, `pick` takes `O(1)`.

### Solution 2: Reservoir Sampling 
**Time Complexity:** construction takes `O(N)`, `pick` takes `O(1)`.

**Space Complexity:** construction takes `O(1)`, `pick` takes `O(1)`.

### Reservoir Sampling
From [Wikipedia](https://en.wikipedia.org/wiki/Reservoir_sampling): Reservoir sampling is a family of randomized algorithms for choosing a simple random sample, without replacement, of k items from a population of unknown size n in a single pass over the items. The size of the population n is not known to the algorithm and is typically too large for all n items to fit into main memory.

Consider randomly select `k` out of `n` samples. `n` is usually very **large** and **unknown**. In other words, `n` can be treated as a **stream data**. See `ReservoirSampling` implementation, it only uses one-pass and takes `O(N)` time complexity.

Reference: [Educative](https://www.educative.io/edpresso/what-is-reservoir-sampling).

### Related
382: Linked List Random Node.

398: Random Pick Index.

528: Random Pick with Weight.