class Solution {

    public long putMarbles(int[] weights, int k) {


        int splitPair [] = new int[weights.length-1];
        
        int n = weights.length;

        for(int i = 0; i < weights.length-1; i++) {
            splitPair[i] = weights[i]+weights[i+1];
        }

        Arrays.sort(splitPair,0,n-1);

        long min = 0, max = 0;

        for(int i = 0; i < k-1; i++) {
            min += (long) splitPair[i];
            max += (long) splitPair[n-2-i];
        }

        return max - min;

    }

}