package pl.wiktor.backend.board;

import pl.wiktor.backend.figure.Figure;

import java.util.Map;

public class Board {
    public static final int MAX_POOL = 8;
    public static final int MIN_POOL = 1;
    private final Map<Field, Figure> board;

    public Board(Map<Field, Figure> board) {
        this.board = board;
    }

    public Map<Field, Figure> getBoard(){
        return board;
    }

    public void clearField(Field field){
        board.replace(field, null);
    }

    public Figure getFigure(Field field){
        return board.get(field);
    }
}
