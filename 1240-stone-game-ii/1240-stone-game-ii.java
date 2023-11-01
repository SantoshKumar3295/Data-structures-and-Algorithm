
    /*

    - [2,7,9,4,4]
       |
       
    - fill array with -1

    @cache
    - dp(p, pos, M)

        if(pos == arr.length) return 0
        
        i = pos

        for i in M
            s += arr[i]
            if p is alice
                ansp = s + dp(1, i+1, max(2*(i-pos+1), M), )
            else
                ansb = dp(0, i+1, max(2*(i-pos+1), M), )

            ans = max(ansp, ansb, ans)

    return ans
    */


class Solution {
    
    int[][][] dp;
    
    public int stoneGameII(int[] piles) {

        if(piles.length == 1) return piles[0];

        dp = new int[2][piles.length + 1][piles.length + 1];

        for(int grid [][] : dp)
            for(int row [] : grid)
                Arrays.fill(row, -1);

        return f(piles, 0, 0, 2);
    }

    private int f(int[] piles, int p, int i, int m) {

        if (i == piles.length) {
            return 0;
        }

        int M = (i+m)-1;

        if(M >= piles.length) m = piles.length;

        if(dp[p][i][m] != -1) return dp[p][i][m];

        int res = p == 1 ? Integer.MAX_VALUE : -1, s = 0;
        
        for(int x = i; x < (i+m) && x < piles.length; x++) {
            s += piles[x];

            if(p == 0) {
                res = Math.max(res, s+f(piles, 1, x+1, Math.max(2*(x-i+1),m)));
            } else {
                res = Math.min(res, f(piles, 0, x+1, Math.max(2*(x-i+1),m)));
            }
        }

        return dp[p][i][m] = res;
    }
}