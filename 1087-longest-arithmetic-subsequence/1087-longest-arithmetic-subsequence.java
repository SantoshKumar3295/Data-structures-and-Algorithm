class Solution {
    public int longestArithSeqLength(int[] nums) {
        
        Map<Integer, Integer> map [] = new HashMap[nums.length];

        int max = 0;

        for(int right = 0; right < nums.length; right++) {

            map[right] = new HashMap();

            for(int left = 0; left < right; left++) {

                int diff = nums[right] - nums[left];

                int count = map[left].getOrDefault(diff,1) + 1;

                map[right].put(diff, count);

                max = Math.max(count, max);

            }

        }
        
        return max;


    }
}