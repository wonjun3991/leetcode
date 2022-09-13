/**
 * @param {number} area
 * @return {number[]}
 */
var constructRectangle = function(area) {
    for(let i = Math.ceil(Math.pow(area,0.5)); i > 0; i--){
        if(Number.isInteger(area / i)){
            if(i > area/i){
                return [i, area/i];
            }
            return [area/i, i];
        }
    }
};