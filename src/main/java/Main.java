import io.*;
import model.*;

public class Main {

    public static void main(String[] args) {
        output.welcome();
        Player p = new Player();
        p.start();
        output.board();
        game.player = 0;
        boolean passed = false;

        while(true) {
            if(game.check(game.player) == 2) { //if checkmate, end the game
                output.checkmate(game.player);
                break;
            }

            int[] piecePos; //co ordinates of piece
            int[] movePos; //where piece will be moved to
            output.choosePiece(game.player);

            while(true) {
                piecePos = game.selection(input.boardSquare());
                if(game.piece == 0) { //if no piece selected
                    output.noPieceSelected();
                    continue; //try again
                }
                output.pieceSelected();

                while(true) {
                    output.movePiece();
                    movePos = input.boardSquare();
                    if(movePos[0] == -1) { //if 'p' is entered
                        output.choosePiece(game.player);
                        passed = true;
                        break;
                    }
                    if(game.isValid(piecePos, movePos) == 1) { //if move is valid
                        break;
                    } else if(game.isValid(piecePos, movePos) == 0) { //if move is invalid
                        output.invalidMove();
                    } else {
                        output.moveIntoCheck(); //if king was being moved into check
                    }
                }
                if(passed) {
                    passed=false;
                    continue;
                }
                break;
            }

            
            input.promotion();
            output.board();


            if(game.player == 0) { //swap to other player
                game.player=1;
            } else {
                game.player=0;
            }
        }
    }
}
