/**
 * @param {string} s
 * @return {boolean}
 */
var repeatedSubstringPattern = function(s) {
    for(let i = 1; i<= s.length / 2; i++){
        if(s.length % i > 0){
            continue;
        }
        let string = s.split("").splice(0,i).join("").repeat(s.length / i);
        if(string === s){
            return true;
        }
    }
    return false;
};