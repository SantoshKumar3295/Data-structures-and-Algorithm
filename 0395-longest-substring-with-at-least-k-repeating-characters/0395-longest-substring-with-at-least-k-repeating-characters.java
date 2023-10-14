public class Solution {
    public int longestSubstring(String s, int k) {

        int freq[] = new int[26];
        int max = 0;
        
        for(int currUnique = 1; currUnique <= 26; currUnique++) {

            Arrays.fill(freq, 0);
            int unique = 0, atLeastK = 0, start = 0, end = 0;

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
}
