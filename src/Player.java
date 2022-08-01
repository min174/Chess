import java.util.Scanner;

public class Player {
    String p1, p2;

    void start(){
        Scanner s = new Scanner(System.in);

        System.out.println("\n~~~Please enter the names of the players~~~");
        System.out.println("Player 1 (Black): ");
        p1 = s.next();
        System.out.println("\nPlayer 2 (White): ");
        p2 = s.next();
    }
}
