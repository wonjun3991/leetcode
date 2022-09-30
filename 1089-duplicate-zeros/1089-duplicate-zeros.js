/**
 * @param {number[]} arr
 * @return {void} Do not return anything, modify arr in-place instead.
 */
var duplicateZeros = function(arr) {
    let result = arr.reduce(function(previousContext , currentValue){
        if(previousContext.length === arr.length){
            return previousContext;
        }
        
        if(currentValue === 0){
            previousContext.push(currentValue);
            if(previousContext.length === arr.length){
                return previousContext;
            }
            previousContext.push(currentValue);
        } else{
            previousContext.push(currentValue);
        }
        return previousContext;
    }, [])

    arr.splice(0, arr.length, ...result);     
};