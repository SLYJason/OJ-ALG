# All Possible Routes
Implement a class called AirMap that has two methods:
```
add_route(start, destination);
    - adda a ONE WAY connecting flight from start to destination.

print_all_routes(start, destination);
    - prints all possible routes from start to destination irrespective of hops
```
Given the following flight routes, print all possible routes between the airport `C` and `D`.

Example:
```
Input: 
A ----> B
B ----> A
A ----> C
C ----> A
A ----> D
D ----> A
B ----> C
C ----> B
B ----> D
D ----> B

Output:
C,A,B,D,
C,A,D
C,B,A,D
C,B,D
```