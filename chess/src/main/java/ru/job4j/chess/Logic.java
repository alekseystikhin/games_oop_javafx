package ru.job4j.chess;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
import ru.job4j.chess.firuges.exceptions.CellOccupiedException;
import ru.job4j.chess.firuges.exceptions.FigureNotFoundException;

import java.util.Arrays;

/**
 * Логика движения фигур
 *
 * @author Aleksey Stikhin
 * @version 1.0
 * @since 30.10.2019
 */
public class Logic {
    private final Figure[] figures = new Figure[32];
    private int index = 0;

    public void add(Figure figure) {
        this.figures[this.index++] = figure;
    }

    public boolean move(Cell source, Cell dest) throws IllegalStateException {
        boolean rst = false;
        int index = this.findBy(source);
        int target = this.findBy(dest);
        if (index == -1) {
            throw new FigureNotFoundException("Figure not found");
        }
        Cell[] steps = this.figures[index].way(source, dest);
        for (int step = 0; step < steps.length; step++) {
            int empty = findBy(steps[step]);
            if (empty != -1 || target != -1) {
                throw new CellOccupiedException("Cell occupied");
            }
        }
        if (steps.length > 0 && steps[steps.length - 1].equals(dest)) {
            rst = true;
            this.figures[index] = this.figures[index].copy(dest);
        }

        return rst;
    }

    public void clean() {
        for (int position = 0; position != this.figures.length; position++) {
            this.figures[position] = null;
        }
        this.index = 0;
    }

    public int findBy(Cell cell) {
        int rst = -1;
        for (int index = 0; index != this.figures.length; index++) {
            if (this.figures[index] != null && this.figures[index].position().equals(cell)) {
                rst = index;
                break;
            }
        }
        return rst;
    }

    @Override
    public String toString() {
        return "Logic{" +
                "figures=" + Arrays.toString(this.figures) +
                '}';
    }
}
