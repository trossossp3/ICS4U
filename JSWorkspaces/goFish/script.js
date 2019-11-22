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
/*var c = document.getElementById("myCanvas");
var ctx = c.getContext("2d");

var img = new Image();*/





var canvas = document.getElementById('myCanvas');
var ctx = canvas.getContext('2d');

//imgInit();


//ctx.drawImage(img,10,10);
//button.onclick = doItt();
var button = document.getElementById("killMe");
button.disabled = true;



var numPlayers = 4;
var players = [];

var scoreTarget = 10;
//cosole.log(new Player(getHand(),0));

function doIt() {
    button.disabled = false;

}
function getHand() {
    var arr = [];
    for (var i = 0; i < 5; i++) {
        arr[i] = getCard();
    }
    return arr;
}
function getCard() {
    return Math.floor((Math.random() * 13) + 2);

    /**
     * 11 =J
     * 12 = Q
     * 13 = K
     * 14 = A
     * 
     */


}

function displayCards() {
    var numCards = players[0].cards.length;
    for (var i = 0; i < numCards; i++) {       
        var img = new Image();
        img.onload = function () {
            ctx.drawImage(img, i/2*img.width, 50, img.width * 0.3, img.height * 0.3);
        };
        img.src = getCardImg(players[0].cards[i]);
    }
}



function doItt() {
    //console.log("wqhbnfujb");
    initDeal();
    if (isOver) {
        for (var i = 0; i < 4; i++) {
            displayCards();
            console.log("player: " + i + "   " + players[i].cards);
        }
        playerTurn();
        for (var i = 1; i < numPlayers; i++) {
            doTurn(i);
        }
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
        goFish(player);
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
    var guess = parseInt(document.getElementById("guess").value);
    var person = document.getElementById("person").value;

    var b1 = hasCard(guess, person); //0 no one has it
    if (b1) {
        transact(guess, person);
    } else {
        goFish(0);
    }
    checkPairs(0);
}
function goFish(playerID) {
    players[playerID].addCard(getCard());
}
function transact(guess, person) {
    players[0].addCard(guess);
    players[person].removeCard(guess);
}
function hasCard(guess, person) {
    //console.log(players[person].cards.length);
    for (var i = 0; i < players[person].cards.length; i++) {
        // console.log(players[person].cards[i]);
        var n53 = players[person].cards[i];
        if (n53 === parseInt(guess)) {
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
                console.log("person: " + playerNum + "had a pair");
            }
        }
    }

}
function getCardImg(card) {
    switch (card) {
        case 2:
            return 'cards/2.PNG';
        case 3:
            return 'cards/3.png'
        case 4:
            return 'cards/4.png'
        case 5:
            return 'cards/5.png' 
        case 6:
            return 'cards/6.png' 
         case 7:
            return 'cards/7.png' 
        case 8:
            return 'cards/8.png' 
        case 9:
            return 'cards/9.png' 
        case 10:
            return 'cards/10.png' 
        case 11:
            return 'cards/11.png' 
        case 12:
            return 'cards/12.png' 
        case 13:
            return 'cards/13.png' 
        case 14:
            return 'cards/14.png' 

    }
}
