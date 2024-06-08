class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
       int n = nums.length;

        // Using a HashMap to store remainder and its index
        HashMap<Integer, Integer> map = new HashMap<>();
        // Initialize with remainder 0 at index -1 to handle the case when subarray starts from index 0
        map.put(0, -1);

        int sum = 0;

        for (int i = 0; i < n; i++) {
            sum += nums[i];
            
            // Calculate remainder of sum when divided by k
            int remainder = sum % k;

            // If remainder is negative, make it positive by adding k (handling negative numbers)
            if (remainder < 0) {
                remainder += k;
            }

            if (map.containsKey(remainder)) {
                // Check if the subarray length is at least 2
                if (i - map.get(remainder) >= 2) {
                    return true;
                }
            } else {
                // Store the first occurrence of this remainder
                map.put(remainder, i);
            }
        }
        return false;
    }
}