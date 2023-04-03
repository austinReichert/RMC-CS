class ball {
    constructor(x, y){
        this.x = x;
        this.y = y;
    }
    name = "ball";
    size = 12;
    color = "red";
    x = 0;
    y = 0;
    moveSpeed = 5;
    bounceCounter = 0;
    myIndex = 0;
    draw(){
        drawCircle(this.x, this.y, this.size, this.color);
    };
    update(){
        if (this.y < gameWindow.height + this.size){
            this.y += this.moveSpeed;
        }
        else {
            objectArray.splice(this.myIndex, 1);
        }
    };
}

class line {
    constructor(x, y){
        this.x = x;
        this.y = y;
    }
    name = "line";
    color = "black";
    x = null;
    y = null;
    x1 = null;
    y1 = null;
    draw(){
        drawLine(this.x, this.y, this.x1, this.y1, this.color);
    };
    update(){};
}

// game functions

function gameLoop(){
    draw();
    update();
    frame = window.requestAnimationFrame(gameLoop);
}

function update(){
    objectArray.forEach(element => element.update());
}

// draw functions

function draw(){
    clearGameWindow();
    objectArray.forEach(element => element.draw());
}

function drawLine(x, y, x1, y1, color){
    ctx.beginPath();
    ctx.moveTo(x, y);
    ctx.lineTo(x1, y1);
    ctx.fillStyle = color;
    ctx.stroke();
}

function drawCircle(x, y, radius, color) {
	ctx.beginPath();
	ctx.arc(x, y, radius, 0, 2 * Math.PI, false);
	ctx.fillStyle = color;
	ctx.fill();
}

function clearGameWindow() {
	ctx.clearRect(0, 0, gameWindow.width, gameWindow.height);
}

// item functions

function getMousePosition(e){
    var x = e.offsetX;
    var y = e.offsetY;
    spawnItem(x, y);
}

function spawnItem(x, y){
    if (currentItem != null && currentItem != null){
        if (currentItem instanceof ball){
            spawnBall(x, y);
        }
        else if (currentItem instanceof line){
            spawnLine(x, y);
        }
    }
}

function spawnBall(x, y){
    currentItem.x = x;
    currentItem.y = y;
    currentItem.myIndex = objectArray.push(currentItem) - 1;
    currentItem = null;
}

function spawnLine(x, y){
    if (currentItem.x == null || currentItem.y == null){
        currentItem.x = x;
        currentItem.y = y;   
    }
    else {
        currentItem.x1 = x;
        currentItem.y1 = y;
        currentItem.myIndex = objectArray.push(currentItem) - 1;
        currentItem = null;
    }
}

function setCurrentItem(id){
    if(id == "ball"){
        currentItem = new ball();
    }
    else if(id == "line"){
        currentItem = new line();
    }
    else if(id == "clear"){
        objectArray = [];
    }
    else {
        currentItem = null;
    }
}

const gameWindow = document.getElementById("gameWindow");
const ctx = gameWindow.getContext('2d');
ctx.lineWidth = 5;
gameWindow.addEventListener('mousedown', getMousePosition);
var objectArray = [];
var currentItem = null;
const isSpawning = false;
var frame = window.requestAnimationFrame(gameLoop);