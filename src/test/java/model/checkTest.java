package model;

import org.junit.Before;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static model.game.check;

class checkTest {

    @Test
    void checkmateTest() {
        game g = new game();

        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                g.board[i][j]=0;
            }
        }

        g.board[0][4]=16;
        g.board[7][4]=6;
        g.board[0][0]=4;
        g.board[1][7]=4;

        assertEquals(2,check(1));
    }

    @Test
    void checkTest(){
        game g = new game();

        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                g.board[i][j]=0;
            }
        }

        g.board[7][4]=6;
        g.board[7][0]=14;

        assertEquals(1,check(0));
    }

}