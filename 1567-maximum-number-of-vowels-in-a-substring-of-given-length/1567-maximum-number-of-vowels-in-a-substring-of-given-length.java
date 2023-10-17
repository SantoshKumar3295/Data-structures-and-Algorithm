class Solution {
    public int maxVowels(String s, int k) {
        
        Set<Character> set = new HashSet();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');

        int left = 0;
        int max = 0;
        int count = 0;

        for(int right = 0; right < s.length(); right++) {

            char c = s.charAt(right);

            if(set.contains(c)) {
                count++;
            }
            
            max = Math.max(max, count);

            if(k-- > 1) {

            } else {
                if(set.contains(s.charAt(left))) count--;
                left++;
            }
        }

        return max;


    }
}