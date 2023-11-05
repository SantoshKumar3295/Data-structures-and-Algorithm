class Solution {

    List<List<String>> result;
    List<String> curr;
    boolean dp[][];

    public List<List<String>> partition(String s) {
        
        dp = new boolean[s.length()][s.length()];

        curr = new ArrayList();
        result = new ArrayList();

        for(int i = 0; i < s.length(); i++) {

            for(int j = 0; j <= i; j++) {


                if(i==j) {
                    dp[i][j] = true;
                    continue;
                }


                if(s.charAt(i) == s.charAt(j) && (j+1 == i || dp[i-1][j+1])) {    
                    dp[i][j] = true;
                }
            }
        }

        //  for(int i = 0; i < s.length(); i++) {
        //     for(int j = 0; j <= i; j++) {
        //         if(s.charAt(i) == s.charAt(j) && (i - j <= 2 || dp[j+1][i-1])) {
        //             dp[j][i] = true;
        //         }
        //     }
        // }


        dfs(s, 0);

        return result;

    }


    private void dfs(String s, int pos) {

        if(pos == s.length()) {
            result.add(new ArrayList(curr));
            return;
        }


        for(int i = pos; i < s.length(); i++) {
            if(dp[i][pos]) {
                curr.add(s.substring(pos, i+1));
                dfs(s, i+1);
                curr.remove(curr.size()-1);
            }
        }

    }
}