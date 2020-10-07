# 1143: Longest Common Subsequence

Solution 1:
Compare the last character of the `text1` and `text2`, there has 2 scenarios:
1. If they are same: `lcs(text1, text2) = 1 + max(lcs(text1 substring without last char), lcs(text2 substring without last char))`.
2. If they are not same, `lcs(text1, text2)` can be either `lcs(text1 substring without last char, text2)` or `lcs(text1, text2 substring without last char)`.