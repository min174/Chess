import java.util.Scanner;

public class input {
    static char[] input;

    public static int[] choosepiece() { //takes char array and converts it to board position
        Scanner scanner = new Scanner(System.in);

        while(true) {
            input = scanner.nextLine().toCharArray();
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
}
