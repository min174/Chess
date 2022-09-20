import java.util.Scanner;
public class Main {
    static char[] input;
    static int[][] board = {{14, 12, 13, 15, 16, 13, 12, 14},
                            {11, 11, 11, 11, 11, 11, 11, 11},
                            { 0,  0,  0,  0,  0,  0,  0,  0},
                            { 0,  0,  0,  0,  0,  0,  0,  0},
                            { 0,  0,  0,  0,  0,  0,  0,  0},
                            { 0,  0,  0,  0,  0,  0,  0,  0},
                            { 1,  1,  1,  1,  1,  1,  1,  1},
                            { 4,  2,  3,  5,  6,  3,  2,  4}};
    public static void main(String[] args) {
        System.out.println("###############\n#####CHESS#####\n###############\n");
        Player p = new Player();

        p.start();
        
        Scanner scanner = new Scanner(System.in);

        printboard.print(board);

        while(true) {
            if(move.check(board, 0) == 2) {
                System.out.println("Checkmate! " + Player.p2 + "wins!");
                break;
            }
            System.out.println(Player.p1 + ", choose a piece");
            input = scanner.nextLine().toCharArray();
            while(!move.selection(board, input, 0)){
                input = scanner.nextLine().toCharArray();
            }
            move.promotion(board, 0);
            printboard.print(board);

            if(move.check(board, 1) == 2) {
                System.out.println("Checkmate! " + Player.p1 + "wins!");
                break;
            }
            System.out.println(Player.p2 + ", choose a piece");
            input = scanner.nextLine().toCharArray();
            while(!move.selection(board, input, 1)){
                input = scanner.nextLine().toCharArray();
            }
            move.promotion(board, 1);
            printboard.print(board);
        }
    }
}
