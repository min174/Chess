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

    public static boolean isValid(int board[][], int i, int j, char move[], int player, int piece){
        if(move.length!=2){
            System.out.println("***** You must input 2 chars! Please try again! *****");
            return false;
        }
    
        boolean valid = false;
        int x, y, a=move[0], b=move[1];
        y=a-97; //converting move chars to board index
        x=7-(b-49);
    
        if(a<97 || a>104 || b<49 || b>56){ //if input is not [a-h][1-8]
            System.out.println("***** This is not a valid board space! Please try again! *****");
            return false;
        }
    
        //pawn//////////////////////////////////////////////////////////////////////////////////////////////////////////
        if(piece==1 && player==0){ //if white chose a pawn
            if(j==y && x==(i-1)){ //if it is being moved one space forward
                if(board[x][y]==0){ //if the space is free
                    board[x][y]=1;
                    board[i][j]=0;
                    valid=true;
                }
            }
            if(i==6 && j==y && x==(i-2)){ //if the pawn hasn't been moved yet and is being moved 2 spaces forward
                if(board[x][y]==0 && board[x+1][y]==0){ //if both spaces in front of it are free
                    board[x][y]=1;
                    board[i][j]=0;
                    valid =true;
                }
            }
            if((y==(j-1) || y==(j+1)) && x==(i-1)){ //if moving up-left or up-right
                if(board[x][y]>10){ //if space has a black piece
                    board[x][y]=1;
                    board[i][j]=0;
                    valid=true;
                }
            }
        }
        if(piece==1 && player==1){ //if black chose a pawn
            if(j==y && x==(i+1)){ //if it is being moved one space down
                if(board[x][y]==0){ //if the space is free
                    board[x][y]=11;
                    board[i][j]=0;
                    valid=true;
                }
            }
            if(i==1 && j==y && x==(i+2)){ //if the pawn hasn't been moved yet and is being moved 2 spaces forward
                if(board[x][y]==0 && board[x-1][y]==0){ //if both spaces in front of it are free
                    board[x][y]=11;
                    board[i][j]=0;
                    valid=true;
                }
            }
            if((y==(j-1) || y==(j+1)) && x==(i+1)){ //if moving up-left or up-right
                if(board[x][y]<10){ //if space has a white piece
                    board[x][y]=11;
                    board[i][j]=0;
                    valid=true;
                }
            }
        }
    
        //knight////////////////////////////////////////////////////////////////////////////////////////////////////////
        if(piece==2){
            if(( (x==(i-2) || x==(i+2)) && (y==(j-1) || y==(j+1)) ) || ((x==(i-1) || x==(i+1)) && (y==(j-2) || y==(j+2)))){
                if(player==0){
                    if(board[x][y]==0 || board[x][y]>10){
                        board[x][y]=2;
                        board[i][j]=0;
                        valid=true;
                    }
                }
                if(player==1){
                    if(board[x][y]==0 || board[x][y]<10){
                        board[x][y]=12;
                        board[i][j]=0;
                        valid=true;
                    }
                }
            }
        }
        if(!valid){
            System.out.println("***** Not a valid move! Please try again! *****");
        }
        return valid;
    }
}
