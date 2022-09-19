/**
 * @param {string} currentState
 * @return {string[]}
 */
var generatePossibleNextMoves = function(currentState) {
    const resultList = [];
    for(let i = 0; i < currentState.length -1 ; i++){
        if(currentState[i] === '+' && currentState[i + 1] ==='+'){
            const result = currentState.slice().split('');
            
            result[i] = '-';
            result[i+1] = '-';
            resultList.push(result.join(''));
        }
    }
    return resultList;
};