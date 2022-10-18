package Confluent.Phone.Function_Find_Matches;

import java.util.*;

public class Solution_1 {
    public static void main(String[] args) {
        // Example A:
        FunctionLibrary f1 = new FunctionLibrary();
        Set<Function> set1 = new HashSet<>();
        System.out.println("Example A: ");
        Function funcA = new Function("FuncA", new ArrayList<>(){{
            add("String"); add("Integer"); add("Integer");
        }}, false);
        Function funcB = new Function("FuncB", new ArrayList<>(){{
            add("String"); add("Integer");
        }}, true);
        Function funcC = new Function("FuncC", new ArrayList<>(){{
            add("Integer");
        }}, true);
        Function funcD = new Function("FuncD", new ArrayList<>(){{
            add("Integer"); add("Integer");
        }}, true);
        Function funcE = new Function("FuncE", new ArrayList<>(){{
            add("Integer"); add("Integer"); add("Integer");
        }}, false);
        Function funcF = new Function("FuncF", new ArrayList<>(){{
            add("String");
        }}, false);
        Function funcG = new Function("FuncG", new ArrayList<>(){{
            add("Integer");
        }}, false);
        set1.add(funcA); set1.add(funcB); set1.add(funcC); set1.add(funcD); set1.add(funcE); set1.add(funcF); set1.add(funcG);
        f1.register(set1);

        System.out.println(f1.findMatches(new ArrayList<>(){{ add("String"); }}));
        System.out.println(f1.findMatches(new ArrayList<>(){{ add("Integer"); }}));
        System.out.println(f1.findMatches(new ArrayList<>(){{ add("Integer"); add("Integer"); add("Integer"); add("Integer"); }}));
        System.out.println(f1.findMatches(new ArrayList<>(){{ add("Integer"); add("Integer"); add("Integer"); }}));
        System.out.println(f1.findMatches(new ArrayList<>(){{ add("String"); add("Integer"); add("Integer"); add("Integer"); }}));
        System.out.println(f1.findMatches(new ArrayList<>(){{ add("String"); add("Integer"); add("Integer"); }}));

        // Example B:
        FunctionLibrary f2 = new FunctionLibrary();
        Set<Function> set2 = new HashSet<>();
        System.out.println("\nExample B: ");
        Function funcAA = new Function("funA", new ArrayList<>(){{
            add("Boolean"); add("Integer");
        }}, false);
        Function funcBB = new Function("funB", new ArrayList<>(){{
            add("Integer");
        }}, false);
        Function funcCC = new Function("funC", new ArrayList<>(){{
            add("Integer");
        }}, true);
        Function funcDD = new Function("funD", new ArrayList<>(){{
            add("String"); add("Integer"); add("Integer"); add("Integer");
        }}, true);
        Function funcEE = new Function("funE", new ArrayList<>(){{
            add("String"); add("Integer"); add("Integer");
        }}, false);
        set2.add(funcAA); set2.add(funcBB); set2.add(funcCC); set2.add(funcDD); set2.add(funcEE);
        f2.register(set2);

        System.out.println(f2.findMatches(new ArrayList<>(){{ add("Boolean"); add("Integer"); }}));
        System.out.println(f2.findMatches(new ArrayList<>(){{ add("Integer"); }}));
        System.out.println(f2.findMatches(new ArrayList<>(){{ add("Integer"); add("Integer"); add("Integer"); }}));
        System.out.println(f2.findMatches(new ArrayList<>(){{ add("String"); add("Integer"); }}));
        System.out.println(f2.findMatches(new ArrayList<>(){{ add("String"); add("Integer"); add("Integer"); }}));
        System.out.println(f2.findMatches(new ArrayList<>(){{ add("String"); add("Integer"); add("Integer"); add("Integer"); add("Integer");}}));
    }
}