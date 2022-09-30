/**
 * @param {string} s
 * @param {string} t
 * @return {boolean}
 */
var backspaceCompare = function(s, t) {
    const backspaceCompare = (string) => string.split('')
        .reduce(function(previousContext, currentValue){
            currentValue === '#'? previousContext.pop() : previousContext.push(currentValue);
            return previousContext;
        }, []).join('')
    
    return backspaceCompare(s) === backspaceCompare(t);
};