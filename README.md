# Tower Of Hanoi: Java Console Edition
Welcome to JavaJos's Tower of Hanoi! This _almost_ fully functional game can be played by running the Main.java file. This will initiate a console with a few commands to let you play the game.
## Gameplay
The game is played by entering commands to move the stack of "disks" from the first "stack" to the third "stack". There are three rules to this:
+ You can only move one disk at a time.
+ Each move takes the top disk from one stack and puts it on the top of another stack.
+ Any disk can not be placed on top of a smaller disk
In this version, the towers have been turned on their side, so the topmost disk in each stack is the rightmost disk.
---
To play the game, you technically only need one command, but it's best to know the basic four.
+ [Tower](#tower)
+ [List](#list)
+ [Check](#check)
+ [Move](#move)
> [!tip]
> All commands in this console are case-insensitive, even though they are displayed with capitals in this doc.
### Tower
The tower command creates a new tower of the specified size. So `Tower 3` Would create a tower of size 3.
> [!warning]
> Currently, this has a built-in size restriction of 10. I should remove this later, but for right now, you are limited.
### List
The list command has no parameters and will list the three towers "stacks", as well as the numbers "disks". Here's an example of a new size 3 tower:
```
Tower A: [3, 2, 1]
Tower B: []
Tower C: []
```
### Check
Check will tell you if a move that you would like to make is legal. Moves are represented like this X,Y where X and Y are the starting tower letter and the ending tower letter.
For example, with the tower of three shown above, the move that would take disk 1 and put it on tower B, is A,B, so `Check A,B` would output that the move is valid.
### Move
Move is the exact same as check, except for it executes the move as well. So `Move A,B` would result in the number 1 moving to tower B. Running `list` after that move would return:
```
Tower A: [3, 2]
Tower B: [1]
Tower C: []
```
