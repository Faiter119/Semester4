package data;

/**
 * Created by OlavH on 21-Mar-17.
 */
public enum Player {

    X,
    O;

    public PlayerMove getPlayerMove(){

        return PlayerMove.valueOf(this.name());
    }
    public Player of(PlayerMove move){

        return valueOf(move.toString());
    }
}
