package ru.job4j.chess.firuges.exceptions;

public class WrongMoveException extends RuntimeException {
    public WrongMoveException(String msg) {
        super(msg);
    }
}
