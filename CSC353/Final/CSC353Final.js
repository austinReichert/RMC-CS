// game functions
function gameLoop() {
	draw();
	updateGame();
	if (isPlaying) {
		var frame = window.requestAnimationFrame(gameLoop);
	} else {
		clearGameWindow();
		let lastScore = Math.floor(player.score);
		let gameOverMsgScore = "Score: " + lastScore;
		let gameOverMsgEnemies = "Enemies Defeated: " + player.enemiesDefeated;
		drawText(gameWindow.width / 2 - 70, 175, "Game Over!", "red");
		drawText(gameWindow.width / 2 - 65, 200, gameOverMsgScore, "purple");
		drawText(gameWindow.width / 2 - 120, 225, gameOverMsgEnemies, "green");
		window.cancelAnimationFrame(gameLoop);
		setTimeout(() => {
			resetGameVars();
			isPlaying = true;
			frame = window.requestAnimationFrame(gameLoop);
		}, 3500);
	}
}

function draw() {
	clearGameWindow();
	drawPlayer();
	drawEnemies();
	drawScore();
}

function updateGame() {
	if (player.movementOptions.w == true && player.y > player.size) {
		player.y -= player.moveSpeed;
	}
	if (
		player.movementOptions.s == true &&
		player.y < gameWindow.height - player.size
	) {
		player.y += player.moveSpeed;
	}
	if (player.movementOptions.a == true && player.x > player.size) {
		player.x -= player.moveSpeed;
	}
	if (
		player.movementOptions.d == true &&
		player.x < gameWindow.width - player.size
	) {
		player.x += player.moveSpeed;
	}
	player.score += 0.015 * enemyArray.length;
	updateEnemies();
}

function updateEnemies() {
	spawnEnemy();
	enemyArray.forEach((enemy) => {
		enemy.logic();
		enemy.movement();
	});
}

function spawnEnemy() {
	if (new Date().getTime() > nextSpawn) {
		createEnemy(Runner);
		nextSpawn = new Date().getTime() + 2000;
	}
}

function resetGameVars() {
	enemyArray = [];
	player.score = 0;
	player.enemiesDefeated = 0;
	player.x = gameWindow.width / 2;
	player.y = gameWindow.height / 2;
	isPlaying = true;
}

// draw functions
function drawPlayer() {
	drawCircle(player.x, player.y, player.size, "#3444f7"); //blue
	drawCircle(player.x, player.y, player.size - 2, "#3993d2"); //light blue
}

function drawScore() {
	let scoreMsg = "Score: " + Math.floor(player.score);
	drawText(0, 400, scoreMsg, "purple");
}

function clearGameWindow() {
	ctx.clearRect(0, 0, gameWindow.width, gameWindow.height);
}

function drawSquare(x, y, w, h, color) {
	ctx.fillStyle = color;
	ctx.fillRect(x, y, w, h);
}

function drawEnemies() {
	enemyArray.forEach((enemy) => {
		enemy.draw();
	});
}

function drawCircle(x, y, radius, color) {
	ctx.beginPath();
	ctx.arc(x, y, radius, 0, 2 * Math.PI, false);
	ctx.fillStyle = color;
	ctx.fill();
}

function drawText(x, y, text, color) {
	ctx.fillStyle = color;
	ctx.fillText(text, x, y);
}

// key functions
function keyDown(key) {
	if (key.keyCode == keyCodes.w || key.keyCode == keyCodes.up) {
		player.movementOptions.w = true;
	}
	if (key.keyCode == keyCodes.s || key.keyCode == keyCodes.down) {
		player.movementOptions.s = true;
	}
	if (key.keyCode == keyCodes.a || key.keyCode == keyCodes.left) {
		player.movementOptions.a = true;
	}
	if (key.keyCode == keyCodes.d || key.keyCode == keyCodes.right) {
		player.movementOptions.d = true;
	}
}

