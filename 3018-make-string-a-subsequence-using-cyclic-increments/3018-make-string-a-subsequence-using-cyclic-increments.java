class Solution {
    public boolean canMakeSubsequence(String str1, String str2) {
        
        int first = 0, second = 0;
        
        while(first < str1.length() && second < str2.length()) {
            
            char next = (char) (str1.charAt(first) == 'z' ? 'a' : ((char)str1.charAt(first)+1));
                
            if(str1.charAt(first) == str2.charAt(second) || str2.charAt(second) == next) {
                second++;
            }
            
            first++;
        }
        
        if(second == str2.length()) return true;
        
        return false;
    }
}