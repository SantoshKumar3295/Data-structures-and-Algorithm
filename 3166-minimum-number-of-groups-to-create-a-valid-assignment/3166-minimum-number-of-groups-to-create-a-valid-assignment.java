public class Solution {
    public int minGroupsForValidAssignment(int[] nums) {
        
        HashMap<Integer, Integer> frequencyMap = new HashMap<>();

        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        List<Integer> frequencies = new ArrayList<>();

        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            frequencies.add(entry.getValue());
        }

        Collections.sort(frequencies);
        
        int minGroups = nums.length;
        
        for (int i = frequencies.get(0); i >= 1; --i) {
            boolean isValid = true;
            int totalGroups = 0;

            for (int frequency : frequencies) {
        
                final int quotient = frequency / i;
                final int remainder = frequency % i;

                
                if (remainder > quotient) {
                    //System.out.println("group : "+i +", freq : "+ frequency+", q : "+quotient+", r :"+remainder);
                    isValid = false;
                    break;
                }

                final int excess = (quotient - remainder) / (i + 1);
                
               

                totalGroups += quotient - excess;

                 
                //System.out.println("group : "+i +", freq : "+ frequency+", q : "
                //    +quotient+", r :"+remainder+", excess : "+excess+", total : "+totalGroups);
            }

            if (isValid) {
                return totalGroups;
            }
        }

        return minGroups;
    }
}
