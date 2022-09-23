/**
 * @param {number} left
 * @param {number} right
 * @return {number}
 */
var countPrimeSetBits = function(left, right) {
    const primes = [2,3,5,7,11,13,17,19];
    let result = 0;
    for(let i = left; i<=right; i++){
        
        result = result + primes.includes((i >>> 0).toString(2).split('').filter((bit)=>bit==1).length);
    }
    return result;
};