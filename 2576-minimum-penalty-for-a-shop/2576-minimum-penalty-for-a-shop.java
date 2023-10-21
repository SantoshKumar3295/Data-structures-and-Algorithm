class Solution {
    public int bestClosingTime(String customers) {

        int n = customers.length();

        int suffixSum = 0;

        for(int i = n-1; i >= 0; i--) {
            suffixSum += customers.charAt(i) == 'Y' ? 1 : 0;
        }
        
        int prefixSum = 0;
        int result = 0;
        int minPenality = Integer.MAX_VALUE;

        for(int i = 0; i < customers.length(); i++) {

            int type = customers.charAt(i) == 'Y' ? 1 : 0;

            suffixSum -= type;

            int curr = (prefixSum+type) + suffixSum;

            if(curr < minPenality) {
                minPenality = curr;
                result = i;
            }

            prefixSum += 1-type;;
        }

        if(prefixSum < minPenality) {
            result = n;
        }

        return result;


        /*
        int n = customers.length();

        int [] suffixSum = new int [customers.length()+1];

        suffixSum[n-1] = customers.charAt(n-1) == 'Y' ? 1 : 0;

        for(int i = n-2; i >= 0; i--) {
            suffixSum[i] = suffixSum[i+1] + (customers.charAt(i) == 'Y' ? 1 : 0);
        }
        
        int prefixSum = 0;
        int result = 0;
        int minPenality = Integer.MAX_VALUE;

        for(int i = 0; i < customers.length(); i++) {

            int type = customers.charAt(i) == 'Y' ? 1 : 0;

            int curr = (prefixSum+type) + suffixSum[i+1];

            if(curr < minPenality) {
                minPenality = curr;
                result = i;
            }

            prefixSum += 1-type;;
        }

        if(prefixSum < minPenality) {
            result = n;
        }

        return result;
        */

    }
}