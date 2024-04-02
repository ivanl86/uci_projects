
const choices = ["rock", "paper", "scissors"];
const playerChoice = document.getElementById("player-choice");
const computerChoice = document.getElementById("computer-choice");
const displayResult = document.getElementById("display-result");
const playerScore = document.getElementById("player-score");
const computerScore = document.getElementById("computer-score");
let pScore = 0;
let cScore = 0;

const playGame = pChoice => {
    const cChoice = choices[Math.floor(Math.random() * 3)];
    let result = "";

    if (pChoice === cChoice) {
        result = "IT'S A TIE!";
    } else {
        switch(pChoice) {
            case "rock":
                result = cChoice === "scissors" ? "YOU WIN!" : "YOU LOSE!";
                break;
            case "paper":
                result = cChoice === "rock" ? "YOU WIN!" : "YOU LOSE!";
                break;
            case "scissors":
                result = cChoice === "paper" ? "YOU WIN!" : "YOU LOSE!";
                break;
        }
    }
    playerChoice.textContent = `PLAYER: ${pChoice}`;
    computerChoice.textContent = `COMPUTER: ${cChoice}`;
    displayResult.textContent = result;

    displayResult.classList.remove("green-font", "red-font");

    switch(result) {
        case "YOU WIN!":
            displayResult.classList.add("green-font");
            ++pScore;
            playerScore.textContent = pScore;
            break;
            case "YOU LOSE!":
                displayResult.classList.add("red-font");
                ++cScore;
                computerScore.textContent = cScore;
            break;
    }
}