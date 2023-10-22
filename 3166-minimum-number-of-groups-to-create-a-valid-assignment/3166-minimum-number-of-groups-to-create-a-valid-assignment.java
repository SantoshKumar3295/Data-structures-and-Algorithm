class Solution {

    public int minGroupsForValidAssignment(int[] nums) {
        HashMap<Integer, Integer> mp = new HashMap<>();
        for (int num : nums) {
            mp.put(num, mp.getOrDefault(num, 0) + 1);
        }

        int maxi = 0;
        int n = nums.length;

        HashMap<Integer, Integer> u = new HashMap<>();
        for (int i : nums) {
            u.put(i, u.getOrDefault(i, 0) + 1);
            maxi = Math.max(maxi, u.get(i));
        }

        for (int i = maxi; i >= 1; i--) {
            if (posi(i, u)) {
                int res = 0;
                for (Map.Entry<Integer, Integer> entry : u.entrySet()) {
                    int curr = entry.getKey();
                    int c = entry.getValue();

                    int left = c % i;

                    res = res + (c / i);
                    if (left > 0) res++;
                }
                return res;
            }
        }
        return -1;
    }

    public static boolean posi(int x, HashMap<Integer, Integer> u) {
        for (Map.Entry<Integer, Integer> entry : u.entrySet()) {
            int curr = entry.getKey();
            int cnt = entry.getValue();

            int left = cnt % x;
            int tt = cnt / x;

            if (left < x - 1) {
                int req = (x - 1) - left;
                if (tt >= req) left = x - 1;
            }

            if (left > 0 && left < x - 1) return false;
        }
        return true;
    }
}
