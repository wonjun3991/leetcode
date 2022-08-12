/**
 * @param {string} s
 * @return {string}
 */
var reverseVowels = function(s) {
    const vowels = ['a','e','i','o','u','A','E','I','O','U'];
    const vowelsInString = s.split('').filter((s)=>vowels.includes(s));
    return s.split('').map((s)=>vowels.includes(s)?vowelsInString.pop():s).join('')
};