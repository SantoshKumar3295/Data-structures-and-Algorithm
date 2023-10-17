class Solution {
    public int[] countServers(int n, int[][] logs, int x, int[] queries) {
        
        Map<Integer, Integer> qm = new HashMap();

        for(int i = 0; i < queries.length; i++) qm.put(queries[i],i);

        Arrays.sort(logs, (a,b) -> a[1]-b[1]);

        //System.out.println(Arrays.toString(queries));

        Arrays.sort(queries);
        
        int l = 0;
        // for(int[]log : logs) {
        //     System.out.println(l+" "+Arrays.toString(log));
        //     l++;
        // }

      

        int []result = new int[queries.length];

        Arrays.fill(result, n);

        int q = 0;
        int right = 0, left = 0;

        Map<Integer,Integer> set = new HashMap();

        while(q< queries.length && left < logs.length) {

           // System.out.println(left+" "+right+" "+qm.get(queries[q])+" "+set+" ");

            if(q < queries.length && logs[left][1] >= queries[q]-x) {
                if(right == logs.length) {
                    set.put(logs[right-1][0], set.getOrDefault(logs[right-1][0],0)+1);
                } else {
                    while(right < logs.length && logs[right][1] <= queries[q]) {
                        set.put(logs[right][0], set.getOrDefault(logs[right][0],0)+1);
                        right++;
                    }
                }
                result[qm.get(queries[q])] = n-set.size();
                q++;
            } else {
                
                if(set.containsKey(logs[left][0])) {
                    int curr = set.get(logs[left][0]);
                    if(curr == 1) {
                        set.remove(logs[left][0]);
                    } else {
                        set.put(logs[left][0], curr-1);
                    }
                }
                
                left++;

                if(left > right) right = left;
            }
            
            
        }

        return result;
    }
}