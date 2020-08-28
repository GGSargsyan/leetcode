public class Main
{
    public int countVowelPermutation(int n) {
        
        //We use the mod when the values get too big
        int mod = 1000000007;
        long sum = 0;
        
        //Use Dynamic Programming to solve
        long[] counts = new long[5];
        Arrays.fill(counts, 1);
        
        for (int i = 1; i < n; i++) {
            
            long[] curr = new long[5];
            
            //a = 0
            curr[0] = (counts[1] + counts[2] + counts[4]) % mod;
            //e = 1
            curr[1] = (counts[0] + counts[2]) % mod;
            //i = 2
            curr[2] = (counts[1] + counts[3]) % mod;
            //o = 3
            curr[3] = counts[2];
            //u = 4
            curr[4] = (counts[2] + counts[3]) % mod;
            
            counts = curr;
        }
        
        for (long i : counts) 
            sum = (sum + i) % mod;
        
        return (int)sum;
    }
}
