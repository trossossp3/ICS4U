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
var button1 = document.getElementById("k");


var numPlayers = 4;
var players = [];

var scoreTarget = 10;
//cosole.log(new Player(getHand(),0));

function drawTextBox(message){
    ctx.fillStyle = 'WHITE';
    ctx.fillRect(canvas.width/2,canvas.height/2, 150, 75); 
    ctx.fillStyle = 'blue';
    ctx.textAlign = 'center';
    ctx.fillText(message,canvas.width/2,canvas.length/2);

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
    drawTextBox("test");
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
        ctx.drawImage(card, startX + i * card.width / 4 + i * 10, 600, card.width / 4, card.height / 4);

    }
}

function doIt() {
    button.disabled = false;
    button1.disabled = true;
    initDeal();
    draw();

}

function doItt() {
    if (!isOver()) {
        for (var i = 0; i < 4; i++) {
            checkPairs(i)
        }
        playerTurn();
        draw();
        setTimeout(f1,1000, 1);

    }
}

function f1(i) {
        if(i<numPlayers) {
            doTurn(i);
            draw();
            setTimeout(f1,1000,i+1);
        }
}

function doTurn(player) {
    if (players[player].hand.length === 0) {
        players[player].hand = getHand();
    }
    var guess = getGuess(player);
    var person = getPerson(player);

    var b1 = hasCard(guess, person);
    if (b1) {
        transact(player, guess, person);
    } else {
        goFish(player);
    }

    checkPairs(player)

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
    if (players[0].hand.length === 0) {
        players[0].hand = getHand();
    }

    var guess = parseInt(document.getElementById("guess").value);
    var person = document.getElementById("person").value;

    var b1 = hasCard(guess, person);
    if (b1) {
        transact(0, guess, person);
        

    } else {
        goFish(0);
        

    }

    checkPairs(0);

}
function goFish(playerID) {
    players[playerID].addCard(getCard());
    ctx.font = "px Comic Sans MS";
    ctx.fillStyle = "red";
    ctx.textAlign = "center";
    ctx.fillText("Player: " + i + " wins", canvas.width / 2, canvas.height / 2);

}
function transact(cur, guess, person) {
    players[cur].addCard(guess);
    players[person].removeCard(guess);
    

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
    var winner;
    for (var i = 0; i < numPlayers; i++) {
        if (players[i].score >= 10) {
            b1 = true;
            winner = i;
            displayWin(i);
        }
    }
    return b1;
}
function displayWin(i) {
    ctx.clearRect(0, 0, canvas.width, canvas.height)
    ctx.font = "100px Comic Sans MS";
    ctx.fillStyle = "red";
    ctx.textAlign = "center";
    ctx.fillText("Player: " + i + " wins", canvas.width / 2, canvas.height / 2);

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
        if ((new Date().getTime() - start) > milliseconds) {
            break;
        }
    }
}
