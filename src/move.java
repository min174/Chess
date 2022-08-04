public class move {
    public static boolean selection(int board[][], char input[], int player){
        if(input.length != 2){
            System.out.println("try again");
            return false;
        }
        int i, j, a=input[0], b=input[1];
        j=a-97; //converting input chars to board index
        i=7-(b-49);

        if(a<97 || a>104 || b<49 || b>56) { //if input is not [a-h][1-8]
            System.out.println("try again");
            return false;
        }

        boolean valid=false;
        if(board[i][j] == 1 && player == 0) { //white pawn
            System.out.print("pawn selected");
            valid=true;
        }
        if(board[i][j] == 11 && player == 1) { //black pawn
            System.out.print("pawn selected");
            valid=true;
        }
        if(board[i][j] == 2 && player == 0) { //white knight
            System.out.print("knight selected");
            valid=true;
        }
        if(board[i][j] == 12 && player == 1) { //black knight
            System.out.print("knight selected");
            valid=true;
        }
        if(board[i][j] == 3 && player == 0) { //white bishop
            System.out.print("bishop selected");
            valid=true;
        }
        if(board[i][j] == 13 && player == 1) { //black bishop
            System.out.print("bishop selected");
            valid=true;
        }
        if(board[i][j] == 4 && player == 0) { //white rook
            System.out.print("rook selected");
            valid=true;
        }
        if(board[i][j] == 14 && player == 1) { //black rook
            System.out.print("rook selected");
            valid=true;
        }
        if(board[i][j] == 5 && player == 0) { //white queen
            System.out.print("queen selected");
            valid=true;
        }
        if(board[i][j] == 15 && player == 1) { //black queen
            System.out.print("queen selected");
            valid=true;
        }
        if(board[i][j] == 6 && player == 0) { //white king
            System.out.print("king selected");
            valid=true;
        }
        if(board[i][j] == 16 && player == 1) { //black king
            System.out.print("king selected");
            valid=true;
        }
        if(!valid){
            System.out.println("try again");
        }
        return valid;
    }
}
