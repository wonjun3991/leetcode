/**
 * @param {string[]} words
 * @param {string} pattern
 * @return {string[]}
 */
var findAndReplacePattern = function(words, pattern) {
    const alpha = Array.from(Array(26)).map((e, i) => i + 97);
    const alphabet = alpha.map((x) => String.fromCharCode(x));
    
    const patternCatch = function(pattern){
        const mapList = pattern.split('').reduce(function(prev, curr){
            if(!prev.includes(curr)){
                prev.push(curr)
            }
            return prev
        }, [])
        return pattern.split('').map((char)=>alphabet[mapList.indexOf(char)]).join('')
    }
    
    const result = patternCatch(pattern)
        
    return words.filter((word)=>patternCatch(word) == result)
};