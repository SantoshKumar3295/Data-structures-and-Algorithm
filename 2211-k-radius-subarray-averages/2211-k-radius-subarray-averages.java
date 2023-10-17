class Solution {
    public int[] getAverages(int[] nums, int k) {

        int result[] = new int[nums.length];
        int left = 0;

        Arrays.fill(result, -1);

        int window = ((2*k)+1);

        if(nums.length < window) return result;
        
        long sum = 0;
        
        for(int i = 0; i < window-1; i ++) sum += nums[i];
        
        for(int right = window-1; right < nums.length; right++){

            sum += nums[right];
            //System.out.println(" A "+sum);
            result[right-k] = (int) (sum/window);
            sum -= nums[left++];
            //System.out.println(" B "+ sum);
        }

        return result;
    }
}