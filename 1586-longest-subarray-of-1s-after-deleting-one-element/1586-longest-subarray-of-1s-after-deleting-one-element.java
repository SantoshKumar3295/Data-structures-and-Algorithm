class Solution {

    public int longestSubarray(int[] nums) {
        

        int max = 0, left = 0;
        boolean zero = false;

        for(int right = 0; right < nums.length; right++) {

            if(nums[right] == 0) {

                if(zero) {

                    while(nums[left] == 1) {
                        left++;
                    }

                    left++;

                } else {
                    zero = true;
                }
            }


            max = Math.max(right-left, max);

        }

        return max;
    }

}