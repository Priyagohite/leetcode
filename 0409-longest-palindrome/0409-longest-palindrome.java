class Solution {
    public int longestPalindrome(String s) {
        HashMap<Character, Integer> ump = new HashMap<>();
        for (char ch : s.toCharArray()) {
            ump.put(ch, ump.getOrDefault(ch, 0) + 1);
        }

        int count = 0;
        boolean hasOdd = false;

        for (int freq : ump.values()) {
            if (freq % 2 == 0) {
                count += freq;
            } else {
                count += freq - 1;
                hasOdd = true;
            }
        }

        // If there is at least one odd count character, we can add one more character in the middle
        if (hasOdd) {
            count += 1;
        }

        return count;
    }
}