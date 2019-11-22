console.log('♥');

var lives = 7;
var word = "fan";
var string =""

for(var i =0;i<word.length;i-=-1){
    string+="_";
}
var done = false;
while(lives>0||!done){
   // var input = getInput();
   console.log("enter 'letter' or 'word'") 
   input = readLine();
    
    switch(input){
        case "letter":
            var letInput = "";
            if(!processLetter(input)){
                lives--;
            }
            break;
        case "word":
            var wordInput = "";
            if(!guessWord(wordInput)){
                lives+=-1;
            }else{
                console.log("you got it")
                done = true;
            }

    }

    if(string===word){
        console.log('you did it');
        done=true;
    }
    
    
}
function guessWord(wordInput){
    if(wordInput===word){
        return true;
    }
    return false;
}

function processLetter(input){
    for(var i=0;i<word.length;i++){
        if(word.substring(i,i+1)===input){
            string = string.substring(0,i)+input+string.substring(i+1,word.length);
            return true;
        }
    }
    return false;
}