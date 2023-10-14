class Solution {
    public int maxFrequency(int[] nums, int k) {

        Arrays.sort(nums);
        int sum = 0;
        int left = 0, right = 0;
        int max = 0;

        while(right < nums.length) {

            sum += nums[right];

            if((nums[right]*(right-left+1))-sum > k) {
                sum -= nums[left];
                left++;
            }

            right++;

            max = Math.max(max, right-left);

        }

        return max;


    }
}