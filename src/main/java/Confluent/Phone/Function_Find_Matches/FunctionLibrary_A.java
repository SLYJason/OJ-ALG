package Confluent.Phone.Function_Find_Matches;

import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.List;
import java.util.ArrayList;

/**
 * Solution 1: brute force.
 */
public class FunctionLibrary_A {
    public final Map<String, Function> map;

    public FunctionLibrary_A() {
        this.map = new HashMap<>();
    }

    // implement this method.
    public void register(Set<Function> functionSet)  {
        for (Function function : functionSet) {
            map.put(function.name, function);
        }
    }

    // implement this method.
    public List<Function> findMatches(List<String> argumentTypes) {
        List<Function> res = new ArrayList<>();
        for (Function function : map.values()) {
            List<String> functionArgs = function.argumentTypes;
            boolean isVariadic = function.isVariadic;
            if (!isVariadic) {
                if (functionArgs.toString().equals(argumentTypes.toString())) res.add(function);
            } else {
                int i = 0, j = 0;
                String lastArg = functionArgs.get(functionArgs.size() - 1);
                while (i < functionArgs.size() - 1 && j < argumentTypes.size() && functionArgs.get(i).equals(argumentTypes.get(j))) {
                    i++;
                    j++;
                }
                while (j < argumentTypes.size() && argumentTypes.get(j).equals(lastArg)) j++;
                if (i == functionArgs.size() - 1 && j == argumentTypes.size()) res.add(function);
            }
        }
        return res;
    }
}
