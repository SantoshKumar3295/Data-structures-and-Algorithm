public class Solution {
    public int minGroupsForValidAssignment(int[] nums) {
        
        HashMap<Integer, Integer> frequencyMap = new HashMap<>();

        for (int num : nums)
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
   
        int minGroups = nums.length;
        
        for (int i = nums.length; i >= 1; --i) {
            boolean isValid = true;
            int totalGroups = 0;

            for (int key : frequencyMap.keySet()) {
                
                int frequency = frequencyMap.get(key);

                final int quotient = frequency / i;
                final int remainder = frequency % i;

                if (remainder > quotient) {
                    isValid = false;
                    break;
                }

                int excess = (quotient - remainder) / (i + 1);
                
                totalGroups += quotient - excess;
            }

            if (isValid) 
                return totalGroups;
        }
        return minGroups;
    }
}
