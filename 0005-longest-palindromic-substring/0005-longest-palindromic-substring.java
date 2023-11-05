class Solution {
    
    public String longestPalindrome(String s) {

        int [][] dp = new int[s.length()][s.length()];

        String result = String.valueOf(s.charAt(0));

        for(int i = 0; i < s.length(); i++) {

            for(int j = 0; j <= i; j++) {


                if(i==j) {
                    dp[i][j] = 1;
                    continue;
                }


                if(s.charAt(i) == s.charAt(j)) {

                    if(i-1 >= 0 && j+1 < s.length() && dp[i-1][j+1] == 1 || j+1 == i) {
                        
                        String str = s.substring(j,i+1);

                        if(str.length() > result.length()) {
                            result = str;
                        }
                        
                        dp[i][j] = 1;
                    }

                }
            }
        }

        return result;

    }
}