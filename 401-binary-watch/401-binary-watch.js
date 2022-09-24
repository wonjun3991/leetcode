/**
 * @param {number} turnedOn
 * @return {string[]}
 */
var readBinaryWatch = function(turnedOn) {
    const result = [];
    
    const integerToBinary = (integer) => (integer >>> 0).toString(2);
    const getBinaryBitCount = (binary) => binary.split('').filter((bit)=> bit==1).length;
    const getBitCount = (integer) => getBinaryBitCount(integerToBinary(integer));
    const integerToMinute = function(integer){
        if(integer < 10){
            return `0${integer}`;
        }
        return `${integer}`;
    }
    
    for(let hour = 0; hour < 12; hour++){
        for(let minute = 0; minute < 60; minute ++){
            if(getBitCount(hour) + getBitCount(minute) == turnedOn){
                result.push(`${hour}:${integerToMinute(minute)}`);
            }
        }
    }
    return result;
};