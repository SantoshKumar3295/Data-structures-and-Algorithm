class Solution {
    public int minOperations(int[] nums, int x) {

        int total = 0, left = 0;

        for(int num : nums) total += num;

        int result = Integer.MAX_VALUE;

        for(int right = 0; right < nums.length; right++) {
            
            total -= nums[right];

            while(total < x && left <= right) {
                total += nums[left++];
            }

            if(total == x) {
                result = Math.min(result, (nums.length-1 - right) + left);
            }
        }

        return result == Integer.MAX_VALUE ? -1 : result;

    }

}