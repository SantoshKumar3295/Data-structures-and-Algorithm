class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        int[] pointers = new int[nums.size()];
        int minRange = Integer.MAX_VALUE;
        int[] result = new int[2];
        
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(Comparator.comparing(i -> nums.get(i).get(pointers[i])));
        int max = Integer.MIN_VALUE;
        
        for (int i = 0; i < nums.size(); i++) {
            minHeap.offer(i);
            max = Math.max(max, nums.get(i).get(0));
        }
        
        while (true) {
            int minListIdx = minHeap.poll();
            int minVal = nums.get(minListIdx).get(pointers[minListIdx]);
            if (max - minVal < minRange) {
                minRange = max - minVal;
                result[0] = minVal;
                result[1] = max;
            }
            pointers[minListIdx]++;
            if (pointers[minListIdx] == nums.get(minListIdx).size()) {
                break;
            }
            minHeap.offer(minListIdx);
            max = Math.max(max, nums.get(minListIdx).get(pointers[minListIdx]));
        }
        
        return result;
    }
}
