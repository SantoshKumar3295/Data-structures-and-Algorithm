class Solution {
    public int longestOnes(int[] nums, int k) {
        
        int left = 0, max = 0, zeroCount = 0;

        for(int right = 0; right < nums.length; right++) {

            if(nums[right] == 0) {
                if(zeroCount == k) {
                    while(left < nums.length && nums[left] == 1) {
                        left++;
                    }
                    left++;
                } else {
                    zeroCount++;
                }
            }

            max = Math.max(max, right-left+1);

        }

        return max;


    }
}