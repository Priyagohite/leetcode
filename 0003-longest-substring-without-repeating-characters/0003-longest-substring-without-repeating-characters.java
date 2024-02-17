class Solution {
    public int lengthOfLongestSubstring(String s) 
    {
        
        int left = 0;
        int right = 0;
         int max=0;
        Set<Character> seen = new HashSet();
    

        
        while(right<s.length())
        {
            char c = s.charAt(right); //'a'
            
            if(seen.add(c))
            {
                max = Math.max(max,right-left+1);
                right++;
                
            }
            else
            {
                while(s.charAt(left)!=c)
                {
                    seen.remove(s.charAt(left));
                    left++;
                }
                 seen.remove(c);
                left++;
            }
        }
        return max;
    }
}