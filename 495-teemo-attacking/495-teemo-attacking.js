/**
 * @param {number[]} timeSeries
 * @param {number} duration
 * @return {number}
 */
var findPoisonedDuration = function(timeSeries, duration) {
    const timeLength = timeSeries.length;
    if(timeLength === 0 ){
        return 0;
    }
    let total = 0;
    for(let i =0; i<timeLength - 1; i++){
        total = total + Math.min(timeSeries[ i+1] - timeSeries[i], duration);
    }
    return total + duration;
};