class Solution {
    public int bestClosingTime(String customers) {

        int n = customers.length()    ;

        int [] suffixSum = new int [customers.length()];

        suffixSum[n-1] = customers.charAt(n-1) == 'Y' ? 1 : 0;

        for(int i = n-2; i >= 0; i--) {
            suffixSum[i] = suffixSum[i+1] + (customers.charAt(i) == 'Y' ? 1 : 0);
        }
        
        int prefixSum = 0;
        int result = 0;
        int minPenality = Integer.MAX_VALUE;

        for(int i = 0; i < customers.length(); i++) {

            int curr = (prefixSum+(customers.charAt(i) == 'Y' ? 1 : 0))  + (i+1 == n ? 0 : suffixSum[i+1]);

            if(curr < minPenality) {
                minPenality = curr;
                result = i;
            }

            prefixSum += customers.charAt(i) == 'Y' ? 0 : 1;
        }


        if(prefixSum < minPenality) {
            result = n;
        }

        return result;

    }
}