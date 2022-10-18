package Confluent.Phone.Function_Find_Matches;

import java.util.List;

public class Function {
    public final String name;
    public final List<String> argumentTypes; // e.g. ["Integer", "String", "Boolean"]
    public final boolean isVariadic;

    Function(String name, List<String> argumentTypes, boolean isVariadic) {
        this.name = name;
        this.argumentTypes = argumentTypes;
        this.isVariadic = isVariadic;
    }

    public String toString() {
        return this.name;
    }
}
