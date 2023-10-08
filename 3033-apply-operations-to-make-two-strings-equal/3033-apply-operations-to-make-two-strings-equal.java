class Solution {
    
    char sc[];
    int x;
    String s2;
    int n;
    public boolean possible;
    int memo[][];
    
    public int minOperations(String s1, String s2, int x) {
        
        
        sc = s1.toCharArray();
        this.x = x;
        this.s2 = s2;
        this.n = s2.length();
        this.possible = true;
        
        this.memo = new int[s1.length()][2];
        
        for(int m[] : memo)
            Arrays.fill(m, Integer.MAX_VALUE);
        

        int r = rec(0,0);
        //System.out.println(possible);
        
        return this.possible ?  r : -1;
        
    }
    
    public int rec(int pos, int j) {
        
        if(pos >= n) return 0;
     
            
        if(pos == n-1 && j == 0 && sc[pos] != s2.charAt(pos)) {
            this.possible = false;    
            return 0;
        } 

        if(pos == n-2 && j == 0) {
            
            if(sc[pos] == s2.charAt(pos) && sc[pos+1] != s2.charAt(pos+1)) {
                this.possible = false;  
                return 0;
            } else if(sc[pos] != s2.charAt(pos) && sc[pos+1] == s2.charAt(pos+1)) {
                this.possible = false;  
                return 0;
            }
        }
        
        
        int r = Integer.MAX_VALUE;
        
        if(memo[pos][j] != r) return memo[pos][j];
        
        if(sc[pos] != s2.charAt(pos)) {
            
            sc[pos] = sc[pos] == '1' ? '0' : '1';
            
            if(pos+1 < n) {
                sc[pos+1] = sc[pos+1] == '1' ? '0' : '1';
                r = Math.min(r, 1+rec(pos+1, j));
                sc[pos+1] = sc[pos+1] == '1' ? '0' : '1';
            }
            
//             sc[pos] = sc[pos] == '1' ? '0' : '1';
//             sc[pos+1] = sc[pos+1] == '1' ? '0' : '1';
            
            if(j == 0) {  
                r = Math.min(r, x+rec(pos+1, 1));
            } else {
                r = Math.min(r, rec(pos+1,0));
            }
            
            sc[pos] = sc[pos] == '1' ? '0' : '1';

        } else {
            r = Math.min(r, rec(pos+1,j));
        }
        
        return memo[pos][j]=r;
        
    }
}