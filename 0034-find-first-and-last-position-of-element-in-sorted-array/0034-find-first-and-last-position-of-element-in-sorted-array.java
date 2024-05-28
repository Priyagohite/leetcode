class Solution {
    public int[] searchRange(int[] nums, int target) {
       
        int l = lowerBound(nums, target);
        int r = upperBound(nums, target);
        
        if (l == nums.length || nums[l] != target) {
            return new int[]{-1, -1};
        }
        
        return new int[]{l, r - 1};
    }
    
    private int lowerBound(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        
        return left;
    }
    
    private int upperBound(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        
        return left;
    }
}