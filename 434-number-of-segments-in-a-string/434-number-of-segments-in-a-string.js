/**
 * @param {string} s
 * @return {number}
 */
var countSegments = function(s) {
    const split = s.split("");
    let count = 0;
    for(let i =0; i < split.length; i++){
        if(split[i] !== " "){
            count++;
            while(i < split.length && split[i] !== " "){
                i++;
            }
        }
    }
    return count;
};