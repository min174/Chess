import java.util.Scanner;

public class move {
    public static boolean selection(int board[][], char input[], int player){
        if(input.length != 2){
            System.out.println("Input not 2 chars, try again");
            return false;
        }

        Scanner scanner = new Scanner(System.in);

        char[] move;
        int i, j, a=input[0], b=input[1], piece=0;
        j=a-97; //converting input chars to board index
        i=7-(b-49);

        if(a<97 || a>104 || b<49 || b>56) { //if input is not [a-h][1-8]
            System.out.println("Not valid board space, try again");
            return false;
        }

        boolean valid=false;
        if(board[i][j] == 1 && player == 0) { //white pawn
            System.out.println("pawn selected");
            piece=1;
            valid=true;
        }
        if(board[i][j] == 11 && player == 1) { //black pawn
            System.out.println("pawn selected");
            piece=1;
            valid=true;
        }
        if(board[i][j] == 2 && player == 0) { //white knight
            System.out.println("knight selected");
            piece=2;
            valid=true;
        }
        if(board[i][j] == 12 && player == 1) { //black knight
            System.out.println("knight selected");
            piece=2;
            valid=true;
        }
        if(board[i][j] == 3 && player == 0) { //white bishop
            System.out.println("bishop selected");
            piece=3;
            valid=true;
        }
        if(board[i][j] == 13 && player == 1) { //black bishop
            System.out.println("bishop selected");
            piece=3;
            valid=true;
        }
        if(board[i][j] == 4 && player == 0) { //white rook
            System.out.println("rook selected");
            piece=4;
            valid=true;
        }
        if(board[i][j] == 14 && player == 1) { //black rook
            System.out.println("rook selected");
            piece=4;
            valid=true;
        }
        if(board[i][j] == 5 && player == 0) { //white queen
            System.out.println("queen selected");
            piece=5;
            valid=true;
        }
        if(board[i][j] == 15 && player == 1) { //black queen
            System.out.println("queen selected");
            piece=5;
            valid=true;
        }
        if(board[i][j] == 6 && player == 0) { //white king
            System.out.println("king selected");
            piece=6;
            valid=true;
        }
        if(board[i][j] == 16 && player == 1) { //black king
            System.out.println("king selected");
            piece=6;
            valid=true;
        }
        if(!valid){
            System.out.println("No piece selected, try again");
            return false;
        }
        if(valid){
            System.out.println("Move piece, or press p to pick a new piece");
            move = scanner.nextLine().toCharArray();
            if(move.length > 0){
                if(move[0] == 'p'){
                    System.out.println("Choose a piece");
                    return false;
                }
            }
            while(!isValid(board, i, j, move, player, piece)){
                move = scanner.nextLine().toCharArray();
                if(move.length > 0){
                    if(move[0] == 'p'){
                        System.out.println("Choose a piece");
                        return false;
                    }
                }

            }
        }
        return true;
    }
}
