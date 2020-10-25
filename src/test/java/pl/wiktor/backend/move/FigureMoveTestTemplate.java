package pl.wiktor.backend.move;

import pl.wiktor.backend.board.Board;
import pl.wiktor.backend.board.Field;
import pl.wiktor.backend.figure.Figure;
import pl.wiktor.backend.figure.FigureType;
import pl.wiktor.backend.player.FieldView;
import pl.wiktor.backend.player.PlayerType;

import java.util.HashMap;
import java.util.Map;

public abstract class FigureMoveTestTemplate {
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

    protected Map<Field, FieldView> buildCompleteBoard() {
        Map<Field, FieldView> board = new HashMap<>();
        for (int x = Board.MIN_POOL; x <= Board.MAX_POOL; x++) {
            for (int y = Board.MIN_POOL; y <= Board.MAX_POOL; y++) {
                if ((x + y) % 2 != 0) continue;
                Field field = new Field(x, y);
                Figure figure;
                FieldView fieldView;
                if (y <= 3) {
                    figure = new Figure(FigureType.PIECE, PossibleMoveFacade.whitePieceMove());
                    fieldView = new FieldView(figure, PlayerType.WHITE, field);
                }
                else if (y >= 6) {
                    figure = new Figure(FigureType.PIECE, PossibleMoveFacade.blackPieceMove());
                    fieldView = new FieldView(figure, PlayerType.BLACK, field);
                } else {
                    fieldView = new FieldView(null, null, field);
                }
                board.put(field, fieldView);
            }
        }

        return board;
    }

    protected Map<Field, FieldView> buildBoardWithBlackPiecesAroundWhite() {
        Map<Field, FieldView> board = new HashMap<>();
        Field whiteField = new Field(4,4);
        Field blackField1 = new Field(5,5);
        Field blackField2 = new Field(3,5);
        Field blackField3 = new Field(3,3);
        Field blackField4 = new Field(5,3);
        board.put(whiteField, new FieldView(new Figure(FigureType.PIECE, PossibleMoveFacade.whitePieceMove()), PlayerType.WHITE, whiteField));
        board.put(blackField1, new FieldView(new Figure(FigureType.PIECE, PossibleMoveFacade.blackPieceMove()), PlayerType.BLACK, blackField1));
        board.put(blackField2, new FieldView(new Figure(FigureType.PIECE, PossibleMoveFacade.blackPieceMove()), PlayerType.BLACK, blackField2));
        board.put(blackField3, new FieldView(new Figure(FigureType.PIECE, PossibleMoveFacade.blackPieceMove()), PlayerType.BLACK, blackField3));
        board.put(blackField4, new FieldView(new Figure(FigureType.PIECE, PossibleMoveFacade.blackPieceMove()), PlayerType.BLACK, blackField4));

        for (int x = Board.MIN_POOL; x <= Board.MAX_POOL; x++) {
            for (int y = Board.MIN_POOL; y <= Board.MAX_POOL; y++) {
                if ((x + y) % 2 != 0) continue;
                Field field = new Field(x, y);
                if(!board.containsKey(field)) board.put(field, new FieldView(null, null, field));
            }
        }

        return board;
    }
}
