package LeetCode.Math;

public class LeetCode1344 {
    /**
     * Learning Reference: Type Promotion (https://www.cs.umd.edu/~clin/MoreJava/Intro/expr-mixed.html)
     * When one operand is an int and the other is a double, Java creates a new temporary value that is the double version of the int operand.
     * Java has rules for doing type promotion that are somewhat more involved. Here's the basic rules:
     *
     * 1. double
     * 2. float
     * 3. long
     * 4. int
     * 5. char or short
     * 6. byte
     */
    public double angleClock(int hour, int minutes) {
        // hDiff means the hour degree from the 12 point
        double hDiff = hour%12*30 + ((double)minutes/60)*30;
        // mDiff means the minutes degree from the 12 point
        double mDiff = ((double)minutes/60)*360;
        return Math.min(Math.abs(mDiff-hDiff), 360 - Math.abs(mDiff-hDiff));
    }
}
