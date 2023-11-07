class Solution {

    int [] nums;
    Boolean [] memo;

    public boolean validPartition(int[] nums) {

        this.nums = nums;
        
        memo = new Boolean[nums.length];

        return rec(0);

    }


    private boolean rec(int pos) {

        if(pos >= nums.length) return true;

        if(pos == nums.length-1) return false;

        if(pos == nums.length-2) {
            return nums[pos] == nums[pos+1];
        }

        if(memo[pos] != null) return memo[pos];

        int i = pos;

        if(nums[i] == nums[i+1]) {

            if(rec(i+2)) {
                return memo[pos] = true;
            }

            if(nums[i+1] == nums[i+2]) {
                if(rec(i+3)) {
                    return memo[pos] = true;
                }
            }

        } else if((nums[i]+1) == nums[i+1] && (nums[i+1] + 1) == nums[i+2]) {

            if(rec(i+3)) {
                return memo[pos] = true;
            }

        } else {

            return memo[pos] = false;
        }
        

        return memo[pos] = false;
    }
}