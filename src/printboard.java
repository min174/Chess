public class printboard {
    public static void print(int board[][]){
        int i, j;
        System.out.println("  ----- ----- ----- ----- ----- ----- ----- -----");
        for(i=0;i<8;i++) {
            System.out.print(8-i + "|");
            for(j=0;j<8;j++) { //board[][] array values represent chess pieces
                if(board[i][j] == 0) { //if square is blank
                    System.out.print("     |");
                }
                if(board[i][j] == 1) { //white pawn
                    System.out.print("  P  |");
                }
                if(board[i][j] == 11) { //black pawn
                    System.out.print(" *P* |");
                }
                if(board[i][j] == 2) { //white knight
                    System.out.print("  N  |");
                }
                if(board[i][j] == 12) { //black knight
                    System.out.print(" *N* |");
                }
                if(board[i][j] == 3) { //white bishop
                    System.out.print("  B  |");
                }
                if(board[i][j] == 13) { //black bishop
                    System.out.print(" *B* |");
                }
                if(board[i][j] == 4) { //white rook
                    System.out.print("  R  |");
                }
                if(board[i][j] == 14) { //black rook
                    System.out.print(" *R* |");
                }
                if(board[i][j] == 5) { //white queen
                    System.out.print("  Q  |");
                }
                if(board[i][j] == 15) { //black queen
                    System.out.print(" *Q* |");
                }
                if(board[i][j] == 6) { //white king
                    System.out.print("  K  |");
                }
                if(board[i][j] == 16) { //black king
                    System.out.print(" *K* |");
                }
            }
            System.out.print("\n  ----- ----- ----- ----- ----- ----- ----- -----\n");
        }
        System.out.print("    a     b     c     d     e     f     g     h\n");
    }
}
