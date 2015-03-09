###Game of life 2D with finite grid

Java Code Kata by Nico Mertens und Katharina Laube

Written during and finished after the [Softwerkskammer Magdeburg Coding Dojo @ SelectLine] 
(http://www.softwerkskammer.org/)

Runs with *JUnit 4.11* and *hamcrest 1.3* as testing framework and uses *google guava 13.0.1* for file parsing.

Run *GameRunnerTest.runFullGameFromFile()* to see a whole game with three players.

**Problem Description**

This Kata is about calculating the next generation of Conway's game of life, given any starting position. See http://en.wikipedia.org/wiki/Conway%27s_Game_of_Life for background.

You start with a two dimensional grid of cells, where each cell is either alive or dead. In this version of the problem, the grid is finite, and no life can exist off the edges. When calculating the next generation of the grid, follow these rules:

   1. Any live cell with fewer than two live neighbours dies, as if caused by underpopulation.
   2. Any live cell with more than three live neighbours dies, as if by overcrowding.
   3. Any live cell with two or three live neighbours lives on to the next generation.
   4. Any dead cell with exactly three live neighbours becomes a live cell.
   
You should write a program that can accept an arbitrary grid of cells, and will output a similar grid showing the next generation.

**Clues**

The input starting position could be a text file that looks like this:

Generation 1:
4 8
........
....*...
...**...
........
And the output could look like this:

Generation 2:
4 8
........
...**...
...**...
........

**Suggested Test Cases**
Make sure you have enough coverage of edge cases - where there are births and deaths at the edge of the grid.

Rules taken from: [KataGameOfLife @codingdojo.org] (http://codingdojo.org/cgi-bin/index.pl?KataGameOfLife)
