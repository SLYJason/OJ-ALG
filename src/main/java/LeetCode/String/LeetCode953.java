package LeetCode.String;

public class LeetCode953 {
    public boolean isAlienSorted(String[] words, String order) {
        int[] dict = new int[26];
        // building a dictionary based on order.
        for(int i=0; i<order.length(); i++) {
            dict[order.charAt(i) - 'a'] = i;
        }
        for(int i=0; i<words.length-1; i++) {
            if(!isSmaller(words[i], words[i+1], dict)) return false;
        }
        return true;
    }

    private boolean isSmaller(String str1, String str2, int[] dict) {
        int n = str1.length(), m = str2.length();
        for(int i=0; i<n && i<m; i++) {
            if(str1.charAt(i) != str2.charAt(i)) {
                return dict[str1.charAt(i)-'a'] < dict[str2.charAt(i)-'a'];
            }
        }
        return n < m;
    }
}
