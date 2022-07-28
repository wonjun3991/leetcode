/**
 * @param {string} s
 * @param {string} t
 * @return {boolean}
 */
var isAnagram = function(s, t) {
    if(s.length != t.length){
        return false
    }
    
    const getStrCount = function(s){
        return  s.split('').reduce(
        function(preVal, curVal) {
            if(preVal[curVal]){
                preVal[curVal] =preVal[curVal] + 1    ;
            } else{
                preVal[curVal] = 1;
            }
            return preVal;
        }, []
    )
    } 
    
    const sResult = getStrCount(s);
    const tResult = getStrCount(t);
    
    for (char of Object.keys(sResult)){
        if(sResult[char] !== tResult[char]){
            return false
        }
    }
    
    return true
};