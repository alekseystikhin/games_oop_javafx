package ru.job4j.chess.figures.black;

import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.black.BishopBlack;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class BishopBlackTest {


    @Test
    public void testPosition() {
        BishopBlack bishopBlack = new BishopBlack(Cell.F8);
        assertEquals(Cell.F8, bishopBlack.position());
    }

    @Test
    public void testCopy() {
        BishopBlack bishopBlack = new BishopBlack(Cell.F8);
        assertEquals(Cell.D6, bishopBlack.copy(Cell.D6).position());
    }

    @Test
    public void testWay() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        Cell[] cells = bishopBlack.way(Cell.C1, Cell.G5);
        assertThat(cells, is(new Cell[]{Cell.D2, Cell.E3, Cell.F4, Cell.G5}));
    }
}
