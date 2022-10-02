/**
 * @param {string} s
 * @return {number}
 */
var balancedStringSplit = function(s) {
    let split = 0;
    let right = 0;
    let left = 0;
    
    
    s.split('').forEach(function(s){
        if(s === "L"){
            left = left + 1;
        }
        if( s === "R"){
            right = right + 1;
        }
        
        if(right === left){
            right = 0;
            left = 0;
            split = split + 1;
        }
    });
    
    return split;
};