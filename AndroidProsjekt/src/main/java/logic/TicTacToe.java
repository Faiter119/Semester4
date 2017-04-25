package logic;

import data.Board;
import data.Player;

/**
 * Created by OlavH on 21-Mar-17.
 */
public class TicTacToe {

    private boolean isActive = true;

    private Board gameBoard = new Board();

    private Player activePlayer;

    private Player firstPlayer;
    private Player secondPlayer;

    public TicTacToe(Player firstPlayer, Player secondPlayer) {

        this.firstPlayer = firstPlayer;
        this.secondPlayer = secondPlayer;

        activePlayer = firstPlayer;
    }

    public boolean isActive() {

        return !gameBoard.gameIsWon() && !gameBoard.boardIsFull();
    }

    public boolean makeMove(Player player, int row, int colomn){

        boolean b = gameBoard.makeMove(player.getPlayerMove(), row, colomn);

        if (!b) return false;

        activePlayer = activePlayer == firstPlayer ? secondPlayer : firstPlayer;

        return true;
    }

    public Player getActivePlayer() {

        return activePlayer;
    }

    public Board getBoard() {

        return gameBoard;
    }
}
