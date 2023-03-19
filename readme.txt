# CS611-PA2
## Apex World
---------------------------------------------------------------------------
Hengyuan Liu
kevin063@bu.edu
U14069299

## Files
---------------------------------------------------------------------------
PA2.zip------The zip file that contains all the java files as archive.
leaderboard.txt------The save file for the leaderboard. Will be autocreated if not existing in run-time.
main.java------The class that starts the game.
gamelibrary.java------The class that start a game or mutiple games from a console, and record match leaderboard.
IO.java------The abstract class for handing user interactions and generate outputs.
board.java------The class for gameboard and wincheck functions.
action.java------The class for storing any user input as a game action that can be applied to the gameboard.
game.java------The class for the game config, a game contains a board, and is playable.
player.java------The class for storing player info and win history.
leaderboard.java------The class for storing all players match history.
TTTboard.java------The class for Tic Tac Toe board's specific logics.
TTTaction.java------The class for Tic Tac Toe player action's specific logics.
TTTgame.java------The class for Tic Tac Toe game rule and instructions' specific logics.
OCboard.java------The class for Order and Chaos board's specific logics.
OCaction.java------The class for Order and Chaos player action's specific logics.
OCgame.java------The class for Order and Chaos game rule and instructions' specific logics.
C4board.java------The class for Connect 4 board's specific logics.
C4action.java------The class for Connect 4 player action's specific logics.
C4game.java------The class for Connect 4 game rule and instructions' specific logics.
## Notes
---------------------------------------------------------------------------
I have utlized the file IOs in the game to enable the saving of leaderaboard data to the local file system. So that the game score records can be kept permanently. It can be further implemented to enable extendability in savegame and resume later. 
I have enable the scalability on choosing between different maps to have various game generics. More maps with different adventure stories can be created by extending the map class.
I have enable the scalability on more than 2 players in both the game Tic Tac Toe and Connect 4.
I have enable the scalability on customized the board size and winning condition for all three games, with proper validation check on the user input.
I have built up the utility functions in the board and IO class and make them modular and fragment. For example, the wincheck() are divided into seperate wincheck functions in four independent directions. So that those functions can support the extendibility for more complex game variants.
## How to compile and run
---------------------------------------------------------------------------
1. Navigate to the directory containing the zip file PA2.zip
2. Run the following instructions:
<Example below>
unzip PA2.zip
cd PA2
javac -d bin src/*.java
java -cp bin main

## Input/Output Example
---------------------------------------------------------------------------
