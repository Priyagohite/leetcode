class Solution {
    public int specialArray(int[] nums) {
       Arrays.sort(nums);
        int n = nums.length;

        for (int x = 0; x <= n; x++) {
            int i = lowerBound(nums, x);

            if (n - i == x) {
                return x;
            }
        }

        return -1;
    }

    // Custom implementation of lower bound
    private int lowerBound(int[] nums, int x) {
        int left = 0;
        int right = nums.length;
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] >= x) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;  
    }
}