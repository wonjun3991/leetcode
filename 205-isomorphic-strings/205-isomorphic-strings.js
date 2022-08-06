/**
 * @param {string} s
 * @param {string} t
 * @return {boolean}
 */
var isIsomorphic = function(s, t) {
    if(s.length != t.length){
        return false;
    }
    
    const patternCatch = function(pattern){    
        let mapList = pattern.split('').reduce(function(prev, curr){
            if(!prev.includes(curr)){
                prev.push(curr)
            }
            return prev
        }, [])
        console.log(mapList)
        console.log(pattern)
        return pattern.split('').map((char)=>mapList.indexOf(char)+100).join('')
    }
    
    const sPattern = patternCatch(s)
    console.log(sPattern)
    const tPattern = patternCatch(t)
    console.log(tPattern)
    return sPattern == tPattern
};