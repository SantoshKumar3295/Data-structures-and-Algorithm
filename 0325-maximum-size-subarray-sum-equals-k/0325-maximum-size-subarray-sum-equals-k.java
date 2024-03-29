class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        
        
        Map<Integer, Integer> map = new HashMap();

        int sum = 0;
        int max = 0;
        
        map.put(0,-1);

        for(int i = 0; i < nums.length; i++) {

            sum += nums[i];

            //if(sum == k) max = i+1;

            if(map.containsKey(sum-k)) {
                max = Math.max(max, i-map.get(sum-k));
            }

            if(!map.containsKey(sum))
                map.put(sum, i);

        }

        return max;

    }
}