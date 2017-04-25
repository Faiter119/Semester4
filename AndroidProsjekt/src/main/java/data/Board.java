package data;

import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * Created by OlavH on 21-Mar-17.
 */
public class Board {

    private PlayerMove[][] board = new PlayerMove[3][3];

    public Board(){

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = PlayerMove.E;
            }
        }

    }

    public boolean makeMove(PlayerMove move, int r, int c){

        try {
            if (board[r][c] == PlayerMove.E) {

                board[r][c] = move;
                return true;

            }
            return false;
        }catch (IndexOutOfBoundsException e){return false;}
    }

    public boolean gameIsWon(){

        return getWinner() != PlayerMove.E;

    }

    public PlayerMove getWinner(){

        PlayerMove rows = checkRows();
        PlayerMove colomns = checkColomns();
        PlayerMove crosses = checkCrosses();

        Optional<PlayerMove> any = Stream.of(new PlayerMove[]{rows, colomns, crosses}).filter(playerMove -> !playerMove.equals(PlayerMove.E)).findAny();

        if (any.isPresent()){
            return any.get();
        }
        return PlayerMove.E; // no one has won

    }

    public boolean boardIsFull(){

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == PlayerMove.E) return false;
            }
        }
        return true;
    }

    private PlayerMove checkRows(){

        for (int i = 0; i < board.length; i++) {

            boolean allX = Arrays.stream(board[i]).allMatch(playerMove -> playerMove.equals(PlayerMove.X));
            boolean allO = Arrays.stream(board[i]).allMatch(playerMove -> playerMove.equals(PlayerMove.O));

            if (allX || allO) return allX ? PlayerMove.X : PlayerMove.O;

        }

        return PlayerMove.E;
    }

    private PlayerMove checkColomns(){

        for (int i = 0; i < board.length; i++) {

            boolean allMatchX = Arrays.stream(new PlayerMove[]{board[0][i], board[1][i], board[2][i]}).allMatch(playerMove -> playerMove.equals(PlayerMove.X));
            boolean allMatchO = Arrays.stream(new PlayerMove[]{board[0][i], board[1][i], board[2][i]}).allMatch(playerMove -> playerMove.equals(PlayerMove.O));

            //boolean b = board[0][i] == board[1][i] && board[1][i] == board[2][i];

            if (allMatchO || allMatchX) return allMatchX ? PlayerMove.X : PlayerMove.O;
        }

        return PlayerMove.E;
    }

    private PlayerMove checkCrosses(){

        PlayerMove o = PlayerMove.O;
        PlayerMove x = PlayerMove.X;


        PlayerMove prev = board[0][0];
        boolean match = true;
        for (int i = 1; i < board.length; i++) {

            PlayerMove current = board[i][i];

            if (prev != current){
                match = false;
                break;
            }

            prev = current;
        }

        if (match) return prev;

        prev = board[0][0];
        match = true;
        for (int i = board.length-1; i > 0; i--) {

            System.out.println(i);
            PlayerMove current = board[i][i];

            if (prev != current){
                match = false;
                break;
            }

            prev = current;
        }
        if (match) return prev;


        return PlayerMove.E;
    }

    public void printBoard(){

        for (int i = 0; i < board.length; i++) {

            System.out.println(Arrays.toString(board[i]));

        }

    }


    public static void main(String[] args) {

        Board board = new Board();

        board.makeMove(PlayerMove.X,0,0);
        board.makeMove(PlayerMove.O,0,1);
        board.makeMove(PlayerMove.X,0,2);
        board.makeMove(PlayerMove.O,1,0);
        board.makeMove(PlayerMove.X,1,1);
        board.makeMove(PlayerMove.O,1,2);
        board.makeMove(PlayerMove.X,2,0);
        board.makeMove(PlayerMove.O,2,1);
        board.makeMove(PlayerMove.X,2,2);

        System.out.println(board.gameIsWon());

        board.printBoard();
    }

}
