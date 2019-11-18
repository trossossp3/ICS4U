var c = document.getElementById("myCanvas");
var ctx = c.getContext("2d");


var numPlayers = 4;
var players = [numPlayers];
var scoreTarget = 10;

function getHand(){
    var arr;
    for(var i =0;i<5;i++){
        arr[i] = getCard();
    }
    return arr;
}
function getCard(){
    return Math.floor((Math.random() * 10) + 1);
}

function doIt(){
    initDeal();
    while(!isOver()){
        playerTurn();
        for(var i =0;i<numPlayers;i++){
            doTurn(players[i+1]);

        }
    }
}
function playerTurn(){
    var guess = document.getElementById("guess").value;
    var person = document.getElementById("person").value;
    var b1 = hasCard(guess, person); //0 no one has it
    if(b1){
        transact(guess,person);
    }


}
function transact(guess,person)
function hasCard(guess,person){
    for(var i =0;i<players[person].cards.length();i++){
        if(players[person].cards[i] === guess){
            return true;
        }
    }
    return false;
}
function doTurn(player){

}

function initDeal(){
    for (var i =0;i<numPlayers;i++){
        players[i] = new Player(getHand(),0);
    }
}
function isOver(){
    var b1 = false;
    for (var i =0;i<numPlayers;i++){
       if(players[i].score>=10){
           b1 = ture;
       }
    }
    return b1;
}

class Player {
    constructor(arr, points){
        this.arr = cards;
        this.points = score;
    }
    addCard(card){
        this.arr.push(card);
    }
    removeCard(card){
        for(var i = 0;i<this.arr.length;i++){
            if(this.arr[i]===card){
                this.arr.splice(i);
            }
        }
    }    

}
