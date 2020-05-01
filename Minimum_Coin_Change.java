class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] change = new int[amount+1];
        Arrays.fill(change, amount+1);
        change[0] = 0;
        
        for(int i = 1; i <= amount; i++){
            for(int coin : coins){
                if (i >= coin){
                   change[i] = Math.min(change[i], 1 + change[i-coin]); 
                }
            }
        }
        
        if(change[amount] == amount+1)
            return -1;
        return change[amount];
    }
}