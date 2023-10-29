class Solution {

    int memo[][];
    int nums[];

    public int rob(int[] nums) {

        this.nums = nums;

        if(nums.length == 1) return nums[0];
        
        memo = new int[nums.length][3];

        for(int m[] : memo)
            Arrays.fill(m, -1);

        return dp(0,0);
    }


    public int dp(int pos, int fc) {

        if(pos >= nums.length) return 0;

        if(memo[pos][fc] != -1) return memo[pos][fc];

        int max = 0;

        int len = fc == 2 ? nums.length : nums.length-1;
        
        int i = pos;

        if(i >= len) return 0;

            int first = nums[i]+dp(i+2, fc == 0 ? 1 : fc);


            int second = dp(i+1, fc == 0 ? 2 : fc);

            first = Math.max(first,second);

            max = Math.max(first, max);

        

        memo[pos][fc] = max;

        return max;

    }

}