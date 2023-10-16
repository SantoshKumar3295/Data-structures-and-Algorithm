class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        
        int prod = 1, left = 0, ans = 0;

        for(int right = 0; right < nums.length; right++) {

            prod *= nums[right];

            while(prod >= k && left <= right) prod /= nums[left++];

            ans += right-left+1;
        }

        return ans;
    }
}