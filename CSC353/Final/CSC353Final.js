// game functions
function gameLoop(){
    draw();
    updateGame();
    window.requestAnimationFrame(gameLoop);
}

function draw(){
    clearGameWindow();
    drawPlayer();
    drawEnemies();
    drawScore();
}

function updateGame(){
    if (player.movementOptions.w == true && player.y > player.size){
        player.y -= player.moveSpeed;
    }
    if (player.movementOptions.s == true && player.y < gameWindow.height - player.size){
        player.y += player.moveSpeed;
    }
    if (player.movementOptions.a == true && player.x > player.size){
        player.x -= player.moveSpeed;
    }
    if (player.movementOptions.d == true && player.x < gameWindow.width - player.size){
        player.x += player.moveSpeed;
    }
    player.score += 0.015;
    updateEnemies();
};

function updateEnemies(){
    enemyArray.forEach(enemy => {
        enemy.logic();
        enemy.movement();
    });
}

function gameOver(){

}

// draw functions
function drawPlayer(){
    drawCircle(player.x, player.y, player.size, "#3444f7"); //blue
    drawCircle(player.x, player.y, player.size - 5, "#46485e"); //grey
}

function drawScore(){
    let scoreMsg = "Score: " + Math.floor(player.score);
    drawText(0, 400, scoreMsg, "purple");
}

function clearGameWindow(){
    ctx.clearRect(0, 0, gameWindow.width, gameWindow.height);
}

function drawSquare(x, y, w, h, color){
    ctx.fillStyle = color;
    ctx.fillRect(x, y, w, h);
}

function drawEnemies(){
    enemyArray.forEach(enemy => {
        enemy.draw();
    });
}

function drawCircle(x, y, radius, color){
    ctx.beginPath();
    ctx.arc(x, y, radius, 0, 2 * Math.PI, false);   
    ctx.fillStyle = color;
    ctx.fill();
}

function drawText(x, y, text, color){
    ctx.fillStyle = color;
    ctx.fillText(text, x, y);
}

// key functions
function keyDown(key){
    if(key.keyCode == keyCodes.w){
        player.movementOptions.w = true;
    }
    if(key.keyCode == keyCodes.s){
        player.movementOptions.s = true;
    }
    if(key.keyCode == keyCodes.a){
        player.movementOptions.a = true;
    }
    if(key.keyCode == keyCodes.d){
        player.movementOptions.d = true;
    }
}

function keyUp(key){
    if(key.keyCode == keyCodes.w){
        player.movementOptions.w = false;
    }
    if(key.keyCode == keyCodes.s){
        player.movementOptions.s = false;
    }
    if(key.keyCode == keyCodes.a){
        player.movementOptions.a = false;
    }
    if(key.keyCode == keyCodes.d){
        player.movementOptions.d = false;
    }
}

// enemy functions and properties
class Runner {
    isVulnerable = false;
    moveSpeed = getRandomNumber(1, 5);
    color = "#e1e96b";
    hostileColor = "#f51e05";
    vulnerableColor = "#e1e96b";
    nextMove = new Date().getTime() + this.actionDelay;
    nextChange = 0;
    possibleMoves = {
        left: 1,
        right: 2,
        down: 3,
        up: 4,
        nothing: 5
    }
    moveQueue = [];
    
    constructor(x, y){
        this.x = x;
        this.y = y;
        this.w = getRandomNumber(2, 200);
        this.h = getRandomNumber(2, 200);
        this.actionDelay = getRandomNumber(750, 10000); // THIS IS IN MS (0.75s - 10s)
    }

    generateMovement(){
        let ranNum = 0;
        if (this.moveQueue.length < 3){
            switch(getRandomNumber(0,1)){
                case 0:
                    ranNum = getRandomNumber(0,3);
                    if (ranNum == 0){
                       this.moveQueue.push(this.possibleMoves.left);
                    }
                    else {
                        this.moveQueue.push(this.possibleMoves.right);
                    }
                case 1:
                    ranNum = getRandomNumber(0,1);
                    if (ranNum == 0){
                        this.moveQueue.push(this.possibleMoves.up);
                    }
                    else {
                        this.moveQueue.push(this.possibleMoves.down);
                    }
                default:
                    this.moveQueue.push(this.possibleMoves.nothing);
            }
        }
    }
    movement(){
        this.generateMovement();
        if (new Date().getTime() < this.nextMove){
            if(this.moveQueue[0] == this.possibleMoves.left){
                if (this.x > this.w){
                    this.x -= this.moveSpeed;
                }
                else {
                    this.x = gameWindow.width;
                }
            }
            if(this.moveQueue[0] == this.possibleMoves.right){
                if (this.x < gameWindow.width - this.w){
                    this.x += this.moveSpeed;
                }
                else {
                    this.x = 0;
                }
            }
            if(this.moveQueue[0] == this.possibleMoves.down){
                if (this.y > this.h){
                    this.y -= this.moveSpeed;
                }
                else {
                    this.y = gameWindow.height;
                }
            }
            if(this.moveQueue[0] == this.possibleMoves.up){
                if (this.y < gameWindow.height - this.h){
                    this.y += this.moveSpeed;
                }
                else {
                    this.y = 0;
                }
            }
        }
        else {
            this.moveQueue.shift();
            this.nextMove = new Date().getTime() + this.actionDelay;
        }
    }
    logic(){
        if (new Date().getTime() > this.nextChange){
            this.nextChange = new Date().getTime() + getRandomNumber(500, this.actionDelay + 2000);
            this.swapColor();
        }
    }
    draw(){
        drawSquare(this.x, this.y, this.w, this.h, this.color);
    }
    swapColor(){
        if (this.color == this.hostileColor){
            this.color = this.vulnerableColor;
        }
        else {
            this.color = this.hostileColor;
        }
    }
}

function createEnemy(){
    let x = 0;
    let y = 0;
    switch(getRandomNumber(0, 3)){
        case 0:
            x = getRandomNumber(0, gameWindow.width);
            y = 0;
            break;
        case 1:
            x = 0;
            y = getRandomNumber(0, gameWindow.height);
            break;
        case 2:
            x = getRandomNumber(0, gameWindow.width);
            y = gameWindow.height - 75;
            break;
        default:
            x = gameWindow.width - 75;
            y = getRandomNumber(0, gameWindow.height);
    }
    enemyArray.push(new Runner(x, y));
}

function getRandomNumber(from, to){
    let result = Math.floor(Math.random() * (to - from + 1)) + from;
    return result;
}

// variables and init statement
var gameWindow = document.getElementById("gameWindow"); // w = 800, h = 400
var ctx = gameWindow.getContext("2d");
ctx.font = "28px serif";
var keyCodes = {
    w: 87,
    a: 65,
    s: 83,
    d: 68
}

var player = {
    x: gameWindow.width/2,
    y: gameWindow.height/2,
    size: 9,
    movementOptions: {
        w: false,
        a: false,
        s: false,
        d: false
    },
    moveSpeed: 3,
    score: 0
};
var enemyArray = [];
window.addEventListener('keydown', keyDown);
window.addEventListener('keyup', keyUp);
createEnemy();
createEnemy();
createEnemy();
createEnemy();
createEnemy();
createEnemy();
createEnemy();
var frameid = window.requestAnimationFrame(gameLoop);