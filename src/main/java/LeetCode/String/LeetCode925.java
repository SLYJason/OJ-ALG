package LeetCode.String;

public class LeetCode925 {
    public boolean isLongPressedName(String name, String typed) {
        if(name.equals(typed)) return true; // base case 1
        if(name.length() > typed.length()) return false; // base case 2
        int p1 = 0, p2 = 0;
        while(p1 < name.length() && p2 < typed.length()) {
            char a = name.charAt(p1);
            char b = typed.charAt(p2);
            if(a != b) return false;
            // move both p1 and p2 forward if they all match
            while(p1 < name.length() && p2 < typed.length() && name.charAt(p1) == a && typed.charAt(p2) == b) {
                p1++;
                p2++;
            }
            // move p2 only if p1 in name has enough match
            while(p2 < typed.length() && typed.charAt(p2) == b) p2++;
        }
        // process unmatched char in name and typed
        if(p1 == name.length() && p2 < typed.length() || p1 < name.length() && p2 == typed.length()) return false;
        return true;
    }
}
