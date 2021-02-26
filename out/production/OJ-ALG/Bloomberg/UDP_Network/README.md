# UDP Network

An application is receiving UDP network data. Given the nature of UDP protocol, data can be received out of order or can get lost over the network. With each piece of data, however we also receive an incremental sequence number indicating the order of the data as it was sent out by the source.

Write a class called `Sequencer` which prints all received data to standard output in order, according to the data's sequence number. You can assume a method `handle` gets called providing the data `(std::string)` and its sequence number `(int)`.

Example 1:
```
Input Stream: [{1, "aaa"}, {2, "bbb"}, {4, "ddd"}, {5, "eee"}, {3, "ccc"}, {6, "fff"}].
Output: "aaa bbb ccc ddd eee fff".
```

Example 2:
```
Input Stream: [{1, "aaa"}, {3, "ccc"}, {4, "ddd"}].
Output: "aaa".

Explanation: In this case, sequence number 2 was not received yet, so the rest hasn't be printed.
```