class Solution {

    /*

        "a","b","b","b","b","till 10","c","c"
                                                |                     |
        
        base case right < numsLen && left <= right

        if(currChar != nums[right])
            
            int len = right-left+1

            if(len == 1) {

                left++
                right++;

            } else if (len > 9) {
                
                left++;

                2 4 5 

                10 -> 24
                




                nums[left] = len;

                left = right;

                right++;
                
            } else {

                left++;
                nums[left] = len;
                left = right

                right++;
            }


        } else {

            right++;

        }

        



    */


    public int compress(char[] chars) {

        if(chars.length == 0) return 0;

        int left = 0, right = 0, total = 0;
        
        while(right < chars.length) {
            
            int g = 1;

            while(right+g < chars.length && chars[right+g] == chars[right]) {
                g++;
            }

            chars[left++] = chars[right];
            
            if(g > 1) {
                for(char c : Integer.toString(g).toCharArray()) chars[left++] = c;
            }

            right += g;
        }

        return left;
    }
}