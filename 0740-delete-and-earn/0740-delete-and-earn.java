class Solution {

    Map<Integer, Integer> cache;

    public int deleteAndEarn(int[] nums) {
        
        TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>((x, y) -> y - x);

        cache = new HashMap();
        
        for(int num : nums) 
            map.put(num, map.getOrDefault(num,0)+1);

        return rec(map);

        
    }

    private int rec(TreeMap<Integer, Integer> map) {

        if(map.isEmpty()) return 0;

        int max = 0;

        int key = map.firstEntry().getKey();

        if(cache.containsKey(key)) return cache.get(key);
        
        int value = map.get(key);

        int minus = map.getOrDefault(key-1, -1);

        if(minus != -1) map.remove(key-1);

        map.remove(key);

        int pick = (key * value) + rec(map);
        
        if(minus != -1) {
            map.put(key-1, minus);
        }

        int notPick = rec(map);

        map.put(key, value);
        
        max = Math.max(pick, notPick);

        cache.put(key, max);

        return max;
    }


}