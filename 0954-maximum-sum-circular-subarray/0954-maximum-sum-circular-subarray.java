class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        
        int total = 0;
        
        int max = Integer.MIN_VALUE, currMax = 0, currMin = 0, min = Integer.MAX_VALUE;

        for(int num : nums) {
            
            currMax = Math.max(num, currMax+num);

            max = Math.max(max, currMax);


            currMin = Math.min(num, num + currMin);
            
            min = Math.min(currMin, min);

            total += num;

        }
        
        //System.out.println(total+" "+min+" "+max);

        if (total == min) {
            return max;
        }

        return Math.max(max, total - min);
        



    }
}