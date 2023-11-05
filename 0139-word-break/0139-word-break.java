class Solution {
    
       int []dp;
      
    
    public boolean wordBreak(String s, List<String> wordDict) {
        
        dp = new int[s.length()];
        return rec(s, wordDict, 0);
        
    }
    
    int isWordMatched(String s, String word, int pos) {
        
        if(s.length() - pos < word.length()) return -1;
        
        int j = 0;
        int i;
        
        for(i = pos; i < s.length() && j < word.length(); i++) {
            
            if(s.charAt(i) != word.charAt(j)) return -1;
            j++;
            
        }
        
        return i;
        
    }
    
    /*
    
    a a a a a a a
                |
    
    ["aaaa","aa"]
    
    
    
    */
    boolean rec(String s, List<String> wordDict, int pos) {
        
        
        if(dp[pos] != 0) return dp[pos] == 1;
        
        for(int i = 0; i < wordDict.size(); i++) {
            
            String word = wordDict.get(i);
            
            int nextIndex = isWordMatched(s, word, pos);
            
           // System.out.println(" "+nextIndex);
            
            if(nextIndex >= s.length()) return true;
        
            if(nextIndex != -1) {
                dp[nextIndex] = rec(s, wordDict, nextIndex) ? 1 : -1;
                if(dp[nextIndex] == 1) return true;
            }

        }
        
        return false;
        
        
    }
    
    
    
    
}