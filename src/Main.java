public class Main {

    public static void main(String[] args) {
        view.welcome();

        Player p = new Player();
        p.start();

        view.board();

        while(true) {
            if(move.check(0) == 2) {
                view.checkmate(0);
                break;
            }

            view.choosePiece(0);
            move.selection(input.choosePiece(), 0);

            move.promotion(0);
            view.board();


            if(move.check(1) == 2) {
                view.checkmate(1);
                break;
            }

            view.choosePiece(1);
            move.selection(input.choosePiece(), 1);

            move.promotion(1);
            view.board();
        }
    }
}
