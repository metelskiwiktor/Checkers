package pl.wiktor.backend.figure;

import pl.wiktor.backend.move.Move;

public class Figure {
    private FigureType figureType;
    private Move moves;

    public FigureType getFigureType() {
        return figureType;
    }

    public Move getMoves() {
        return moves;
    }
}
