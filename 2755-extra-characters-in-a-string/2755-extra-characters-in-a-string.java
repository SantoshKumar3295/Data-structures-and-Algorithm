class Solution {

    Set<String> dict;
    Integer memo[];

    public int minExtraChar(String s, String[] dictionary) {
        
        memo = new Integer[s.length()];

        dict = new HashSet<String>(Arrays.asList(dictionary));
        
        return rec(0,s);

    }



    private int rec(int start, String s) {

        if(start >= s.length()) return 0;

        if(memo[start] != null) return memo[start];

        int min = rec(start+1,s) + 1;

        for(int end = start; end < s.length(); end++) {

            String sub = s.substring(start, end+1);

            if(dict.contains(sub)) {

                min = Math.min(min, rec(end+1,s));
        
            }        
        }

        return memo[start] = min;

    }

}