### 68: Text Justification

### Solution
First we need to calculate how many words can be filled in a line. Using two pointers `i` and `j` to specify `words[i, j]` can be filled in a line. Then there has 3 cases need to consider:

1. Last line: it should be left justified and no extra space is inserted between words.
2. Only one word in a line: just left justified, append space in the rest.
3. Regular justify: we need to calculate how many `spaces` in the line and how many `extra` spaces we need to assign from left to right.

**Time Complexity:** `O(N)`.

**Space Complexity:** `O(1)`.

### Related
68: Text Justification.

1592: Rearrange Spaces Between Words.