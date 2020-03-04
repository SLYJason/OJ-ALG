package LeetCode;

// binary search
public class LeetCode374 {
    int target;
    public int guessNumber(int n) {
        int left = 1, right = n;
        while(left < n) {
            int mid = left+ (right-left)/2;
            int res = guess(mid);
            if(res == 0) return mid;
            if(res == -1) right = mid-1;
            if(res == 1) left = mid+1;
        }
        return -1;
    }

    /* The guess API is defined in the parent class GuessGame.
        @param num, your guess
        @return -1 if my number is lower, 1 if my number is higher, otherwise return 0
        int guess(int num); */
    int guess(int num) {
        return Integer.compare(num, target);
    }
}
