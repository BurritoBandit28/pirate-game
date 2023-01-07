const doc = document.getElementById('body'); // Create a canvas, and get context.
const form = document.getElementById('form');
const canvas = document.createElement("canvas");
canvas.width = 500;
canvas.height = 500;
doc.appendChild(canvas);
const ctx = canvas.getContext("2d");

let gameCodes = ["cum hehe"]; // use this as a game code as i have no idea how to request the actual codes

let code; // the code that the client has entered

function enterCode() {
    requestCodes();

    code = document.getElementById("textarea").value;

    for (let i in gameCodes) { // checks if the game code is valid
        if (code == gameCodes[i]) {
            alert("Connected to the server. (not really)");
            form.style.display = "none"; // hides the form as its no longer necessary
            return;
        }
    }
    
    alert("There is no game with that code.");
}

function createCode() {
    gameCodes.push(Math.floor(Math.random()*100000)); // creates a random game code between 00000 and 99999
    alert("Created lobby with game code " + gameCodes.at(-1));
}

function requestCodes() {
    // this function will request all the game codes from the server
}