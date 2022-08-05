/**
 * @param {number} num
 * @return {number}
 */
var findComplement = function(num) {
    const binaryString = (num >>> 0).toString(2).split('').map(num=>num == "0"?"1":"0").join('')
    return parseInt(binaryString,2)
};