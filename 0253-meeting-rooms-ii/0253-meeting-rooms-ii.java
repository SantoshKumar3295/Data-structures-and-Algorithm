class Solution {
    public int minMeetingRooms(int[][] intervals) {

        Queue<Integer> heap = new PriorityQueue<>();

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        int result = 0;
        
        for(int[] i : intervals) {

            if(heap.peek() == null) {
                result++;
                heap.add(i[1]);
                continue;
            }


            if(heap.peek() > i[0]) {
                heap.add(i[1]);
                result++;
            } else {
                heap.poll();
                heap.add(i[1]);
            }
        }

        return result;


    }
}