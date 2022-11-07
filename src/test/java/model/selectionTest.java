package model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class selectionTest {

    @Test
    void selection() {
        game g = new game();
        int p = 1; //expected piece (pawn)
        int[] i = {6,0}; //piece location (white pawn)

        g.player = 0;
        g.selection(i);
        assertEquals(p,g.piece);
    }
}