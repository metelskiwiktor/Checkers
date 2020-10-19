package pl.wiktor.backend.moves.possible;

import pl.wiktor.backend.board.Field;

abstract class PiecePossibleMoveTestTemplate {
    private int x;
    private int y;

    protected void loadStandingParameters(int x, int y) {
        this.x = x;
        this.y = y;
    }

    protected Field field() {
        return new Field(x, y);
    }

    protected Field leftUpOneField() {
        return new Field(x - 1, y + 1);
    }

    protected Field leftUpTwoFields() {
        return new Field(x - 2, y + 2);
    }

    protected Field leftUpThreeFields() {
        return new Field(x - 3, y + 3);
    }

    protected Field rightUpOneField() {
        return new Field(x + 1, y + 1);
    }

    protected Field rightUpTwoFields() {
        return new Field(x + 2, y + 2);
    }

    protected Field rightUpThreeFields() {
        return new Field(x + 3, y + 3);
    }

    protected Field leftDownOneField() {
        return new Field(x - 1, y - 1);
    }

    protected Field leftDownTwoFields() {
        return new Field(x - 2, y - 2);
    }

    protected Field leftDownThreeFields() {
        return new Field(x - 3, y - 3);
    }

    protected Field rightDownOneField() {
        return new Field(x + 1, y - 1);
    }

    protected Field rightDownTwoFields() {
        return new Field(x - 2, y - 2);
    }

    protected Field rightDownThreeFields() {
        return new Field(x - 3, y - 3);
    }

    protected Field upOneField() {
        return new Field(x, y + 1);
    }

    protected Field leftOneField() {
        return new Field(x - 1, y);
    }

    protected Field rightOneField() {
        return new Field(x + 1, y);
    }

    protected Field downOneField() {
        return new Field(x, y - 1);
    }
}
