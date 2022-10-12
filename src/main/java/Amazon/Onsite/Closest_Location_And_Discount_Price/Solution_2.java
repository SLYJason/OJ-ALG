package Amazon.Onsite.Closest_Location_And_Discount_Price;

import java.text.DecimalFormat;

public class Solution_2 {
    private static final DecimalFormat df = new DecimalFormat("0.00");
    public static String discountSentence(String s) {
        StringBuilder sb = new StringBuilder();
        String[] splits = s.split(" ");
        for (String word : splits) {
            if (word.startsWith("$")) {
                String num = parseAndDiscount(word.substring(1));
                sb.append("$").append(num);
            } else if (word.startsWith("Rs.")) {
                String num = parseAndDiscount(word.substring(3));
                sb.append("Rs.").append(num);
            } else {
                sb.append(word);
            }
            sb.append(" ");
        }
        return sb.toString();
    }

    private static String parseAndDiscount(String num) {
        try {
            double d = Double.parseDouble(num);
            return df.format(d * 0.8);
        } catch (NumberFormatException e) {
            return "";
        }
    }

    public static void main(String[] args) {
        String s1 = "Amazon Echos are $50 today";
        String s2 = "Buy the Ke$ha alb$1um for $13.00";
        String s3 = "Buy the Ke$ha album for Rs.13.00";
        System.out.println(discountSentence(s1));
        System.out.println(discountSentence(s2));
        System.out.println(discountSentence(s3));
    }
}
