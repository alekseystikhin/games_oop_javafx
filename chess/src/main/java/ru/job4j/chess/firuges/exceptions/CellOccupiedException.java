package ru.job4j.chess.firuges.exceptions;

public class CellOccupiedException extends RuntimeException {
    public CellOccupiedException(String msg) {
        super(msg);
    }
}
