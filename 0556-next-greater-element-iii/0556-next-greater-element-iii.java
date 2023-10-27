class Solution {
    public int nextGreaterElement(int n) {
        
        char cNums [] = Integer.toString(n).toCharArray();

        int nums[] = new int[cNums.length];

        int i = 0;

        for(char c : cNums) {
            nums[i++] = Character.getNumericValue(c);
        }

        int k;

        for(k = nums.length-2; k >= 0; k--) {
            if(nums[k] < nums[k+1]) break; 
        }

        if(k < 0) return -1;

        for(int l = nums.length-1; l > k; l--) {
            if(nums[k] < nums[l]) {

                int temp = nums[k];
                nums[k] = nums[l];
                nums[l] = temp;

                reverse(k+1, nums.length-1, nums);

                break;
            }
        }

        System.out.println(Arrays.toString(nums));

        String result = "";

        for(int num : nums) {
            result = result+num;
        }

        try {
            return Integer.parseInt(result);
        } catch(Exception e) {
            return -1;
        }

    }

    public void reverse(int start, int end, int [] nums) {

        while(start < end) {

            int temp = nums[start];
            nums[start] = nums[end];
            nums[end]  = temp;
            start++;
            end--;
        }
    }
}