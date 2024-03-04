class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);
        int i=0,j=tokens.length-1;
        int score=0;
        while(i<=j)
        {
            if(tokens[i]<=power)
            {
                power-=tokens[i++];
                score++;
            }
            else
            {
               if(power+tokens[j]>=tokens[i] && score!=0 && j!=i)
               {
                   power+=tokens[j--];
                   score--;
               }
               else
               {
                  break;
               }
            }
        }
        return score;
    }
}