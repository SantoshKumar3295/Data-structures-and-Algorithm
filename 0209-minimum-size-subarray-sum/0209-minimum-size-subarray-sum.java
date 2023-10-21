class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        
        int sum = 0, left = 0, ans = Integer.MAX_VALUE;

        for(int right = 0; right < nums.length; right++) {

            sum += nums[right];

            while(left <= right && sum >= target) {
                ans = Math.min(ans, right-left+1);
                sum -= nums[left];
                left++;
            }
        }

        return ans == Integer.MAX_VALUE ? 0 : ans;




    }
}