class Solution {
    public int maxFrequencyElements(int[] nums) {
        Map<Integer , Integer> map = new HashMap<>();
        int max = 0;
        for(int i = 0; i < nums.length ; i++)
        {
            if(map.containsKey(nums[i]))
            {
                map.put(nums[i] , map.get(nums[i])+1);
            }
            else
            {
                map.put(nums[i],1);
            
            }
            if(map.containsKey(nums[i]) && map.get(nums[i]) > max)
            {
                max = map.get(nums[i]);
            }
        }
        int count = 0;
        List<Integer> list = new ArrayList<>(map.values());
        for(int num : list)
        {
            if(num == max)
            {
                count += num;
            }
        }
        return count;
    }
}