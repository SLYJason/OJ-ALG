package Amazon.Onsite.InfiniteNode;

interface InfiniteNode<T> {
    T value();
    Iterable<InfiniteNode<T>> children();
}

