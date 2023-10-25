class Solution {                                                                            
    public int numSubseq(int[] nums, int target) {

        int n = nums.length;

       // 1000000007
       // 1000000007
       // 2147483647

        int mod = (int) Math.pow(10, 9) + 7;

        System.out.println(mod+" "+ Integer.MAX_VALUE);

        // 2^n subsequence for each n size
        int pow2n [] = new int[nums.length];

        pow2n[0] = 1;

        for(int i = 1; i < n; i++)
            pow2n[i] = (pow2n[i-1] * 2) % mod;
        
        Arrays.sort(nums);

        int answer = 0, left = 0, right = n-1;

        while(left <= right) {

            if(nums[left]+nums[right] <= target) {
                answer += pow2n[right-left];
                answer %= mod;
                left++;
            } else if(nums[left]+nums[right] > target) {
                right--;
            } else {
                left++;
            }
        }

        return answer;


    }
}