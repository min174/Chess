package main.java;
import java.util.Scanner;

public class Player {
    static String p1, p2;

    void start(){
        Scanner s = new Scanner(System.in);

        System.out.println("Player 1 (White): ");
        p1 = s.next();
        System.out.println("\nPlayer 2 (Black): ");
        p2 = s.next();
    }
}
