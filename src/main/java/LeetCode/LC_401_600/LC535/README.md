# 535: Encode and Decode TinyURL

### Solution: Random Fixed Length Encoding
`Map`: `K` -> `encoded key` like `4e9iAk`, `V` -> `longUrl`.

The algorithm randomly pick character from `alphabet` until reach the fixed length `6`. Then put this `encoded key` and `longUrl` into map. When need to encode a new `longUrl`, checking continuously in the map until to generate a new key.   