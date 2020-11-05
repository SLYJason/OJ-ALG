# 1D Candy Crush
Write a function to crush candy in a one dimensional board.

In candy crushing games, groups of like items are removed from the board. In this problem, any sequence of **3 or more** like items should be removed and any items adjacent to that sequence should now be considered adjacent to each other. This process should be repeated as many times as possible.

Sample inputs - Expected outputs:

```
"aaabbbc" -> "c"
"aabbbacd" -> "cd"
"aabbccddeeedcba" -> ""
"aaabbbacd" -> "acd"
"ABBBCC" -> "ACC"
"ABCCCBB" -> "A"
"ABBBBBBBBCC" -> "ACC"
"ABCCCCCCCCCBDDDBAA" -> ""
```