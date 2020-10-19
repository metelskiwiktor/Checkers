package pl.wiktor.backend.player;

import pl.wiktor.backend.board.Field;
import pl.wiktor.backend.figure.Figure;

public class FieldView {
    private final Figure figure;
    private final PlayerType playerType;
    private final Field field;

    public FieldView(Figure figure, PlayerType playerType, Field field) {
        this.figure = figure;
        this.playerType = playerType;
        this.field = field;
    }

    public Figure getFigure() {
        return figure;
    }

    public PlayerType getPlayerType() {
        return playerType;
    }

    public Field getField() {
        return field;
    }
}
