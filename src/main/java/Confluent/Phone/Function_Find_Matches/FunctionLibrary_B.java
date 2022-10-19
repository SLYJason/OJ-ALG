package Confluent.Phone.Function_Find_Matches;

import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;

/**
 * Solution 2: trie.
 */
public class FunctionLibrary_B {
    Trie trie;

    public FunctionLibrary_B() {
        this.trie = new Trie();
    }

    public void register(Set<Function> functionSet)  {
        // implement this method.
        for (Function function : functionSet) {
            trie.insert(function);
        }
    }

    public List<Function> findMatches(List<String> argumentTypes) {
        // implement this method.
        return trie.find(argumentTypes);
    }
}

class TrieNode {
    String argument;
    Map<String, TrieNode> children;
    List<Function> variadic;
    List<Function> nonVariadic;

    public TrieNode(String argument) {
        this.argument = argument;
        this.children = new HashMap<>();
        this.variadic = new ArrayList<>();
        this.nonVariadic = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "argument: " + argument + ", children: " + children + ", variadic: " + variadic + ", nonVariadic: " + nonVariadic;
    }
}

class Trie {
    TrieNode root;

    public Trie() {
        this.root = new TrieNode("Root");
    }

    public void insert(Function function) {
        TrieNode node = root;
        List<String> argumentTypes = function.argumentTypes;
        boolean isVariadic = function.isVariadic;

        for (String arg : argumentTypes) {
            node.children.putIfAbsent(arg, new TrieNode(arg));
            node = node.children.get(arg);
        }

        if (isVariadic) {
            node.variadic.add(function);
        } else {
            node.nonVariadic.add(function);
        }
    }

    public List<Function> find(List<String> argumentTypes) {
        Set<Function> res = new HashSet<>(); // we may add duplicates using set here.
        TrieNode node = root;

        int i = 0;
        while (i < argumentTypes.size()) {
            String arg = argumentTypes.get(i);
            if (!node.children.containsKey(arg)) {
                //if (!node.variadic.isEmpty()) res.addAll(node.variadic);
                break;
            } else {
                node = node.children.get(arg);
                if (i + 1 <= argumentTypes.size()) {
                    List<String> restArgs = argumentTypes.subList(i + 1, argumentTypes.size());
                    if (checkSame(arg, restArgs)) {
                        res.addAll(node.variadic);
                    }
                }
                if (i == argumentTypes.size() - 1) {
                    res.addAll(node.variadic);
                    res.addAll(node.nonVariadic);
                }
            }
            i++;
        }

        // corner case: Func: [String, Integer]; isVariadic = true, argumentTypes: [String]
        if (i == argumentTypes.size()) {
            for (TrieNode child : node.children.values()) {
                res.addAll(child.variadic);
            }
        }
        return new ArrayList<>(res);
    }

    private boolean checkSame(String arg, List<String> args) {
        for (String a : args) {
            if (!arg.equals(a)) return false;
        }
        return true;
    }
}
