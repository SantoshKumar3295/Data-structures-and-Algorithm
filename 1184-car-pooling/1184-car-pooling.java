class Solution {
    public boolean carPooling(int[][] trips, int capacity) {


        Arrays.sort(trips, (x,y) -> x[1]-y[1]);

        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a,b) -> a[2]-b[2]);

        for(int [] trip : trips) {

            while(!pq.isEmpty() && pq.peek()[2] <= trip[1]) {
                capacity += pq.poll()[0];
            }

            pq.add(trip);

            capacity -= trip[0];

            if(capacity < 0) return false;

        }

        return true;

    }
}