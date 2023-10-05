class Solution {
    /*
Idea : pick events from day 1 to day max.

if there is an event on a day add all of them ex:[1,1][1,1][1,2] [1,2] [1,3] ( to get this order sort pq by end time)

Just pick only one of them. ex: [1,1] . anscount++;

remove all other events for <= day . i.e  [1,1] which is duplicate and expired.

got for next day . day++;
*/

    public int maxEvents(int[][] events) {

        // We go by taking events by start time.
        Arrays.sort(events, new EventsComparator());
        
        // we order pq by end time time in ascending order. ex: [1,2] [1,3]
        PriorityQueue<int[]> pq = new PriorityQueue<>(new EventsComparatorV2());

        // finding max day
        int maxDay = 0;
        for(int[] event : events) {
            maxDay = Math.max(maxDay, event[1]);
        }
        
        // from day 1 to max day
        int day = 1;
        int i = 0;
        int res = 0;
        while(day<=maxDay) {
            
            // if there is any event on a day just add them.
            while(i<events.length && day == events[i][0]) {
                pq.add(events[i]);
                i++;
            }
            
            // just pick one event for that day.
            if(!pq.isEmpty()) {
                pq.remove();
                res++;
            }
            
            // As we already took for a day remove all events less than or equal to this day in pq.
            while(!pq.isEmpty() && pq.peek()[1] <= day) {
                pq.remove();
            }
            
            //go for next day.
            day++;
        }
        
        return res;
    }

    class EventsComparator implements Comparator<int[]> {
        public int compare(int[] a, int[] b) {
                return Integer.compare(a[0], b[0]);
        }
    }

    class EventsComparatorV2 implements Comparator<int[]> {
        public int compare(int[] a, int[] b) {
            
            if(a[1] == b[1])
                return Integer.compare(a[0], b[0]);
            else
                return Integer.compare(a[1],  b[1]);
        }
    }
}