package ru.job4j.chess.firuges.black;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
import ru.job4j.chess.firuges.exceptions.WrongMoveException;

/**
 * @author Aleksey Stikhin
 * @version 1.0
 * @since 30.10.2019
 */
public class BishopBlack implements Figure {
    private final Cell position;

    public BishopBlack(final Cell position) {
        this.position = position;
    }

    @Override
    public Cell position() {
        return this.position;
    }

    @Override
    public Cell[] way(Cell source, Cell dest) {
        if (!isDiagonal(source, dest)) {
            throw new WrongMoveException("Wrong move exception");
        }
        Cell[] steps = new Cell[Math.abs(source.x - dest.x)];
        int deltaX = Integer.compare(source.x, dest.x);
        int deltaY = Integer.compare(source.y, dest.y);
        for (int index = 0; index < steps.length; index++) {
            steps[index] = Cell.values()[(8 * (source.x - deltaX)) + (source.y - deltaY)];
            deltaX = deltaX > 0 ? deltaX + 1 : deltaX - 1;
            deltaY = deltaY > 0 ? deltaY + 1 : deltaY - 1;
        }
        return steps;
    }

    public boolean isDiagonal(Cell source, Cell dest) {
        boolean result = true;
        if (Math.abs(dest.x - source.x) != Math.abs(dest.y - source.y)) {
            result = false;
        }
        return result;
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }
}
