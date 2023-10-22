class Solution {

    public int minGroupsForValidAssignment(int[] nums) {
        HashMap<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        int maxFrequency = 0;
        int totalNumbers = nums.length;

        HashMap<Integer, Integer> uniqueFrequencyMap = new HashMap<>();
        for (int num : nums) {
            uniqueFrequencyMap.put(num, uniqueFrequencyMap.getOrDefault(num, 0) + 1);
            maxFrequency = Math.max(maxFrequency, uniqueFrequencyMap.get(num));
        }

        for (int i = maxFrequency; i >= 1; i--) {
            if (isPossible(i, uniqueFrequencyMap)) {
                int groups = 0;
                for (Map.Entry<Integer, Integer> entry : uniqueFrequencyMap.entrySet()) {
                    int currentNumber = entry.getKey();
                    int frequency = entry.getValue();

                    int leftOver = frequency % i;

                    groups += (frequency / i);
                    if (leftOver > 0) groups++;
                }
                return groups;
            }
        }
        return -1;
    }

    public boolean isPossible(int x, HashMap<Integer, Integer> uniqueFrequencyMap) {
        for (Map.Entry<Integer, Integer> entry : uniqueFrequencyMap.entrySet()) {
            int currentNumber = entry.getKey();
            int frequency = entry.getValue();

            int leftOver = frequency % x;
            int times = frequency / x;

            if (leftOver < x - 1) {
                int required = (x - 1) - leftOver;
                if (times >= required) leftOver = x - 1;
            }

            if (leftOver > 0 && leftOver < x - 1) return false;
        }
        return true;
    }
}
