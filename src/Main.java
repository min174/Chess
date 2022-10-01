public class Main {

    public static void main(String[] args) {
        view.welcome();
        Player p = new Player();
        p.start();
        view.board();
        move.player = 0;
        boolean passed = false;

        while(true) {
            if(move.check(move.player) == 2) { //if checkmate, end the game
                view.checkmate(move.player);
                break;
            }

            int[] piecePos; //co ordinates of piece
            int[] movePos; //where piece will be moved to
            view.choosePiece(move.player);

            while(true) {
                piecePos = move.selection(input.boardSquare());
                if(move.piece == 0) { //if no piece selected
                    view.noPieceSelected();
                    continue; //try again
                }
                view.pieceSelected();

                while(true) {
                    view.movePiece();
                    movePos = input.boardSquare();
                    if(movePos[0] == -1) { //if 'p' is entered
                        view.choosePiece(move.player);
                        passed = true;
                        break;
                    }
                    if(move.isValid(piecePos, movePos) == 1) { //if move is valid
                        break;
                    } else if(move.isValid(piecePos, movePos) == 0) { //if move is invalid
                        view.invalidMove();
                    } else {
                        view.moveIntoCheck(); //if king was being moved into check
                    }
                }
                if(passed) {
                    passed=false;
                    continue;
                }
                break;
            }

            
            input.promotion();
            view.board();


            if(move.player == 0) { //swap to other player
                move.player=1;
            } else {
                move.player=0;
            }
        }
    }
}
