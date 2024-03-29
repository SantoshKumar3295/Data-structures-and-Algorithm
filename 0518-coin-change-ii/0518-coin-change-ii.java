class Solution {
    
    Integer memo[][];
    int coins[];

    public int change(int amount, int[] coins) {

        memo = new Integer[coins.length+1][amount+1];
        this.coins = coins;

        return rec(0, amount);

    }

    private int rec(int pos, int amount) {

        if(amount == 0) return 1;

        if(pos >= coins.length) return 0;

        if(amount < 0) return 0;

        if(memo[pos][amount] != null) return memo[pos][amount];

        int total = rec(pos, amount-coins[pos]) + rec(pos+1, amount);

        return memo[pos][amount] = total;

    }
}