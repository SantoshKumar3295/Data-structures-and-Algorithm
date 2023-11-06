class Solution {
    public int longestSubsequence(int[] arr, int difference) {
        
        Map<Integer, Integer> map = new HashMap();

        int max = 0;

        for(int num : arr) {

            int curr = num - difference;

            int count = map.getOrDefault(curr, 0);

            map.put(num, count+1);

            max = Math.max(max, count+1);
        }

        return max;

    }

}