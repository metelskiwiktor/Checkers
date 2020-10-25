package pl.wiktor.backend.move;

import pl.wiktor.backend.board.Field;
import pl.wiktor.backend.figure.FigureType;
import pl.wiktor.backend.player.FieldView;
import pl.wiktor.backend.player.PlayerType;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;

//CHECKS IF PLAYER CAN MOVE TO TARGET FIELD
public class ActualMove {
    public static final int ONE_ENEMY_PIECE = 1;
    public static final int ONE_FIELD = 1;

    public static boolean checkIfCanMove(FieldView from, FieldView to, Map<Field, FieldView> board){
        if(Objects.isNull(from) || Objects.isNull(from.getPlayerType()) ||  Objects.isNull(to))
            throw new NoSuchElementException("'From' or 'To' is null");
        return validMove(from, to) && (canFreeMove(from, to) || canAttack(from, to, board));
    }

    private static boolean validMove(FieldView from, FieldView to){
        boolean possibleMove = from.getFigure().getMoves().move(from.getField()).contains(to.getField());
        boolean targetIsClear = to.getFigure() == null;
        return possibleMove && targetIsClear;
    }

    private static boolean canFreeMove(FieldView from, FieldView to){
        boolean canFreeMove = true;
        if(from.getFigure().getFigureType() == FigureType.PIECE){
            canFreeMove = from.getField().distance(to.getField()) == ONE_FIELD;
        }
        return canFreeMove;
    }

    private static boolean canAttack(FieldView from, FieldView to, Map<Field, FieldView> board){
        List<Field> betweenFields = from.getField().fieldsBetween(to.getField());
        return howManyEnemyFigures(betweenFields, from.getPlayerType().oppositePlayerType(), board) == ONE_ENEMY_PIECE;
    }

    private static int howManyEnemyFigures(List<Field> betweenFields, PlayerType enemy, Map<Field, FieldView> board){
        return (int) betweenFields.stream()
                .filter(field -> board.get(field).getPlayerType() == enemy)
                .count();
    }
}

