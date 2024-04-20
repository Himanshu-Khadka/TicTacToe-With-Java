Java File path: src/main/java/himanshukhadka/tictactoe/TicTacToe.java

# TicTacToe-With-Java
This Java program is a simple implementation of the classic game Tic Tac Toe, utilizing JavaFX to create a graphical user interface. The game is presented on a 3x3 grid where players take turns marking the spaces in an attempt to align three of their marks either horizontally, vertically, or diagonally, thus winning the game.

The main class, `TicTacToe`, extends the JavaFX `Application` class, indicating that it is a JavaFX application. It defines a `start` method, which sets up the game interface. This includes creating a `GridPane` to represent the game board, where each cell in the grid is interactive and can be clicked to make a move.

Each cell is represented by a `Pane` and initialized as empty. Clicking a cell triggers a `handleMove` method, which checks if the space is unoccupied and the game has not yet been won. If these conditions are met, the current player's symbol (`X` or `O`) is drawn on the selected cell, and control switches to the other player.

The program checks for a winner after each move. If a player wins, an alert is displayed with a message congratulating the winning player. The game board uses a 2D character array to track the moves of each player, which helps in determining the winner during the game.

This description covers how the game is initialized, how interactions are handled, and how the end of the game is managed. It provides insights into the user interface elements and the logic used to enforce the rules of Tic Tac Toe.
