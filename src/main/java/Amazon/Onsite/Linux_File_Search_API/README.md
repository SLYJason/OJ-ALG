# Design Unix File Search API
Design Unix File Search API to search file with different arguments as "extension", "name", "size" ...
The design should be maintainable to add new constraints.

Example Rules:
Find all files over XX size under a directory.
Find all files with XX type under a directory.

```
% find / -name "*.xml" -size +1k
% find / -name "*.png" -size -1m
% find / -size +100m
% find / -name "temp-*"
```

Follow up: How would you handle if some constraints should support AND, OR conditionals.