var gameWindow = document.getElementById("gameWindow");
// w = 800, h = 400
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
    color: "blue",
    movementOptions: {
        w: false,
        a: false,
        s: false,
        d: false
    },
    moveSpeed: 3,
    score: 0
};
var enemies = [];
// add enemy types

function gameLoop(){
    draw();
    updateGame();
    window.requestAnimationFrame(gameLoop);
}

function draw(){
    clearGameWindow();
    drawPlayer();
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
};

function drawPlayer(){
    drawCircle(player.x, player.y, player.size, player.color);
}

function drawScore(){
    let scoreMsg = "Score: " + Math.floor(player.score);
    drawText(0, 400, scoreMsg, "purple");
}

function gameOver(){

}

function clearGameWindow(){
    ctx.clearRect(0, 0, gameWindow.width, gameWindow.height);
}

function drawSquare(x, y, w, h, color){
    ctx.fillStyle = color;
    ctx.fillRect(x, y, w, h);
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

window.addEventListener('keydown', keyDown);
window.addEventListener('keyup', keyUp);
var frameid = window.requestAnimationFrame(gameLoop);