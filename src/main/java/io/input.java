package main.java;
import java.util.Scanner;

public class input {
    static char[] input;

    public static int[] boardSquare() { //takes char array and converts it to board position
        Scanner scanner = new Scanner(System.in);

        while(true) {
            input = scanner.nextLine().toCharArray();
            if(input.length == 1 && input[0] == 'p') {
                return new int[]{-1, 0};
            }
            if(input.length != 2){
                System.out.println("Input not 2 chars, try again");
                continue;
            }
            if(input[0]<97 || input[0]>104 || input[1]<49 || input[1]>56) { //if input is not [a-h][1-8]
                System.out.println("Not valid board space, try again");
                continue;
            }
            break;
        }

        return new int[]{7-(input[1]-49), input[0]-97};
    }

    public static void promotion() {
        for(int j=0; j<8; j++) {
            if((move.player == 0 && move.board[0][j] == 1) || (move.player == 1 && move.board[7][j] == 11)) {
                System.out.println("Please enter a number to promote your pawn\n1-Knight  2-Bishop  3-Rook  4-Queen");
                Scanner scanner = new Scanner(System.in);
                int input=0;
                while(true) {
                    input = scanner.nextInt();
                    if(input < 1 || input > 4) {
                        System.out.println("please enter a number from 1 to 4");
                    } else {
                        break;
                    }
                }
                input++;
                if(move.player == 0) {
                    move.board[0][j] = input;
                }
                if(move.player == 1) {
                    input += 10;
                    move.board[7][j] = input;
                }
                return;
            }
        }
    }

}
