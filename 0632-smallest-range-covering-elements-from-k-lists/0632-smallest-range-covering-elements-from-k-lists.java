class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a, b) -> a[0] - b[0]);
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < nums.size(); i++) {
            List<Integer> list = nums.get(i);
            if (!list.isEmpty()) {
                pq.add(new int[]{list.get(0), i, 0});
                max = Math.max(max, list.get(0));
            }
        }

        int minR = Integer.MAX_VALUE, maxR = Integer.MIN_VALUE;
        int minDiff = Integer.MAX_VALUE;

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int i = curr[1];
            int j = curr[2];
            int min = curr[0];

            if (max - min < minDiff) {
                minDiff = max - min;
                minR = min;
                maxR = max;
            }

            if (j + 1 < nums.get(i).size()) {
                int nextVal = nums.get(i).get(j + 1);
                if (nextVal > max) {
                    max = nextVal;
                }
                
               

                pq.add(new int[]{nextVal, i, j + 1});
            } else {
                 return new int[]{minR, maxR};
            }
        }

        return new int[]{minR, maxR};
    }
}
