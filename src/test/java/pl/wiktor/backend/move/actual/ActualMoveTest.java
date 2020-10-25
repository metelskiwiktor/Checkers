package pl.wiktor.backend.move.actual;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pl.wiktor.backend.board.Field;
import pl.wiktor.backend.move.ActualMove;
import pl.wiktor.backend.move.FigureMoveTestTemplate;
import pl.wiktor.backend.player.FieldView;

import java.util.Map;
import java.util.NoSuchElementException;

@DisplayName("Actual moves tests")
public class ActualMoveTest extends FigureMoveTestTemplate {

    @DisplayName("White piece can free move")
    @Test
    public void test01() {
        //GIVEN
        Map<Field, FieldView> board = buildCompleteBoard();
        loadStandingParameters(3, 3);
        Field field = field();
        Field moveLeft = leftUpOneField();
        Field moveRight = rightUpOneField();

        //WHEN
        boolean moveLeftResult = ActualMove.checkIfCanMove(board.get(field), board.get(moveLeft), board);
        boolean moveRightResult = ActualMove.checkIfCanMove(board.get(field), board.get(moveRight), board);

        //THEN
        Assertions.assertTrue(moveLeftResult);
        Assertions.assertTrue(moveRightResult);
    }

    @DisplayName("White piece can attack")
    @Test
    public void test02() {
        //GIVEN
        Map<Field, FieldView> board = buildBoardWithBlackPiecesAroundWhite();
        loadStandingParameters(4, 4);
        Field field = field();
        Field attackRightUp = rightUpTwoFields();
        Field attackLeftUp = leftUpTwoFields();
        Field attackLeftDown = leftDownTwoFields();
        Field attackRightDown = rightDownTwoFields();

        //WHEN
        boolean attackRightUpResult = ActualMove.checkIfCanMove(board.get(field), board.get(attackRightUp), board);
        boolean attackLeftUpResult = ActualMove.checkIfCanMove(board.get(field), board.get(attackLeftUp), board);
        boolean attackLeftDownResult = ActualMove.checkIfCanMove(board.get(field), board.get(attackLeftDown), board);
        boolean attackRightDownResult = ActualMove.checkIfCanMove(board.get(field), board.get(attackRightDown), board);

        //THEN
        Assertions.assertTrue(attackRightUpResult);
        Assertions.assertTrue(attackLeftUpResult);
        Assertions.assertTrue(attackLeftDownResult);
        Assertions.assertTrue(attackRightDownResult);
    }

    @DisplayName("Move to invalid field should throws NoSuchElementException")
    @Test
    public void test03() {
        //GIVEN
        Map<Field, FieldView> board = buildCompleteBoard();
        loadStandingParameters(1, 3);
        Field field = field();
        Field invalidMoveLeftUp = leftUpOneField();

        //WHEN
        //THEN
        Assertions.assertThrows(NoSuchElementException.class,
                () -> ActualMove.checkIfCanMove(board.get(field), board.get(invalidMoveLeftUp), board)
        );
    }

    @DisplayName("White piece can't invalid free move")
    @Test
    public void test04() {
        //GIVEN
        Map<Field, FieldView> board = buildCompleteBoard();
        loadStandingParameters(3, 3);
        Field field = field();
        Field invalidMoveRightDown = rightDownOneField();
        Field invalidMoveLeftDown = rightDownOneField();

        //WHEN
        boolean invalidLeftDownResult = ActualMove.checkIfCanMove(board.get(field), board.get(invalidMoveLeftDown), board);
        boolean invalidRightDownResult = ActualMove.checkIfCanMove(board.get(field), board.get(invalidMoveRightDown), board);

        //THEN
        Assertions.assertFalse(invalidLeftDownResult);
        Assertions.assertFalse(invalidRightDownResult);
    }
}
