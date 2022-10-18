# Function FindMatches
Suppose you are building a library and have the following definition of a function and two methods `register` and `findMatches`.
`register` method registers a function and its argumentTypes in the library and `findMatches` accepts an input argument list and tries to find all the functions that match this input argument list.

Note: If a function is marked as `isVariadic=true`, then the last argument can occur zero or number of times.

```markdown
Example A:
FuncA: [String, Integer, Integer]; isVariadic = false
FuncB: [String, Integer]; isVariadic = true
FuncC: [Integer]; isVariadic = true
FuncD: [Integer, Integer]; isVariadic = true
FuncE: [Integer, Integer, Integer]; isVariadic = false
FuncF: [String]; isVariadic = false
FuncG: [Integer]; isVariadic = false

findMatches({String}) -> [FuncB, FuncF]
findMatches({Integer}) -> [FuncC, FuncD, FuncG]
findMatches({Integer, Integer, Integer, Integer}) -> [FuncC, FuncD]
findMatches({Integer, Integer, Integer}) -> [FuncC, FuncD, FuncE]
findMatches({String, Integer, Integer, Integer}) -> [FuncB]
findMatches({String, Integer, Integer}) -> [FuncA, FuncB]
```

```markdown
Example B:
register({
    funA:{["Boolean", "Integer"], isVariadic:false},
    funB:{["Integer"], isVariadic:false},
    funC:{["Integer"], isVariadic:true},
    funD:{["String", "Integer", "Integer", "Integer"], isVariadic:true},
    funE:{["String", "Integer", "Integer"], isVariadic:false},
})

findMatches(["Boolean", "Integer"])            -> [funA]
findMatches(["Integer"])                       -> [funB, funC]
findMatches(["Integer", "Integer", "Integer"]) -> [funC]
findMatches(["String", "Integer"])             -> []
findMatches(["String", "Integer", "Integer"])  -> [funE, funD] # funD due to the supporting 0 variadic
findMatches(["String", "Integer", "Integer", "Integer", "Integer"])  -> [funD]
```