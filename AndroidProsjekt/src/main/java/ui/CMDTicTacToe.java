package ui;

import data.Player;
import logic.TicTacToe;

import java.util.Scanner;

/**
 * Created by OlavH on 23-Mar-17.
 */
public class CMDTicTacToe {


    public static void main(String[] args) {

        Player p1 = Player.X;
        Player p2 = Player.O;

        TicTacToe game = new TicTacToe(p1,p2);

        Scanner scanner = new Scanner(System.in);

        while (game.isActive()){

            game.getBoard().printBoard();
            System.out.println("Active player is: "+game.getActivePlayer());

            boolean valid;
            do {
                System.out.println("Select valid coordinates");

                int row = -1;
                int colomn = -1;

                try {
                    String line = scanner.nextLine().trim();

                    String[] split = line.split("\\s");

                    row = Integer.parseInt(split[0]);
                    colomn = Integer.parseInt(split[1]);

                }catch (Exception e){
                    valid = false;
                }

                valid = game.makeMove(game.getActivePlayer(), row, colomn);

            }while (!valid);
        }

        System.out.println("Game is over!");

        game.getBoard().printBoard();
        System.out.println("Winner is "+game.getBoard().getWinner()+"!");

    }
}
