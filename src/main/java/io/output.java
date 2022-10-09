package io;
import model.*;
public class output {
    public static void moveIntoCheck() {
        System.out.println("You cannot move your king into check");
    }
    public static void invalidMove() {
        System.out.println("Move not valid");
    }
    public static void noPieceSelected() {
        if(game.check(game.player) == 0) {
            System.out.println("No piece selected, try again");
        } else {
            System.out.println("Your king is in check, you must move it");
        }
    }
    public static void pieceSelected() {
        String[] pieces = {"pawn", "knight", "bishop", "rook", "queen", "king"};
        System.out.println(pieces[game.piece-1] + " selected");
    }
    public static void movePiece() {
        System.out.println("Move piece, or press p to pick a new piece");
    }
    public static void welcome() {
        System.out.println("###############\n#####CHESS#####\n###############\n");
        System.out.println("\n~~~Please enter the names of the players~~~");

    }
    public static void checkmate(int player) {
        if(player == 0) {
            System.out.println("Checkmate! " + Player.p2 + " wins!");
        } else {
            System.out.println("Checkmate! " + Player.p1 + " wins!");
        }
    }
    public static void choosePiece(int player) {
        if(player == 0) {
            System.out.println(Player.p1 + ", choose a piece");
        } else {
            System.out.println(Player.p2 + ", choose a piece");
        }
    }
    public static void board() {
        int i, j;
        System.out.println("  ----- ----- ----- ----- ----- ----- ----- -----");
        for(i=0;i<8;i++) {
            System.out.print(8-i + "|");
            for(j=0;j<8;j++) { //board[][] array values represent chess pieces

                switch(game.board[i][j]){
                    case 0://if square is blank
                        System.out.print("     |");
                        break;
                    case 1: //white pawn
                        System.out.print("  P  |");
                        break;
                    case 11://black pawn
                        System.out.print(" *P* |");
                        break;
                    case 2: //white knight
                        System.out.print("  N  |");
                        break;
                    case 12://black knight
                        System.out.print(" *N* |");
                        break;
                    case 3://white bishop
                        System.out.print("  B  |");
                        break;
                    case 13://black bishop
                        System.out.print(" *B* |");
                        break;
                    case 4: //white rook
                        System.out.print("  R  |");
                        break;
                    case 14://black rook
                        System.out.print(" *R* |");
                        break;
                    case 5://white queen
                        System.out.print("  Q  |");
                        break;
                    case 15://black queen
                        System.out.print(" *Q* |");
                        break;
                    case 6://white king
                        System.out.print("  K  |");
                        break;
                    case 16://black king
                        System.out.print(" *K* |");
                }
            }
            System.out.print("\n  ----- ----- ----- ----- ----- ----- ----- -----\n");
        }
        System.out.print("    a     b     c     d     e     f     g     h\n");
    }
}
