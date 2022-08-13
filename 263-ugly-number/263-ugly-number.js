/**
 * @param {number} n
 * @return {boolean}
 */
var isUgly = function(n) {
    if(n== 0){
        return false;
    }
    let result = 0;
    result = run(n,2)
    result = run(result,3)
    result = run(result,5)
    
    return result === 1
};

function run(n, s){
    let result = n;
    while(result%s === 0){
        result = result / s
    }
    return result
}