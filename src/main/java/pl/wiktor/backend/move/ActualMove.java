package pl.wiktor.backend.move;

import pl.wiktor.backend.board.Field;
import pl.wiktor.backend.figure.FigureType;
import pl.wiktor.backend.player.FieldView;
import pl.wiktor.backend.player.PlayerType;

import java.util.List;
import java.util.Map;

public class ActualMove {
    public static boolean actualMove(FieldView from, FieldView to, Map<Field, FieldView> board) {
        boolean possibleMove = from.getFigure().getMoves().move(from.getField()).contains(to.getField());
        if (!possibleMove) return false;
        boolean actualMove = false;
        if (from.getFigure().getFigureType() == FigureType.PIECE) {
            if (from.getField().distance(to.getField()) == 1) {
                return to.getFigure() == null;
            } else if (from.getField().distance(to.getField()) == 2) {
                List<Field> fieldsBetween = from.getField().fieldsBetween(to.getField());
                if (fieldsBetween.size() != 1) return false;
                Field fieldBetween = fieldsBetween.stream().findFirst().get();
                FieldView fieldView = board.get(fieldBetween);
                PlayerType oppositePlayerType = from.getPlayerType() == PlayerType.WHITE ? PlayerType.BLACK : PlayerType.WHITE;
                return fieldView.getFigure() != null && to.getPlayerType() == oppositePlayerType;
            }
        }
        return actualMove;
    }
}
