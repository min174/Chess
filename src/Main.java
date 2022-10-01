import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        System.out.println("###############\n#####CHESS#####\n###############\n");
        Player p = new Player();

        p.start();

        Scanner scanner = new Scanner(System.in);

        view.board();

        while(true) {
            if(move.check(0) == 2) {
                System.out.println("Checkmate! " + Player.p2 + "wins!");
                break;
            }

            System.out.println(Player.p1 + ", choose a piece");

            move.selection(input.choosepiece(), 0);

            move.promotion(0);
            view.board();

            if(move.check(1) == 2) {
                System.out.println("Checkmate! " + Player.p1 + "wins!");
                break;
            }

            System.out.println(Player.p2 + ", choose a piece");

            move.selection(input.choosepiece(), 1);

            move.promotion(1);
            view.board();
        }
    }
}
