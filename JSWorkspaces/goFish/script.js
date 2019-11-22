class Player {
    constructor(hand, score) {
        this.hand = hand;
        this.score = score;
    }

    addCard(card) {
        this.hand.push(card);
    }
    removeCard(card) {
        for (var i = 0; i < this.hand.length; i++) {
            if (this.hand[i] === card) {
                this.hand.splice(i, 1);
            }
        }
    }

}
var canvas = document.getElementById('myCanvas');
var ctx = canvas.getContext('2d');
var cards = {};
var button = document.getElementById("killMe");
button.disabled = true;


var numPlayers = 4;
var players = [];

var scoreTarget = 10;
//cosole.log(new Player(getHand(),0));


function getHand() {
    var arr = [];
    for (var i = 0; i < 5; i++) {
        arr[i] = getCard();
    }
    return arr;
}
function getCard() {
    return Math.floor((Math.random() * 13) + 2);

}

function loadImages() {

    for (var i = 2; i < 15; i++) {
        var img = new Image();
        img.src = "cards/" + i + ".png";
        cards[i] = img;
    }
}
function draw() {
    ctx.clearRect(0, 0, canvas.width, canvas.height);
    displayPlayerCards();
    for (var i = 1; i < 4; i++) {
        displayComputer(i);
    }
}
function displayComputer(id) {

    var numCards = players[id].hand.length;
    for (var i = 0; i < numCards; i++) {
        var card = cards[players[id].hand[i]];
        var startX = (canvas.width / 3) * (id - 1);
        ctx.drawImage(card, startX + i * 10 + 30 * id, 50, card.width / 8, card.height / 8);

    }
}
function displayPlayerCards() {

    var numCards = players[0].hand.length;
    for (var i = 0; i < numCards; i++) {
        var card = cards[players[0].hand[i]];
        var startX = (canvas.width / 2) - ((numCards * card.width / 4)) / 2;
        ctx.drawImage(card, startX + i * card.width / 4 + i * 10, 500, card.width / 4, card.height / 4);

    }
}

function doIt() {
    button.disabled = false;
    initDeal();
    draw();

}

function doItt() {


    if (!isOver()) {
        // for (var i = 0; i < 4; i++) {

        //console.log("player: " + i + "   " + players[i].hand);
        // }
       // draw();
        for(var i=0;i<4;i++){
            if(checkPairs(i)){
                sleep(1000);
            };
        }
        playerTurn();
        draw();
        //sleep(1000);
        for (var i = 1; i < numPlayers; i++) {
            doTurn(i);
            
        }
    }
}


function doTurn(player) {
    
    var guess = getGuess(player);
    var person = getPerson(player);

    var b1 = hasCard(guess, person);
    if (b1) {
        transact(player, guess, person);
    } else {
        goFish(player);
    }

    if(checkPairs(player)){
        
    };

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
        deck = players[playerID].hand;
        var x = Math.floor((Math.random() * 4));
        return deck[x];
    } else {
        return getCard();
    }
}
function playerTurn() {
    
    
    var guess = parseInt(document.getElementById("guess").value);
    var person = document.getElementById("person").value;

    var b1 = hasCard(guess, person);
    if (b1) {
        transact(0, guess, person);
        draw();
        sleep(1000);
    } else {
        goFish(0);
        draw();
        sleep(1000);
    }

    if(checkPairs(0)){
         draw();
        sleep(1000); 
    }
    
}
function goFish(playerID) {
    players[playerID].addCard(getCard());
    draw();
    sleep(1000);
}
function transact(cur, guess, person) {
    players[cur].addCard(guess);
    players[person].removeCard(guess);
    draw();
    sleep(1000);
}
function hasCard(guess, person) {
    //console.log(players[person].hand.length);
    for (var i = 0; i < players[person].hand.length; i++) {
        // console.log(players[person].hand[i]);
        var n53 = players[person].hand[i];
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
    //it is removing all three if there are three
    var b1 = false;
    player = players[playerNum];
    for (var i = 0; i < player.hand.length - 1; i++) {
        for (var j = i + 1; j < player.hand.length; j++) {
            if (i !== j && player.hand[i] === player.hand[j]) {
                players[playerNum].score += 1;
                players[playerNum].hand.splice(j, 1);
                players[playerNum].hand.splice(i, 1);
                i--;
                j--;
                b1 = true;
                console.log("person: " + playerNum + "had a pair");
            }
        }
    }
    return b1;

}

function sleep(milliseconds) {
    var start = new Date().getTime();
    for (var i = 0; i < 1e7; i++) {
      if ((new Date().getTime() - start) > milliseconds){
        break;
      }
    }
  }
