class Solution {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        
        Map<Character, Integer> map = new HashMap();

        int max = 0, left = 0;

        int maxS = 0;

        for(int right = 0; right < answerKey.length(); right++) {

            char c = answerKey.charAt(right);

            map.put(c, map.getOrDefault(c,0)+1);

            if(max < map.get(c))
                max = map.get(c);

            while(left <= right && (max+k) < (right-left+1)) {

                char leftC = answerKey.charAt(left);
                
                if(map.get(leftC) == 1) {
                    map.remove(leftC);
                } else {
                    map.put(leftC, map.get(leftC)-1);
                }

                left++;
            }

            maxS = Math.max(maxS, right-left+1);            

        }

        return maxS;

    }
}