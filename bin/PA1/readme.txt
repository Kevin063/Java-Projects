# CS611-PA2
## Tic Tac Toe Extension
---------------------------------------------------------------------------
Hengyuan Liu
kevin063@bu.edu
U14069299

## Files
---------------------------------------------------------------------------
PA2.zip------The zip file that contains all the java files as archive.
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
I have enabled the players to choose between Tic Tac Toe, Order and Chaos, Connect 4 through the "game library" with player history records stored across games.
Players are able to input their own surname and store that in the leaderboard with their name and game records.
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
Welcome to the game library! You can choose the game that you like the most!
Please choose your game from our game list!
1. Tic Tac Toe
2. Order and Chaos
3. Connect 4
1
Please enter your player number :3
Please enter the surname for the player 1:LSLHY
Please enter the surname for the player 2:kevin063
Please enter the surname for the player 3:Jeff Bezons
Please enter your board height :5
Please enter your board width :5
Please enter your winning combo condition for TTT:4
Welcome to the game!
As any other Tic Tac Toe games, your goal is to have three marks in a line.
But here you can set your own board size!
+--+--+--+--+--+
|  |  |  |  |  |
+--+--+--+--+--+
|  |  |  |  |  |
+--+--+--+--+--+
|  |  |  |  |  |
+--+--+--+--+--+
|  |  |  |  |  |
+--+--+--+--+--+
|  |  |  |  |  |
+--+--+--+--+--+
The game starts! You can take actions by entering grid locations, like"2,3". You can always end the game by entering "quit" in the console.
Action for the Player LSLHY:0,0
+--+--+--+--+--+
|O |  |  |  |  |
+--+--+--+--+--+
|  |  |  |  |  |
+--+--+--+--+--+
|  |  |  |  |  |
+--+--+--+--+--+
|  |  |  |  |  |
+--+--+--+--+--+
|  |  |  |  |  |
+--+--+--+--+--+
Action for the Player kevin063:0,4
+--+--+--+--+--+
|O |  |  |  |X |
+--+--+--+--+--+
|  |  |  |  |  |
+--+--+--+--+--+
|  |  |  |  |  |
+--+--+--+--+--+
|  |  |  |  |  |
+--+--+--+--+--+
|  |  |  |  |  |
+--+--+--+--+--+
Action for the Player Jeff Bezons:1,1
+--+--+--+--+--+
|O |  |  |  |X |
+--+--+--+--+--+
|  |3 |  |  |  |
+--+--+--+--+--+
|  |  |  |  |  |
+--+--+--+--+--+
|  |  |  |  |  |
+--+--+--+--+--+
|  |  |  |  |  |
+--+--+--+--+--+
Action for the Player LSLHY:0,-1
Invaild format for the input! Please try again.
0,1
+--+--+--+--+--+
|O |O |  |  |X |
+--+--+--+--+--+
|  |3 |  |  |  |
+--+--+--+--+--+
|  |  |  |  |  |
+--+--+--+--+--+
|  |  |  |  |  |
+--+--+--+--+--+
|  |  |  |  |  |
+--+--+--+--+--+
Action for the Player kevin063:2,3
+--+--+--+--+--+
|O |O |  |  |X |
+--+--+--+--+--+
|  |3 |  |  |  |
+--+--+--+--+--+
|  |  |  |X |  |
+--+--+--+--+--+
|  |  |  |  |  |
+--+--+--+--+--+
|  |  |  |  |  |
+--+--+--+--+--+
Action for the Player Jeff Bezons:2,2
+--+--+--+--+--+
|O |O |  |  |X |
+--+--+--+--+--+
|  |3 |  |  |  |
+--+--+--+--+--+
|  |  |3 |X |  |
+--+--+--+--+--+
|  |  |  |  |  |
+--+--+--+--+--+
|  |  |  |  |  |
+--+--+--+--+--+
Action for the Player LSLHY:0,4
The grid is occupied yet! Please choose another location.
0,3
+--+--+--+--+--+
|O |O |  |O |X |
+--+--+--+--+--+
|  |3 |  |  |  |
+--+--+--+--+--+
|  |  |3 |X |  |
+--+--+--+--+--+
|  |  |  |  |  |
+--+--+--+--+--+
|  |  |  |  |  |
+--+--+--+--+--+
Action for the Player kevin063:0,2
+--+--+--+--+--+
|O |O |X |O |X |
+--+--+--+--+--+
|  |3 |  |  |  |
+--+--+--+--+--+
|  |  |3 |X |  |
+--+--+--+--+--+
|  |  |  |  |  |
+--+--+--+--+--+
|  |  |  |  |  |
+--+--+--+--+--+
Action for the Player Jeff Bezons:3,3
+--+--+--+--+--+
|O |O |X |O |X |
+--+--+--+--+--+
|  |3 |  |  |  |
+--+--+--+--+--+
|  |  |3 |X |  |
+--+--+--+--+--+
|  |  |  |3 |  |
+--+--+--+--+--+
|  |  |  |  |  |
+--+--+--+--+--+
Action for the Player LSLHY:1,4
+--+--+--+--+--+
|O |O |X |O |X |
+--+--+--+--+--+
|  |3 |  |  |O |
+--+--+--+--+--+
|  |  |3 |X |  |
+--+--+--+--+--+
|  |  |  |3 |  |
+--+--+--+--+--+
|  |  |  |  |  |
+--+--+--+--+--+
Action for the Player kevin063:1,3
+--+--+--+--+--+
|O |O |X |O |X |
+--+--+--+--+--+
|  |3 |  |X |O |
+--+--+--+--+--+
|  |  |3 |X |  |
+--+--+--+--+--+
|  |  |  |3 |  |
+--+--+--+--+--+
|  |  |  |  |  |
+--+--+--+--+--+
Action for the Player Jeff Bezons:4,4
+--+--+--+--+--+
|O |O |X |O |X |
+--+--+--+--+--+
|  |3 |  |X |O |
+--+--+--+--+--+
|  |  |3 |X |  |
+--+--+--+--+--+
|  |  |  |3 |  |
+--+--+--+--+--+
|  |  |  |  |3 |
+--+--+--+--+--+
Player Jeff Bezons, You win!
-------------------------------------
Wanna play again? Enter "Y" to reset the game, otherwise to quitY
Please choose your game from our game list!
1. Tic Tac Toe
2. Order and Chaos
3. Connect 4
2
Please enter the surname for the player 1:LSLHY
Please enter the surname for the player 2:Jeff Bezons
Please enter your board height :4
Please enter your board width :4
Please enter your winning combo condition for OC:3
Welcome to the game!
Order and Chaos is a variant of the game tic-tac-toe on a gameboard with the size that you customized.
+--+--+--+--+
|  |  |  |  |
+--+--+--+--+
|  |  |  |  |
+--+--+--+--+
|  |  |  |  |
+--+--+--+--+
|  |  |  |  |
+--+--+--+--+
The game starts! You can take actions by entering the piece you want, and grid locations, like"x,2,3". You can always end the game by entering "quit" in the console.
Action for the Order Player LSLHY:x,0,0
+--+--+--+--+
|X |  |  |  |
+--+--+--+--+
|  |  |  |  |
+--+--+--+--+
|  |  |  |  |
+--+--+--+--+
|  |  |  |  |
+--+--+--+--+
Action for the Chaos Player LSLHY:o,1,1
+--+--+--+--+
|X |  |  |  |
+--+--+--+--+
|  |O |  |  |
+--+--+--+--+
|  |  |  |  |
+--+--+--+--+
|  |  |  |  |
+--+--+--+--+
Action for the Order Player LSLHY:o,0,2
+--+--+--+--+
|X |  |O |  |
+--+--+--+--+
|  |O |  |  |
+--+--+--+--+
|  |  |  |  |
+--+--+--+--+
|  |  |  |  |
+--+--+--+--+
Action for the Chaos Player LSLHY:o,2,0
+--+--+--+--+
|X |  |O |  |
+--+--+--+--+
|  |O |  |  |
+--+--+--+--+
|O |  |  |  |
+--+--+--+--+
|  |  |  |  |
+--+--+--+--+
Order Player LSLHY, You win!
-------------------------------------
Wanna play again? Enter "Y" to reset the game, otherwise to quitY
Please choose your game from our game list!
1. Tic Tac Toe
2. Order and Chaos
3. Connect 4
3
Please enter your player number :3
Please enter the surname for the player 1:Jeff K
Please enter the surname for the player 2:LSLHY
Please enter the surname for the player 3:PP
Please enter your board height :5
Please enter your board width :3
Please enter your winning combo condition for C4:3
Welcome to the game!
Connect 4 is a two-player connection rack game, in which the players choose a color and then take turns dropping colored tokens into a grid that you customized.
+--+--+--+
|  |  |  |
+--+--+--+
|  |  |  |
+--+--+--+
|  |  |  |
+--+--+--+
|  |  |  |
+--+--+--+
|  |  |  |
+--+--+--+
The game starts! You can take actions by entering the column that you want to drop the token, like"3". You can always end the game by entering "quit" in the console.
Action for the Player Jeff K:0
+--+--+--+
|  |  |  |
+--+--+--+
|  |  |  |
+--+--+--+
|  |  |  |
+--+--+--+
|  |  |  |
+--+--+--+
|O |  |  |
+--+--+--+
Action for the Player LSLHY:1
+--+--+--+
|  |  |  |
+--+--+--+
|  |  |  |
+--+--+--+
|  |  |  |
+--+--+--+
|  |  |  |
+--+--+--+
|O |X |  |
+--+--+--+
Action for the Player PP:2
+--+--+--+
|  |  |  |
+--+--+--+
|  |  |  |
+--+--+--+
|  |  |  |
+--+--+--+
|  |  |  |
+--+--+--+
|O |X |3 |
+--+--+--+
Action for the Player Jeff K:0
+--+--+--+
|  |  |  |
+--+--+--+
|  |  |  |
+--+--+--+
|  |  |  |
+--+--+--+
|O |  |  |
+--+--+--+
|O |X |3 |
+--+--+--+
Action for the Player LSLHY:1
+--+--+--+
|  |  |  |
+--+--+--+
|  |  |  |
+--+--+--+
|  |  |  |
+--+--+--+
|O |X |  |
+--+--+--+
|O |X |3 |
+--+--+--+
Action for the Player PP:2
+--+--+--+
|  |  |  |
+--+--+--+
|  |  |  |
+--+--+--+
|  |  |  |
+--+--+--+
|O |X |3 |
+--+--+--+
|O |X |3 |
+--+--+--+
Action for the Player Jeff K:1
+--+--+--+
|  |  |  |
+--+--+--+
|  |  |  |
+--+--+--+
|  |O |  |
+--+--+--+
|O |X |3 |
+--+--+--+
|O |X |3 |
+--+--+--+
Action for the Player LSLHY:2
+--+--+--+
|  |  |  |
+--+--+--+
|  |  |  |
+--+--+--+
|  |O |X |
+--+--+--+
|O |X |3 |
+--+--+--+
|O |X |3 |
+--+--+--+
Action for the Player PP:4
Invaild format for the input! Please try again.
0
+--+--+--+
|  |  |  |
+--+--+--+
|  |  |  |
+--+--+--+
|3 |O |X |
+--+--+--+
|O |X |3 |
+--+--+--+
|O |X |3 |
+--+--+--+
Action for the Player Jeff K:2
+--+--+--+
|  |  |  |
+--+--+--+
|  |  |O |
+--+--+--+
|3 |O |X |
+--+--+--+
|O |X |3 |
+--+--+--+
|O |X |3 |
+--+--+--+
Player Jeff K, You win!
-------------------------------------
Wanna play again? Enter "Y" to reset the game, otherwise to quitY
Please choose your game from our game list!
1. Tic Tac Toe
2. Order and Chaos
3. Connect 4
3
Please enter your player number :2
Please enter the surname for the player 1:LSLHY
Please enter the surname for the player 2:Jeff
Please enter your board height :3
Please enter your board width :3
Please enter your winning combo condition for C4:3
Welcome to the game!
Connect 4 is a two-player connection rack game, in which the players choose a color and then take turns dropping colored tokens into a grid that you customized.
+--+--+--+
|  |  |  |
+--+--+--+
|  |  |  |
+--+--+--+
|  |  |  |
+--+--+--+
The game starts! You can take actions by entering the column that you want to drop the token, like"3". You can always end the game by entering "quit" in the console.
Action for the Player LSLHY:0
+--+--+--+
|  |  |  |
+--+--+--+
|  |  |  |
+--+--+--+
|O |  |  |
+--+--+--+
Action for the Player Jeff:1
+--+--+--+
|  |  |  |
+--+--+--+
|  |  |  |
+--+--+--+
|O |X |  |
+--+--+--+
Action for the Player LSLHY:0
+--+--+--+
|  |  |  |
+--+--+--+
|O |  |  |
+--+--+--+
|O |X |  |
+--+--+--+
Action for the Player Jeff:1
+--+--+--+
|  |  |  |
+--+--+--+
|O |X |  |
+--+--+--+
|O |X |  |
+--+--+--+
Action for the Player LSLHY:1
+--+--+--+
|  |O |  |
+--+--+--+
|O |X |  |
+--+--+--+
|O |X |  |
+--+--+--+
Action for the Player Jeff:0
+--+--+--+
|X |O |  |
+--+--+--+
|O |X |  |
+--+--+--+
|O |X |  |
+--+--+--+
Action for the Player LSLHY:1
The whole column is occupied yet! Please choose another location.
2
+--+--+--+
|X |O |  |
+--+--+--+
|O |X |  |
+--+--+--+
|O |X |O |
+--+--+--+
Action for the Player Jeff:2
+--+--+--+
|X |O |  |
+--+--+--+
|O |X |X |
+--+--+--+
|O |X |O |
+--+--+--+
Action for the Player LSLHY:2
+--+--+--+
|X |O |O |
+--+--+--+
|O |X |X |
+--+--+--+
|O |X |O |
+--+--+--+
The game ends with a stalemate
Wanna play again? Enter "Y" to reset the game, otherwise to quitquit
Player PP won TTT 0 times, OC 0 times, C4 0 times.
Player LSLHY won TTT 0 times, OC 1 times, C4 0 times.
Player Jeff Bezons won TTT 1 times, OC 0 times, C4 0 times.
Player Jeff K won TTT 0 times, OC 0 times, C4 1 times.
Player kevin063 won TTT 0 times, OC 0 times, C4 0 times.
Player Jeff won TTT 0 times, OC 0 times, C4 0 times.
The game has been ends with stalemate for 1 times.
