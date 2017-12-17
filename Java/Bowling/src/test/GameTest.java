/*
 * Copyright (c) 2017. Helge Stenström
 */

package test;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import helge.Game;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {
    Game g;

    @BeforeEach
    void setUp() {
        g = new Game();
    }

    private void rollMany(int n, int pins) {
        for (int i = 0; i < n; i++) {
            g.roll(pins);
        }
    }

    private void rollSpare() {
        g.roll(5);
        g.roll(5); // Spare
    }

    private void rollStike() {
        g.roll(10);
    }

    @Test
    void gutterGame() {
        rollMany(20, 0);
        assertEquals(0, g.score());
    }

    @Test
    void allOnes() {
        rollMany(20, 1);
        assertEquals(20, g.score());
    }
    @Test
    void oneSpare() {
        rollSpare();
        g.roll(3);
        rollMany(17, 0);
        assertEquals(10+3+3, g.score());
    }

    @Test
    void oneStrike() {
        rollStike(); // Strike  https://en.wikipedia.org/wiki/Strike_(bowling)
        g.roll(3);
        g.roll(4);
        rollMany(16, 0);
        assertEquals((10+3+4) + (3 + 4), g.score());
    }

    @Test
    void perfectGame() {
        rollMany(12, 10);
        assertEquals(300, g.score());
    }
}
