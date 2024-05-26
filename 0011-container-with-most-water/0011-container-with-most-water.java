class Solution {
    public int maxArea(int[] height) {
       int n = height.length;
        int i = 0, j = n-1;
        
        int water = 0;
        while(i<j) {
            
            //start from the smallest one and calculate water
            int h = Math.min(height[i], height[j]);
            int w = j-i;
            int area = h*w;
            water = Math.max(water, area);
            
            if(height[i] < height[j])
                i++;
            else
                j--;
        }
        
        return water; 
    }
}