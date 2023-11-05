/**
 * @param {string} word1
 * @param {string} word2
 * @return {number}
 */
var minDistance = function(word1, word2) {
    
    var dp = [[]];
    
    for(var i = 0; i <= word1.length; i++) {
        for(var j = 0; j <= word2.length; j++) {
            if(!dp[i]) dp[i] = [];
            if(i == 0) {
                dp[i][j] = j;
                continue;
            }
            
            if(j == 0) {
                dp[i][j] = i;
                continue;
            }
            
            if(word1[i-1] == word2[j-1]) {
                dp[i][j] = dp[i-1][j-1];   
            } else {
                dp[i][j] = 1;
                dp[i][j] += Math.min(Math.min(dp[i][j-1], dp[i-1][j]), dp[i-1][j-1]);   
            }            
        }
    }
    
    return dp[dp.length-1][dp[dp.length-1].length-1];
};
