# Tic Tac Toe

- This project consists of a console based version of Tic Tac Toe that allows two human players to play the game on a 3 x 3 board. The project has been developed using the MVC pattern.

- The first player will be the X, the second player will be the O. The players continue to play until there is a winner, a draw, or someone gives up. 

## Execution details
  1. Clone this Git repository: `git clone https://github.com/sindhusingamneni/tic-tac-toe`
  2. Navigate to the src folder within the project: `cd tic-tac-toe/src`
  3. Either run the executable JAR file or the Main.java file using the instructions below to begin the game!

#### Running the executable JAR file
Once in the src folder, run command `java -jar tic-tac-toe.jar` to run the JAR file and start the game.

#### Running Main.java
Once in the src folder, run command `javac Main.java` to compile and then run command `java Main` to start the game.

### Running the test cases
Open up the project in an IDE of choice and run the TestGame.java file present within the tests directory as JUnit Test. These are JUnit 4 test cases so appropriate installations should be in place before running the tests cases. There are 19 test cases which test different game scenarios.

## Assumptions made
I have assumed that the game continues to ask the player for input if they provide the incorrect input. I have also assumed that the console message for incorrect input can be a general "Please enter a valid coordinate with numbers between 1-3 and with a format of 'x,y' or quit the game with 'q'" instead of specifying why the input was incorrect such as "Please enter only numbers" or "You have entered a coordinate which was not within the required range. Please try again"

## Game play
- Two players are required for a game.
- Each player will assume either an “X” or “O”.
- Players take turn to play till a player wins, or the end of the game (whichever happens first).
- Player X always starts the game.

## Conditions for a win
- A player wins when all fields in a column are taken by the player.
- A player wins when all fields in a row are taken by the player.
- A player wins when all fields in a diagonal are taken by the player.

## Conditions for a draw
The game is drawn when all fields are taken on the board.
