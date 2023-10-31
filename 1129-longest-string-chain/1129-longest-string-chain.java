class Solution {

    String [] words;
    Map<String, Integer> map;

    public int longestStrChain(String[] words) {

        if(words.length == 1) return 1;

        if(words.length == 0) return 0;

        map = new HashMap();

        Arrays.sort(words, (a,b) -> a.length() - b.length());

        int result = 0;

        for(String word : words) { 

            StringBuilder sb = new StringBuilder(word);
            int max = 0;

            for(int i = 0; i < word.length(); i++) {

                sb.deleteCharAt(i);

                int count = map.getOrDefault(sb.toString(), 0);

                max = Math.max(max, count+1);

                sb.insert(i, word.charAt(i));
            }

            map.put(word, max);

            result = Math.max(result, max);
        }
   
        return result;

    }

    private int dp(String word, int pos) {

        if(pos >= words.length) return 0;

       //if(map.containsKey(word)) return map.get(word);

        int max = 1;

        for(int i = pos; i < words.length; i++) {

            if(compare(word, words[i]) == 1) {

                max += 1;
                word = words[i];

            }
        }
        
        //map.put(word, max);

        return max;
    }

    int compare(String first, String second) {

        if(Math.abs(first.length() - second.length()) > 1) return 0;

        if(first.length() == second.length()) return first.equals(second) ? 1 : 0;

        int j = 0;
        int diff = 0;

        for(int i = 0; i < second.length() && j < first.length(); i++) {
            
            if(first.charAt(j) != second.charAt(i)) {
                diff++;
            } else {
                j++;
            }

            if(diff > 1) return 0;
        }

        return 1;
    }
}