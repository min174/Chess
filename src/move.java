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

        //bishop////////////////////////////////////////////////////////////////////////////////////////////////////////
        if(piece==3){
            a=i;
            b=j;
            while(true){
                if(x<i && y<j){
                    if(a==0 || b==0){
                        break;
                    }
                    a--;
                    b--;
                }
                if(x<i && y>j){
                    if(a==0 || b==7){
                        break;
                    }
                    a--;
                    b++;
                }
                if(x>i && y<j){
                    if(a==7 || b==0){
                        break;
                    }
                    a++;
                    b--;
                }
                if(x>i && y>j){
                    if(a==7 || b==7){
                        break;
                    }
                    a++;
                    b++;
                }

                if(board[a][b]==0){
                    if(a==x && b==y){
                        board[x][y]=3;
                        if(player==1){
                            board[x][y]+=10;
                        }
                        board[i][j]=0;
                        valid=true;
                        break;
                    }
                    continue;
                }
                if(board[a][b]<10 && player==0){
                    break;
                }
                if(board[a][b]>10 && player==1){
                    break;
                }
                if(board[a][b]<10 && player==1){
                    if(a==x && b==y){
                        board[x][y]=13;
                        board[i][j]=0;
                        valid=true;
                    }
                    break;
                }
                if(board[a][b]>10 && player==0){
                    if(a==x && b==y){
                        board[x][y]=3;
                        board[i][j]=0;
                        valid=true;
                    }
                    break;
                }
            }
        }

        //rook//////////////////////////////////////////////////////////////////////////////////////////////////////////
        if(piece==4){
            a=i;
            b=j;
            while(true){
                if(x<i && y==j){
                    if(a==0){
                        break;
                    }
                    a--;
                }
                if(x>i && y==j){
                    if(a==7){
                        break;
                    }
                    a++;
                }
                if(x==i && y<j){
                    if(b==0){
                        break;
                    }
                    b--;
                }
                if(x==i && y>j){
                    if(b==7){
                        break;
                    }
                    b++;
                }

                if(board[a][b]==0){
                    if(a==x && b==y){
                        board[x][y]=4;
                        if(player==1){
                            board[x][y]+=10;
                        }
                        board[i][j]=0;
                        valid=true;
                        break;
                    }
                    continue;
                }
                if(board[a][b]<10 && player==0){
                    break;
                }
                if(board[a][b]>10 && player==1){
                    break;
                }
                if(board[a][b]<10 && player==1){
                    if(a==x && b==y){
                        board[x][y]=14;
                        board[i][j]=0;
                        valid=true;
                    }
                    break;
                }
                if(board[a][b]>10 && player==0){
                    if(a==x && b==y){
                        board[x][y]=4;
                        board[i][j]=0;
                        valid=true;
                    }
                    break;
                }
            }
        }

        //queen//////////////////////////////////////////////////////////////////////////////////////////////////////////
        if(piece==5){
            a=i;
            b=j;
            if(x==i || y==j){
                while(true){
                    if(x<i && y==j){
                        if(a==0){
                            break;
                        }
                        a--;
                    }
                    if(x>i && y==j){
                        if(a==7){
                            break;
                        }
                        a++;
                    }
                    if(x==i && y<j){
                        if(b==0){
                            break;
                        }
                        b--;
                    }
                    if(x==i && y>j){
                        if(b==7){
                            break;
                        }
                        b++;
                    }

                    if(board[a][b]==0){
                        if(a==x && b==y){
                            board[x][y]=5;
                            if(player==1){
                                board[x][y]+=10;
                            }
                            board[i][j]=0;
                            valid=true;
                            break;
                        }
                        continue;
                    }
                    if(board[a][b]<10 && player==0){
                        break;
                    }
                    if(board[a][b]>10 && player==1){
                        break;
                    }
                    if(board[a][b]<10 && player==1){
                        if(a==x && b==y){
                            board[x][y]=15;
                            board[i][j]=0;
                            valid=true;
                        }
                        break;
                    }
                    if(board[a][b]>10 && player==0){
                        if(a==x && b==y){
                            board[x][y]=5;
                            board[i][j]=0;
                            valid=true;
                        }
                        break;
                    }
                }
            } else{
                while(true){
                    if(x<i && y<j){
                        if(a==0 || b==0){
                            break;
                        }
                        a--;
                        b--;
                    }
                    if(x<i && y>j){
                        if(a==0 || b==7){
                            break;
                        }
                        a--;
                        b++;
                    }
                    if(x>i && y<j){
                        if(a==7 || b==0){
                            break;
                        }
                        a++;
                        b--;
                    }
                    if(x>i && y>j){
                        if(a==7 || b==7){
                            break;
                        }
                        a++;
                        b++;
                    }

                    if(board[a][b]==0){
                        if(a==x && b==y){
                            board[x][y]=5;
                            if(player==1){
                                board[x][y]+=10;
                            }
                            board[i][j]=0;
                            valid=true;
                            break;
                        }
                        continue;
                    }
                    if(board[a][b]<10 && player==0){
                        break;
                    }
                    if(board[a][b]>10 && player==1){
                        break;
                    }
                    if(board[a][b]<10 && player==1){
                        if(a==x && b==y){
                            board[x][y]=15;
                            board[i][j]=0;
                            valid=true;
                        }
                        break;
                    }
                    if(board[a][b]>10 && player==0){
                        if(a==x && b==y){
                            board[x][y]=5;
                            board[i][j]=0;
                            valid=true;
                        }
                        break;
                    }
                }
            }
        }

        //king//////////////////////////////////////////////////////////////////////////////////////////////////////////
        if(piece==6){
            if(player == 0 && i == 7 && j == 4) { //castling rules
                if(x == 7 && y == 6 && board[7][5] == 0 && board[7][6] == 0 && board[7][7] == 4) {
                    board[7][4] = 0;
                    board[7][5] = 4;
                    board[7][6] = 6;
                    board[7][7] = 0;
                    return true;
                }
                if(x == 7 && y == 2 && board[7][3] == 0 && board[7][2] == 0 && board[7][1] == 0 && board[7][0] == 4) {
                    board[7][0] = 0;
                    board[7][2] = 6;
                    board[7][3] = 4;
                    board[7][4] = 0;
                    return true;
                }
            }
            if(player == 1 && i == 0 && j == 4) {
                if(x == 0 && y == 6 && board[0][5] == 0 && board[0][6] == 0 && board[0][7] == 14) {
                    board[0][4] = 0;
                    board[0][5] = 14;
                    board[0][6] = 16;
                    board[0][7] = 0;
                    return true;
                }
                if(x == 0 && y == 2 && board[0][3] == 0 && board[0][2] == 0 && board[0][1] == 0 && board[0][0] == 14) {
                    board[0][0] = 0;
                    board[0][2] = 16;
                    board[0][3] = 14;
                    board[0][4] = 0;
                    return true;
                }
            }
            if( (x==(i-1) || x==(i+1) || x==i) && (y==(j-1) || y==(j+1) || y==j) && !(x==i && y==j) ){
                if(player==0){
                    if(board[x][y]==0 || board[x][y]>10){
                        if(attacked(board, x, y, 0)){
                            System.out.println("***** You cannot move your king into check *****");
                            return false;
                        } else{
                            board[x][y]=6;
                            board[i][j]=0;
                            valid=true;
                        }
                    }
                }
                if(player==1){
                    if(board[x][y]==0 || board[x][y]<10){
                        if(attacked(board, x, y, 1)){
                            System.out.println("***** You cannot move your king into check *****");
                            return false;
                        } else{
                            board[x][y]=16;
                            board[i][j]=0;
                            valid=true;
                        }
                    }
                }
            }
        }
        
        if(!valid){
            System.out.println("***** Not a valid move! Please try again! *****");
        }
        return valid;
    }

    public static boolean attacked(int board[][], int i, int j, int player){
        int a, b;

        if(i > 0){ //if the spot above [i][j] is an enemy king, [i][j] is attacked
            if((player == 0 && board[i-1][j] == 16) || (player == 1 && board[i-1][j] == 6)){
                return true;
            }
        }
        if(i < 7){ //if the spot below [i][j] is an enemy king, [i][j] is attacked
            if((player == 0 && board[i+1][j] == 16) || (player == 1 && board[i+1][j] == 6)){
                return true;
            }
        }
        if(j > 0){ //left
            if((player == 0 && board[i][j-1] == 16) || (player == 1 && board[i][j-1] == 6)){
                return true;
            }
        }
        if(j < 7){ //right
            if((player == 0 && board[i][j+1] == 16) || (player == 1 && board[i][j+1] == 6)){
                return true;
            }
        }
        if(i > 0 && j > 0){ //above and to the left is enemy king, or, if player is white, a black pawn
            if((player == 0 && (board[i-1][j-1] == 16 || board[i-1][j-1] == 11)) || (player == 1 && board[i-1][j-1] == 6)){
                return true;
            }
        }
        if(i > 0 && j < 7){ //above and to the right is king or pawn
            if((player == 0 && (board[i-1][j+1] == 16 || board[i-1][j+1] == 11)) || (player == 1 && board[i-1][j+1] == 6)){
                return true;
            }
        }
        if(i < 7 && j > 0){ //down and to the left, pawn if player is black
            if((player == 0 && board[i+1][j-1] == 16) || (player == 1 && (board[i+1][j-1] == 6 || board[i+1][j-1] == 1))){
                return true;
            }
        }
        if(i < 7 && j < 7){ //down and to the right
            if((player == 0 && board[i+1][j+1] == 16) || (player == 1 && (board[i+1][j+1] == 6 || board[i+1][j+1] == 1))){
                return true;
            }
        }
        //knight detection
        if(i > 1 && j > 0){ //up left
            if((player == 0 && board[i-2][j-1] == 12) || (player == 1 && board[i-2][j-1] == 2)){
                return true;
            }
        }
        if(i > 1 && j < 7){ //up right
            if((player == 0 && board[i-2][j+1] == 12) || (player == 1 && board[i-2][j+1] == 2)){
                return true;
            }
        }
        if(i > 0 && j < 6){ //right up
            if((player == 0 && board[i-1][j+2] == 12) || (player == 1 && board[i-1][j+2] == 2)){
                return true;
            }
        }
        if(i > 0 && j > 1){ //left up
            if((player == 0 && board[i-1][j-2] == 12) || (player == 1 && board[i-1][j-2] == 2)){
                return true;
            }
        }
        if(i < 7 && j < 6){ //right down
            if((player == 0 && board[i+1][j+2] == 12) || (player == 1 && board[i+1][j+2] == 2)){
                return true;
            }
        }
        if(i < 7 && j > 1){ //left down
            if((player == 0 && board[i+1][j-2] == 12) || (player == 1 && board[i+1][j-2] == 2)){
                return true;
            }
        }
        if(i < 6 && j > 0){ //down left
            if((player == 0 && board[i+2][j-1] == 12) || (player == 1 && board[i+2][j-1] == 2)){
                return true;
            }
        }
        if(i < 6 && j < 7){ //down right
            if((player == 0 && board[i+2][j+1] == 12) || (player == 1 && board[i+2][j+1] == 2)){
                return true;
            }
        }

        for(int k=0; k<4; k++){ //different k values are cases for the 4 directions
            a=i;
            b=j;
            while(true){
                if(k == 0){ //go one square up until the top row is hit
                    if(a == 0){
                        break;
                    }
                    a--;
                }
                if(k == 1){ //go one square down until the bottom row is hit
                    if(a == 7){
                        break;
                    }
                    a++;
                }
                if(k == 2){ //go one square left until the leftmost column is hit
                    if(b == 0){
                        break;
                    }
                    b--;
                }
                if(k == 3){ //go one square right until the rightmost column is hit
                    if(b == 7){
                        break;
                    }
                    b++;
                }

                if(board[a][b] == 0){ //if the square is blank check the next one
                    continue;
                }
                if(board[a][b] == 1 || board[a][b] == 11 || board[a][b] == 2 || board[a][b] == 12 || board[a][b] == 3 || board[a][b] == 13 || board[a][b] == 6 || board[a][b] == 16){
                    break; //if the square has a pawn, knight, bishop, or king, break (king won't be on adjacent square as that was checked for at the beginning)
                }
                if(player == 0 && board[a][b] < 10){ //if the square has a friendly piece on it, break
                    break;
                }
                if(player == 1 && board[a][b] > 10){
                    break;
                }
                if(player == 0 && (board[a][b] == 14 || board[a][b] == 15)){ //if the square has an enemy rook or queen on it, the square being checked is attacked
                    return true;
                }
                if(player == 1 && (board[a][b] == 4 || board[a][b] == 5)){
                    return true;
                }
            }
        }

        //do another version of the above loop for diagonal movement
        for(int k=0; k<4; k++){
            a=i;
            b=j;
            while(true){
                if(k == 0){
                    if(a == 0 || b == 0){
                        break;
                    }
                    a--;
                    b--;
                }
                if(k == 1){
                    if(a == 0 || b == 7){
                        break;
                    }
                    a--;
                    b++;
                }
                if(k == 2){
                    if(a == 7 || b == 0){
                        break;
                    }
                    a++;
                    b--;
                }
                if(k == 3){
                    if(a == 7 || b == 7){
                        break;
                    }
                    a++;
                    b++;
                }

                if(board[a][b] == 0){ //if the square is blank check the next one
                    continue;
                }
                if(board[a][b] == 1 || board[a][b] == 11 || board[a][b] == 2 || board[a][b] == 12 || board[a][b] == 4 || board[a][b] == 14 || board[a][b] == 6 || board[a][b] == 16){
                    break; //if the square has a pawn, knight, rook, or king, break
                }
                if(player == 0 && board[a][b] < 10){ //if the square has a friendly piece on it, break
                    break;
                }
                if(player == 1 && board[a][b] > 10){
                    break;
                }
                if(player == 0 && (board[a][b] == 13 || board[a][b] == 15)){ //if the square has an enemy bishop or queen on it, the square being checked is attacked
                    return true;
                }
                if(player == 1 && (board[a][b] == 3 || board[a][b] == 5)){
                    return true;
                }
            }
        }
        return false;
    }
}
