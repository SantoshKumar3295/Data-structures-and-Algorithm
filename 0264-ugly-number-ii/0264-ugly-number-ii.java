class Solution {
    public int nthUglyNumber(int n) {

        PriorityQueue<Long> pq = new PriorityQueue();
        
        Set<Long> set = new HashSet();

        long [] pfs = {2,3,5};

        pq.add(1l);

        int k = 0;

        int ans = 1;

        while(k < n) {
            
            long curr =  pq.poll();
            ans = (int) curr;
            k++;

            for(long pf : pfs) {

                long p = curr * pf;

                if(!set.contains(p)) {
                    set.add(p);
                    pq.add(p);
                }
            }
        }
        return ans;
    }
}