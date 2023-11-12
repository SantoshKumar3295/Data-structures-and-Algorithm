class Solution {
    
    int pick[][] = {{100,0}, {75, 25}, {50, 50}, {25, 75}};
    double memo[][];

    public double soupServings(int n) {

        if(n > 17000) return 1;
        
        memo = new double[n+1][n+1];

        return rec(n,n);
    }


    private double rec(int a, int b) {

        if(a <= 0 && b <= 0) return 0.5;

        if(a <= 0) return 1;
 
        if(b <= 0) return 0;

        if(memo[a][b] != 0) return memo[a][b];

        double ans = 0;

        for(int p[] : pick) {
            ans += rec(a-p[0], b-p[1]);
        }

        return memo[a][b] = ans * 0.25;

    }

}