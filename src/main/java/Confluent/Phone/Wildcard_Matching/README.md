# Wildcard Matching
Given an input string and a pattern, implement a wildcard matching function with support for literal characters a through z and the wildcard character * (which matches zero or more of any character).
```markdown
cat c*t ---> true
cat *t ---> true
dog ct ---> false
cat tac* --->false
```

1. Consider there only has at most 1 `*` character.
2. Consider there has multiple `*` characters.