function keyUp(key) {
	if (key.keyCode == keyCodes.w || key.keyCode == keyCodes.up) {
		player.movementOptions.w = false;
	}
	if (key.keyCode == keyCodes.s || key.keyCode == keyCodes.down) {
		player.movementOptions.s = false;
	}
	if (key.keyCode == keyCodes.a || key.keyCode == keyCodes.left) {
		player.movementOptions.a = false;
	}
	if (key.keyCode == keyCodes.d || key.keyCode == keyCodes.right) {
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
		nothing: 5,
	};
	moveQueue = [];

	constructor(x, y) {
		this.x = x;
		this.y = y;
		this.w = getRandomNumber(15, 165);
		this.h = getRandomNumber(15, 165);
		this.actionDelay = getRandomNumber(550, 10000);
	}

	generateMovement() {
		let ranNum = 0;
		if (this.moveQueue.length < 3) {
			switch (getRandomNumber(0, 1)) {
				case 0:
					ranNum = getRandomNumber(0, 3);
					if (ranNum == 0) {
						this.moveQueue.push(this.possibleMoves.left);
					} else {
						this.moveQueue.push(this.possibleMoves.right);
					}
				case 1:
					ranNum = getRandomNumber(0, 1);
					if (ranNum == 0) {
						this.moveQueue.push(this.possibleMoves.up);
					} else {
						this.moveQueue.push(this.possibleMoves.down);
					}
				default:
					this.moveQueue.push(this.possibleMoves.nothing);
			}
		}
	}
	movement() {
		this.generateMovement();
		if (new Date().getTime() < this.nextMove) {
			if (this.moveQueue[0] == this.possibleMoves.left) {
				if (this.x > 0) {
					this.x -= this.moveSpeed;
				} else {
					this.x = gameWindow.width;
				}
			}
			if (this.moveQueue[0] == this.possibleMoves.right) {
				if (this.x < gameWindow.width) {
					this.x += this.moveSpeed;
				} else {
					this.x = 0;
				}
			}
			if (this.moveQueue[0] == this.possibleMoves.down) {
				if (this.y > 0) {
					this.y -= this.moveSpeed;
				} else {
					this.y = gameWindow.height;
				}
			}
			if (this.moveQueue[0] == this.possibleMoves.up) {
				if (this.y < gameWindow.height) {
					this.y += this.moveSpeed;
				} else {
					this.y = 0;
				}
			}
		} else {
			this.moveQueue.shift();
			this.nextMove = new Date().getTime() + this.actionDelay;
		}
	}
	logic() {
		if (new Date().getTime() > this.nextChange) {
			this.nextChange =
				new Date().getTime() + getRandomNumber(500, this.actionDelay + 2000);
			this.swap();
		}
		if (this.isTouchingPlayer() && this.isVulnerable) {
			player.score += 65;
			this.die();
		} else if (this.isTouchingPlayer()) {
			isPlaying = false;
		}
	}
	isTouchingPlayer() {
		if (
			player.x + player.size < this.x + this.w &&
			player.x + player.size > this.x &&
			player.y + player.size < this.h + this.y &&
			player.y + player.size > this.y
		) {
			return true;
		}
		return false;
	}
	draw() {
		drawSquare(this.x, this.y, this.w, this.h, this.color);
	}
	die() {
		let enemyIndex = enemyArray.findIndex((enemy) => {
			return (
				enemy.x === this.x &&
				enemy.y === this.y &&
				enemy.w === this.w &&
				enemy.h === this.h &&
				enemy.isVulnerable
			);
		});
		enemyArray.splice(enemyIndex, 1);
		player.enemiesDefeated++;
	}
	swap() {
		if (this.color == this.hostileColor) {
			this.color = this.vulnerableColor;
			this.isVulnerable = true;
		} else {
			this.color = this.hostileColor;
			this.isVulnerable = false;
		}
	}
}

function createEnemy(funct) {
	let x = 0;
	let y = 0;
	switch (getRandomNumber(0, 3)) {
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
	enemyArray.push(new funct(x, y));
}

function getRandomNumber(from, to) {
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
	d: 68,
	up: 38,
	left: 37,
	down: 40,
	right: 39
};
var player = {
	x: gameWindow.width / 2,
	y: gameWindow.height / 2,
	size: 9,
	movementOptions: {
		w: false,
		a: false,
		s: false,
		d: false,
	},
	moveSpeed: 3,
	enemiesDefeated: 0,
	score: 0,
};
var enemyArray = [];
var isPlaying = true;
var nextSpawn = new Date().getTime();
window.addEventListener("keydown", keyDown);
gameLoop();
