class Solution {

    int memo[];
    int nums[];

    public int rob(int[] nums) {

        this.nums = nums;

        memo = new int[nums.length];

        Arrays.fill(memo, -1);

        return dp(0);
        






    }


    public int dp(int pos) {

        if(pos >= nums.length) return 0;

        if(memo[pos] != -1) return memo[pos];

        int max = 0;

        int i = pos;

            int first = nums[i]+dp(i+2);
            int second = dp(i+1);

            first = Math.max(first,second);

            max = Math.max(first, max);

        

        memo[pos] = max;

        return max;




    }

}