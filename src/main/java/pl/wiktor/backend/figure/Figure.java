package pl.wiktor.backend.figure;

import pl.wiktor.backend.move.Move;

public class Figure {
    private FigureType figureType;
    private Move moves;

    public Figure(FigureType figureType, Move moves) {
        this.figureType = figureType;
        this.moves = moves;
    }

    public FigureType getFigureType() {
        return figureType;
    }

    public Move getMoves() {
        return moves;
    }
}
