/**
 * @param {string} s
 * @param {number} k
 * @return {string}
 */
var reverseStr = function(s, k) {
    const result = [];
    const chars = s.split('')
    while(chars.length > 0){
        result.push(...chars.splice(0, k).reverse());
        result.push(...chars.splice(0, k));    
    }
    
    return result.join('');
};