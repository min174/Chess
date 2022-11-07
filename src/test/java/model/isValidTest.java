package model;

import org.junit.Before;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static model.game.isValid;
import static org.junit.jupiter.api.Assertions.*;

class isValidTest {

    @Test
    void pawnPlayer2ValidMove(){
        game g = new game();

        int[] piecePosition = {1,4}; // black pawn
        int[] move = {2,4};
        g.player = 1;
        g.piece =1;

        assertEquals(1, isValid(piecePosition,move));
    }

    @Test
    void pawnPlayer1InvalidMove(){
        game g = new game();

        int[] piecePosition = {6,4}; // white pawn
        int[] move = {0,0};
        g.player = 0;
        g.piece = 1;

        assertEquals(0, isValid(piecePosition,move));
    }

    @Test
    void knightPlayer1ValidMove(){
        game g = new game();

        int[] piecePosition = {7,1}; //white knight
        int[] move = {5,0};
        g.player = 0;
        g.piece = 2;

        assertEquals(1, isValid(piecePosition,move));
    }

    @Test
    void knightPlayer2InvalidMove(){
        game g = new game();

        int[] piecePosition = {0,1}; //black knight
        int[] move = {5,5};
        g.player = 1;
        g.piece = 2;

        assertEquals(0, isValid(piecePosition,move));
    }

    @Nested
    class bishopTest{

        @Test
        void bishopPlayer1ValidMove(){
            game g = new game();

            g.player = 0;
            g.piece = 3;

            for(int i=0;i<8;i++){
                for(int j=0;j<8;j++){
                    g.board[i][j]=0;
                }
            }

            int[] piecePosition = {0,2}; //black bishop
            g.board[0][2]=3;
            int[] move = {2,4}; //correct

            assertEquals(1, isValid(piecePosition,move));

        }

        @Test
        void bishopPlayer2InValidMove(){
            game g = new game();

            g.player = 1;
            g.piece = 13;

            int[] piecePosition = {7,2}; //white bishop
            g.board[7][2]=13;
            int[] move = {7,3}; //incorrect

            assertEquals(0, isValid(piecePosition,move));
        }
    }

    @Nested
    class rookTest{

        @Test
        void rookPlayer1ValidMove(){
            game g = new game();

            g.player = 0;
            g.piece = 4;

            for(int i=0;i<8;i++){
                for(int j=0;j<8;j++){
                    g.board[i][j]=0;
                }
            }

            int[] piecePosition = {0,7}; //white rook
            g.board[0][7]=4;
            int[] move = {3,7}; //correct

            assertEquals(1, isValid(piecePosition,move));

        }

        @Test
        void rookPlayer2InvalidMove(){
            game g = new game();

            g.player = 1;
            g.piece = 14;

            for(int i=0;i<8;i++){
                for(int j=0;j<8;j++){
                    g.board[i][j]=0;
                }
            }

            int[] piecePosition = {7,0}; //black rook
            g.board[7][0]=4;
            int[] move = {3,7}; //incorrect

            assertEquals(0, isValid(piecePosition,move));
        }
    }

    @Nested
    class kingTest{
        @Test
        void kingPlayer1ValidMove(){
            game g = new game();

            g.player = 0;
            g.piece = 6;

            for(int i=0;i<8;i++){
                for(int j=0;j<8;j++){
                    g.board[i][j]=0;
                }
            }

            int[] piecePosition = {7,4}; //white king
            g.board[7][4]=6;
            int[] move = {6,4}; //correct

            assertEquals(1, isValid(piecePosition,move));
        }

        @Test
        void kingPlayer2InvalidMove(){
            game g = new game();

            g.player = 1;
            g.piece = 16;

            int[] piecePosition = {0,4}; //black king
            g.board[0][4]=16;
            int[] move = {0,0}; //incorrect

            assertEquals(0, isValid(piecePosition,move));
        }
    }

    @Nested
    class queenTest{
        @Test
        void queenPlayer1ValidMove(){
            game g = new game();

            g.player = 0;
            g.piece = 5;

            for(int i=0;i<8;i++){
                for(int j=0;j<8;j++){
                    g.board[i][j]=0;
                }
            }

            int[] piecePosition = {7,3}; //white queen
            g.board[7][3]=5;
            int[] move = {3,3}; //correct

            assertEquals(1, isValid(piecePosition,move));
        }

        @Test
        void queenPlayer2InvalidMove(){
            game g = new game();

            g.player = 1;
            g.piece = 15;

            int[] piecePosition = {0,3}; //black queen
            g.board[0][3]=15;
            int[] move = {4,4}; //incorrect

            assertEquals(0, isValid(piecePosition,move));
        }
    }

}