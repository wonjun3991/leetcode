/**
 * @param {number} x
 * @param {number} y
 * @return {number}
 */
var hammingDistance = function(x, y) {  
    const xbin = dec2bin(x);
    const ybin = dec2bin(y);
    
    const [long, short] = getBin(xbin, ybin)
        
    let count = 0;
    console.log(long.split(""))
    console.log(short.split(""))
    for (let i =0 ; i<long.length ; i++){
        if(long[i] !== short[i]){
            count = count + 1;
        }
    }
    return count;
};

function dec2bin(dec) {
  return (dec >>> 0).toString(2);
}

function getBin(xbin, ybin){
    if(xbin.length >= ybin.length){
        let short = ybin.split("");
        for(let i = 0; i < xbin.length-ybin.length; i++){
            short.unshift(0);
        }
        return [xbin, short.join("")];
    }
    let short = xbin.split("");
        for(let i = 0; i < ybin.length-xbin.length; i++){
            short.unshift(0);
        }
    return [ybin, short.join("")];
}