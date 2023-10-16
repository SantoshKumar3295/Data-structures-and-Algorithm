class Solution {
    public int[] countServers(int n, int[][] logs, int x, int[] queries) {
        int m = logs.length;
        List<int[]> vp = new ArrayList<>();
        for (int[] log : logs) {
            vp.add(new int[]{log[1], log[0]});
        }
        Collections.sort(vp, (a, b) -> a[0] - b[0]);

        int q = queries.length;
        Map<Integer, Integer> mp = new HashMap<>();

        int[] ans = new int[q];
        List<int[]> time = new ArrayList<>();
        for (int i = 0; i < q; i++) {
            time.add(new int[]{queries[i], i});
        }
        Collections.sort(time, (a, b) -> a[0] - b[0]);

        int i = 0, j = 0;
        for (int[] tm : time) {
            int curtime = tm[0];
            int ind = tm[1];

            int start = Math.max(0, curtime - x);
            int end = curtime;

            while (j < m && vp.get(j)[0] <= end) {
                mp.put(vp.get(j)[1], mp.getOrDefault(vp.get(j)[1], 0) + 1);
                j++;
            }
            while (i < m && vp.get(i)[0] < start) {
                if (mp.getOrDefault(vp.get(i)[1], 0) == 1) {
                    mp.remove(vp.get(i)[1]);
                } else {
                    mp.put(vp.get(i)[1], mp.get(vp.get(i)[1]) - 1);
                }
                i++;
            }
            ans[ind] = n - mp.size();
        }

        return ans;
    }
}
