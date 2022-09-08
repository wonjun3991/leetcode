/**
 * @param {string[]} words
 * @return {string[]}
 */
var findWords = function(words) {
    const keyboard = [
        ['q','w','e','r','t','y','u','i','o','p'],
        ['a','s','d','f','g','h','j','k','l'],
        ['z','x','c','v','b','n','m']
    ];
    
    return words.filter(word=>{
        let firstString = word[0].toLowerCase();
        let row = 0;
        let result = true;
        if(keyboard[0].includes(firstString) ){
            row = 0;
        } else if(keyboard[1].includes(firstString) ){
            row = 1;
        } else if(keyboard[2].includes(firstString) ){
            row = 2;
        }
    
        word.split('').forEach(function(char){
            if(!keyboard[row].includes(char.toLowerCase()))
            {
                result = false;
            
            }
        })
        
        return result;
    })
};