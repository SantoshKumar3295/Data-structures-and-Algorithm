public class Solution {
    public int longestSubstring(String s, int k) {

        int freq[] = new int[27];
        int max = 0;
        
        for(int currUnique = 1; currUnique <= getMaxUniqueLetters(s); currUnique++) {
            

            Arrays.fill(freq, 0);

            int unique = 0;
        
            int atLeastK = 0;

            int start = 0, end = 0;

            while(end < s.length()) {

                if(unique <= currUnique) {

                    int c = s.charAt(end)-'a';

                    if(freq[c] == 0) unique++;

                    freq[c]++;

                    if(freq[c] == k) atLeastK++;

                    end++;

                } else {

                    int c = s.charAt(start)-'a';

                    if(freq[c] == k) atLeastK--;

                    freq[c]--;

                    if(freq[c] == 0) unique--;

                    start++;
                }

                if(atLeastK == unique && currUnique == unique) {
                    max = Math.max(max, end-start);
                }
            }
        }
        return max;
    }

       // get the maximum number of unique letters in the string s
    int getMaxUniqueLetters(String s) {
        boolean map[] = new boolean[26];
        int maxUnique = 0;
        for (int i = 0; i < s.length(); i++) {
            if (!map[s.charAt(i) - 'a']) {
                maxUnique++;
                map[s.charAt(i) - 'a'] = true;
            }
        }
        return maxUnique;
    }
}
