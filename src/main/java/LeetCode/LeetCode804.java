package LeetCode;
import java.util.Set;
import java.util.HashSet;

public class LeetCode804 {
    public int uniqueMorseRepresentations(String[] words) {
        Set set = new HashSet<String>();
        String[] code = new String[] {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        for(String word:words) {
            String morse = "";
            for(char ch:word.toCharArray()){
                morse += code[ch - 'a'];
            }
            set.add(morse);
        }
        return set.size();
    }
}
