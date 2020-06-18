package LeetCode.BinarySearch;

public class LeetCode275 {
    public int hIndex(int[] citations) {
        if(citations.length == 0) return 0;
        int left = 0, right = citations.length-1, mid = 0, n = citations.length;
        while(left <= right) {
            mid = left + (right-left)/2;
            if(citations[mid] == n - mid) return n - mid;
            if(citations[mid] < n - mid) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return n - left;
    }
}
