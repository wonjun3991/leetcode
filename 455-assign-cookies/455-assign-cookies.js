/**
 * @param {number[]} g
 * @param {number[]} s
 * @return {number}
 */
var findContentChildren = function(g, s) {
	g.sort(function (a, b) {  return a - b;  });
    s.sort(function (a, b) {  return a - b;  });
    
    let child_i = 0 
    let cookie_j = 0
    
    while (child_i < g.length && cookie_j < s.length){
        if (s[cookie_j] >= g[child_i]){
            child_i += 1
        }
        	
        cookie_j += 1
    }
    return child_i    
};