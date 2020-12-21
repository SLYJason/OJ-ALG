package LeetCode.LC_201_400.LC307;

/**
 * Solution 1: segment tree.
 */
public class Solution_1 {
    class NumArray {
        int[] nums;
        int[] segment_tree;
        public NumArray(int[] nums) {
            if(nums.length != 0) {
                this.nums = nums;
                this.segment_tree = new int[nums.length * 4];
                build_tree(0, 0, nums.length-1);
            }
        }

        public void update(int i, int val) {
            update_tree(0, 0, nums.length-1, i, val);
        }

        public int sumRange(int i, int j) {
            return sumRange(0, 0, nums.length-1, i, j);
        }

        private void build_tree(int index, int start, int end) {
            if(start == end) {
                segment_tree[index] = nums[start];
                return;
            }
            int left_index = 2 * index + 1;
            int right_index = 2 * index + 2;

            int mid = start + (end - start)/2;
            build_tree(left_index, start, mid);
            build_tree(right_index, mid+1, end);

            segment_tree[index] = segment_tree[left_index] + segment_tree[right_index]; // set the parent node.
        }

        private void update_tree(int index, int start, int end, int i, int val) {
            if(start == end) {
                segment_tree[index] = val;
                nums[i] = val;
                return;
            }
            int left_index = 2 * index + 1;
            int right_index = 2 * index + 2;

            int mid = start + (end - start)/2;
            if(i <= mid) {
                update_tree(left_index, start, mid, i, val);
            } else {
                update_tree(right_index, mid+1, end, i, val);
            }

            segment_tree[index] = segment_tree[left_index] + segment_tree[right_index]; // set the parent node.
        }

        private int sumRange(int index, int start, int end, int i, int j) {
            if(i > end || j < start) return 0; // [start, end] is out of the range [i, j].
            if(start >= i && end <= j) return segment_tree[index]; // [start, end] is in the range [i, j].

            int left_index = 2 * index + 1;
            int right_index = 2 * index + 2;

            int mid = start + (end - start)/2;
            int left_sum = sumRange(left_index, start, mid, i, j);
            int right_sum = sumRange(right_index, mid+1, end, i, j);
            return left_sum + right_sum;
        }
    }
}
