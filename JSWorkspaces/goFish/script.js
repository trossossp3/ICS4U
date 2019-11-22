var c = document.getElementById("myCanvas");
var ctx = c.getContext("2d");
var button = document.getElementById("killMe");
button.onclick = doItt();
button.disabled = true;
class Player {
    constructor(cards, score) {
        this.cards = cards;
        this.score = score;
    }

    addCard(card) {
        this.cards.push(card);
    }
    removeCard(card) {
        for (var i = 0; i < this.cards.length; i++) {
            if (this.cards[i] === card) {
                this.cards.splice(i, 1);
            }
        }
    }

}


var numPlayers = 4;
var players = [];

var scoreTarget = 10;
//cosole.log(new Player(getHand(),0));
doIt();

function getHand() {
    var arr = [];
    for (var i = 0; i < 5; i++) {
        arr[i] = getCard();
    }
    return arr;
}
function getCard() {
    var x = Math.floor((Math.random() * 14) + 2);
    if (x < 11) {
        return x;
    } else if (x === 11) {
        return "J";
    } else if (x === 12) {
        return "Q";
    } else if (x === 13) {
        return "K";
    } else {
        return "A";
    }

}
function doIt() {
    initDeal();
    players[0].cards = [4, 4, 5, 6, 7];
    while (!isOver()) { 

        


    }
}


function doItt() {
    for (var i = 0; i < 4; i++) {
        console.log("player: " + i + "   " + players[i].score);
        console.log("player: " + i + "   " + players[i].cards);
    }
    playerTurn();
    for (var i = 1; i < numPlayers; i++) {
        doTurn(i);

        //}
    }
}


function doTurn(player) {
    checkPairs(player);
    var guess = getGuess(player);
    var person = getPerson(player);

    var b1 = hasCard(guess, person); //0 no one has it
    if (b1) {
        transact(guess, person);
    } else {
        goFish();
    }
    checkPairs(player);

}
function getPerson(playerID) {
    while (true) {
        var x = Math.floor(Math.random() * 4);
        if (x !== playerID) {
            return x;
        }
    }
}
function getGuess(playerID) {
    var y = Math.floor((Math.random() * 2));
    if (y === 1) {
        cards = players[playerID].cards;
        var x = Math.floor((Math.random() * 4));
        return cards[x];
    } else {
        return getCard();
    }
}
function playerTurn() {
    checkPairs(0);
    var guess = document.getElementById("guess").value;
    var person = document.getElementById("person").value;

    var b1 = hasCard(guess, person); //0 no one has it
    if (b1) {
        transact(guess, person);
    } else {
        goFish();
    }
    checkPairs(0);
}
function goFish() {
    players[0].addCard(getCard());
}
function transact(guess, person) {
    players[0].addCard(guess);
    players[person].removeCard(guess);
}
function hasCard(guess, person) {
    //console.log(players[person].cards.length);
    for (var i = 0; i < players[person].cards.length; i++) {
        if (players[person].cards[i] === guess) {
            return true;
        }
    }
    return false;
}


function initDeal() {

    for (var i = 0; i < numPlayers; i++) {
        players[i] = new Player(getHand(), 0);
    }
    return 12;
}
function isOver() {
    var b1 = false;
    for (var i = 0; i < numPlayers; i++) {
        if (players[i].score >= 10) {
            b1 = true;
        }
    }
    return b1;
}
function checkPairs(playerNum) {

    player = players[playerNum];
    for (var i = 0; i < player.cards.length; i++) {
        for (var j = 0; j < player.cards.length; j++) {
            if (i !== j && player.cards[i] === player.cards[j]) {
                players[playerNum].score += 1;

                players[playerNum].removeCard(player.cards[i]);

                players[playerNum].removeCard(player.cards[j - 1]);
            }
        }
    }


}
