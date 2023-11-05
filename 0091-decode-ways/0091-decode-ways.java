class Solution {
    
    Map<Integer, Integer> map = new HashMap();
    
    public int numDecodings(String s) {
        
        
            
        return find(s,-1,true);
        
    }
    
    public int find(String s, int from, boolean isSingle) {
        
        if(from != -1) {
            
            if(from > s.length() - 1) return 0;

            if(isSingle && s.charAt(from) == '0') return 0;

            if(!isSingle && (s.charAt(from-1) == '0' || (Integer.parseInt(s.charAt(from-1) + "" + s.charAt(from)) > 26))) return 0;
            
            //System.out.println(from +" s" + map.toString());
            
            if(from == s.length()-1) return 1;
            
            //System.out.println(from);
        }
        
        int singleC = 0;
        int doubleC = 0;
    
        if(map.containsKey(from)) {
            return map.get(from);
        } else {
            singleC = find(s, from+1, true);
            doubleC = find(s, from+2, false);
        }
        
        map.put(from, singleC+doubleC);
         
        
        return singleC+doubleC;
    }
    
}