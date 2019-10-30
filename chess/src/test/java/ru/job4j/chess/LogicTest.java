package ru.job4j.chess;

import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.black.BishopBlack;
import ru.job4j.chess.firuges.exceptions.FigureNotFoundException;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class LogicTest {
    private final Logic logic = new Logic();

    /**
     * Тест, когда фигура не найдена.
     */
    @Test
    public void testFigureNotFound() throws FigureNotFoundException {
        try {
            logic.move(Cell.D3, Cell.E3);
        } catch (FigureNotFoundException ex) {
            assertThat(logic.findBy(Cell.D3), is(-1));
            assertThat(logic.findBy(Cell.E3), is(-1));
        }
    }

    /**
     * Тест, когда ячейка занята.
     */
    @Test
    public void testCellOccupied() {
        try {
            logic.add(new BishopBlack(Cell.H3));
            logic.move(Cell.H3, Cell.F5);
        } catch (IllegalStateException ex) {
            assertThat(ex.getMessage(), is("Cell occupied"));
        }
    }

    /**
     * Тест, ходы фигуры.
     */
    @Test
    public void testFigureSteps() {
        BishopBlack bishopBlack = new BishopBlack(Cell.F8);
        Cell[] expected = {Cell.E7, Cell.D6};
        Cell[] result = bishopBlack.way(Cell.F8, Cell.D6);
        assertThat(result, is(expected));
    }

    /**
     * Тест, ход вниз влево.
     */
    @Test
    public void testLeftDown() {
        logic.add(new BishopBlack(Cell.F8));
        boolean result = logic.move(Cell.F8, Cell.D6);
        assertThat(result, is(true));
    }

    /**
     * Тест, ход вверх вправо.
     */
    @Test
    public void testRightUp() {
        logic.add(new BishopBlack(Cell.D6));
        boolean result = logic.move(Cell.D6, Cell.F8);
        assertThat(result, is(true));
    }
}