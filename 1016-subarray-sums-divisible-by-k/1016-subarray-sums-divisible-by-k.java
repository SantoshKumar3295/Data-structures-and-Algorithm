
class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        int pfsum = 0;
        int ans = 0;
        hashMap.put(0,1);
        for(int i = 0;i<nums.length;i++){
            pfsum = pfsum + nums[i];
            int rem=pfsum%k;
            if(rem<0) rem+=k;
            
            if(hashMap.containsKey(rem))
                ans = ans+hashMap.get(rem);
            hashMap.put(rem, hashMap.getOrDefault(rem,0)+1);
            
        }
        return ans;
    }
}
