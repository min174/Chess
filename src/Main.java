import java.util.Scanner;
public class Main {
    static int i, j;
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

        System.out.println("Choose a piece");
        input = scanner.nextLine().toCharArray();
        printboard.selection(board, input, 0);
    }
}
