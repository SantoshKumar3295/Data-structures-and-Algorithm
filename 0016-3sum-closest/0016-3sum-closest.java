class Solution {
    public int threeSumClosest(int[] nums, int target) {
        
        Arrays.sort(nums);
        int min = Integer.MAX_VALUE;

        for(int i = 0; i < nums.length-2; i++) {

            if(i > 0 && nums[i-1] == nums[i]) continue;

            int left = i+1;
            int right = nums.length-1;

            while(left < right) {

                int curr = nums[left]+nums[right]+nums[i];

                if(curr == target) return curr;

                if(Math.abs(target-curr) < Math.abs(target-min)) {
                    min = curr;
                }

                if(curr > target) {
                    right--;
                } else {
                    left++;
                }
            }

        }

        return min;



    }
}