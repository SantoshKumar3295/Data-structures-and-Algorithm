class Solution {
    public long continuousSubarrays(int[] nums) {

        int left = 0;        

        long ans = 0;

        TreeMap<Integer, Integer> tMap = new TreeMap();

        for(int right = 0; right < nums.length; right++) {

            tMap.put(nums[right], tMap.getOrDefault(nums[right], 0)+1);

            while(tMap.lastEntry().getKey() - tMap.firstEntry().getKey() > 2) {

                tMap.put(nums[left], tMap.get(nums[left])-1);

                if(tMap.get(nums[left]) == 0) tMap.remove(nums[left]);

                left++;
            }

            ans += (right-left+1);
        }

        return ans;
    }

}