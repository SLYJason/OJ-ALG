package Amazon.OA2;

/**
 * Solution: Two pointer.
 * i -> codeList, j -> shoppingCart.
 * Same as LC392.
 */
public class Solution {
    public int isWinner(String[][] codeList, String[] shoppingCart) {
        if(codeList.length == 0) return 1;
        if(shoppingCart.length == 0) return 0;
        int i = 0, j = 0;
        while(i < codeList.length && j+codeList[i].length <= shoppingCart.length) {
            boolean match = true;
            for(int k = 0; k < codeList[i].length; k++) {
                if(!codeList[i][k].equals(shoppingCart[j+k]) && !codeList[i][k].equals("anything")) {
                    match = false;
                    break;
                }
            }
            if(match) {
                j += codeList[i].length;
                i++;
            } else {
                j++;
            }
        }
        return (i == codeList.length) ? 1 : 0;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        String[][] codeList1 = { { "apple", "apple" }, { "banana", "anything", "banana" } };
        String[] shoppingCart1 = {"orange", "apple", "apple", "banana", "orange", "banana"};
        String[][] codeList2 = { { "apple", "apple" }, { "banana", "anything", "banana" } };
        String[] shoppingCart2 = {"banana", "orange", "banana", "apple", "apple"};
        String[][] codeList3 = { { "apple", "apple" }, { "banana", "anything", "banana" } };
        String[] shoppingCart3 = {"apple", "banana", "apple", "banana", "orange", "banana"};
        String[][] codeList4 = { { "apple", "apple" }, { "apple", "apple", "banana" } };
        String[] shoppingCart4 = {"apple", "apple", "apple", "banana"};
        String[][] codeList5 = { { "apple", "apple" }, { "banana", "anything", "banana" } };
        String[] shoppingCart5 = {"orange", "apple", "apple", "banana", "orange", "banana"};
        String[][] codeList6 = { { "apple", "apple" }, { "banana", "anything", "banana" }  };
        String[] shoppingCart6 = {"apple", "apple", "orange", "orange", "banana", "apple", "banana", "banana"};
        String[][] codeList7= { { "anything", "apple" }, { "banana", "anything", "banana" }  };
        String[] shoppingCart7 = {"orange", "grapes", "apple", "orange", "orange", "banana", "apple", "banana", "banana"};
        String[][] codeList8 = {{"apple", "orange"}, {"orange", "banana", "orange"}};
        String[] shoppingCart8 = {"apple", "orange", "banana", "orange", "orange", "banana", "orange", "grape"};
        String[][] codeList9= { { "anything", "anything", "anything", "apple" }, { "banana", "anything", "banana" }  };
        String[] shoppingCart9 = {"orange", "apple", "banana", "orange", "apple", "orange", "orange", "banana", "apple", "banana"};

        System.out.println("Expected: 1. Results: " + sol.isWinner(codeList1, shoppingCart1));
        System.out.println("Expected: 0. Results: " + sol.isWinner(codeList2, shoppingCart2));
        System.out.println("Expected: 0. Results: " + sol.isWinner(codeList3, shoppingCart3));
        System.out.println("Expected: 0. Results: " + sol.isWinner(codeList4, shoppingCart4));
        System.out.println("Expected: 1. Results: " + sol.isWinner(codeList5, shoppingCart5));
        System.out.println("Expected: 1. Results: " + sol.isWinner(codeList6, shoppingCart6));
        System.out.println("Expected: 1. Results: " + sol.isWinner(codeList7, shoppingCart7));
        System.out.println("Expected: 1. Results: " + sol.isWinner(codeList8, shoppingCart8));
        System.out.println("Expected: 1. Results: " + sol.isWinner(codeList9, shoppingCart9));
    }
}
