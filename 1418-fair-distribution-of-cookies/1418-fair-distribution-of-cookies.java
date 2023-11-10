class Solution {

    int dist [];
    int cookies [];
    public int distributeCookies(int[] cookies, int k) {

        this.cookies = cookies;
        dist = new int[k];

        return dfs(0, k);
    }

    private int dfs(int pos, int leftChilds) {

        if(cookies.length - pos < leftChilds) 
            return Integer.MAX_VALUE;

        if(pos >= cookies.length) {

            int max = 0;

            for(int d : dist) max = Math.max(max, d);

            return max;

        }


        int min = Integer.MAX_VALUE;


        for(int i = 0; i < dist.length; i++) {
            
            leftChilds -= dist[i] == 0 ? 1 : 0;

            dist[i] += cookies[pos];

            min = Math.min(min, dfs(pos+1, leftChilds));

            dist[i] -= cookies[pos];

            leftChilds += dist[i] == 0 ? 1 : 0;

        }


        return min;

    }
}