class Solution {

    int count [];
    int coins [];

    public int coinChange(int[] coins, int amount) {
        
        this.count = new int[amount];
        this.coins = coins;

        return dfs(amount);
    }

    private int dfs(int rem) {

        if(rem < 0) return -1;

        if(rem == 0) return 0;

        if(count[rem-1] != 0) return count[rem-1];

        int min = Integer.MAX_VALUE;
        
        for(int coin : coins) {
            
            int currMin = dfs(rem - coin);                

            if(currMin >= 0 && currMin < min)
                min = 1 + currMin;
        }

        count[rem - 1] = min == Integer.MAX_VALUE ? - 1 : min;

        return count[rem - 1];
    }
    
}