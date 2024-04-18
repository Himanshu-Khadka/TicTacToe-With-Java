/**
 * <h1>Tic Tac Toe</h1>
 * The Tic Tac Toe implements a javafx to extend an application, that simply displays 3*3 grid pane, containing Pane
 * cell in each grid. It counts for the player, and according to that it draws the X or O on the pane. It implements
 * a 3*3 matrix 2 dimensional array that keep track of the player and is used to decide winner.
 *
 *
 * @Author Himanshu Khadka
 * @Version 1.0
 * @since 2024-04-18
 */


package himanshukhadka.tictactoe;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
/**
 * This is the main Tic Tac Toe class that extends application and implements start method by overriding the start method.
 */

public class TicTacToe extends Application {
    private char currentPlayer = 'X';
    private char[][] gameBoard = new char[3][3]; // Game board

    @Override
    public void start(Stage stage) {

        //Setting up grid pane
        GridPane pane = new GridPane();
        pane.setGridLinesVisible(true);
        //Setting cells for each grid in grid pane
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                Pane cell = new Pane();
                cell.setPrefSize(200, 200);
                int finalI = i;
                int finalJ = j;
                cell.setOnMouseClicked(e -> handleMove(cell, finalI, finalJ)); //calls handleMove when mouse in clicked in cell
                pane.add(cell, j, i);
                gameBoard[i][j] = ' '; // Initialize the board with spaces
            }
        }

        Scene scene = new Scene(pane);
        stage.setTitle("Tic-Tac-Toe");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * This is handelMove that handles user move and draw circle O or x according to the players turn.
     * Also, it checks for the winner at every move, and updates the players info in gameBoard in char arrays.
     * @param cell
     * @param row
     * @param col
     */
    private void handleMove(Pane cell, int row, int col) {
        if (gameBoard[row][col] == ' ' && !checkWinner()) { // Only allow move if cell is empty and no winner yet
            if (currentPlayer == 'X') {
                drawX(cell);
                gameBoard[row][col] = 'X';
                currentPlayer = 'O';
            } else {
                drawO(cell);
                gameBoard[row][col] = 'O';
                currentPlayer = 'X';
            }
            if (checkWinner()) {
                displayWinner();
            }
        }
    }

    /**
     * This method on call draws X on the pane using two lines
     * @param cell
     */
    private void drawX(Pane cell) {
        Line line1 = new Line(10, 10, 190, 190);
        Line line2 = new Line(10, 190, 190, 10);
        line1.setStrokeWidth(5);
        line2.setStrokeWidth(5);
        cell.getChildren().addAll(line1, line2);
    }

    /**
     * This method on call draws O on the pane using Circle class.
     * @param cell
     */
    private void drawO(Pane cell) {
        Circle circle = new Circle(100, 100, 90);
        circle.setStroke(Color.BLACK);
        circle.setStrokeWidth(5);
        circle.setFill(Color.TRANSPARENT);
        cell.getChildren().add(circle);
    }

    /**
     * This check winner and return's true if the current player is winner else it returns false
     * @return
     */
    private boolean checkWinner() {
        // Horizontal, vertical, and diagonal checks
        for (int i = 0; i < 3; i++) {
            if (gameBoard[i][0] == gameBoard[i][1] && gameBoard[i][1] == gameBoard[i][2] && gameBoard[i][0] != ' ') return true;
            if (gameBoard[0][i] == gameBoard[1][i] && gameBoard[1][i] == gameBoard[2][i] && gameBoard[0][i] != ' ') return true;
        }
        if (gameBoard[0][0] == gameBoard[1][1] && gameBoard[1][1] == gameBoard[2][2] && gameBoard[0][0] != ' ') return true;
        if (gameBoard[0][2] == gameBoard[1][1] && gameBoard[1][1] == gameBoard[2][0] && gameBoard[0][2] != ' ') return true;
        return false;
    }

    /**
     * This gives the alert about the winner, if the winner is decided then it will show an alert message.
     */
    private void displayWinner() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Game Over");
        alert.setHeaderText("Congratulations!");
        alert.setContentText("Player " + (currentPlayer == 'X' ? 'O' : 'X') + " wins!");
        alert.showAndWait();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

