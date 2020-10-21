package pl.wiktor.backend.move.possible;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pl.wiktor.backend.board.Board;
import pl.wiktor.backend.board.Field;
import pl.wiktor.backend.move.PossibleMoveFacade;

import java.util.Set;

@DisplayName("Black piece possible moves tests")
public class BlackPiecePossibleMoveTest extends FigurePossibleMoveTestTemplate {

    @DisplayName("Black piece should move 1 field to the right down or left down")
    @Test
    public void test01() {
        //GIVEN
        loadStandingParameters(3, 3);
        Field from = field();
        Field rightDown = rightDownOneField();
        Field leftDown = leftDownOneField();

        //WHEN
        Set<Field> possibleMoves = PossibleMoveFacade.blackPieceMove().move(from);

        //THEN
        Assertions.assertTrue(possibleMoves.contains(rightDown));
        Assertions.assertTrue(possibleMoves.contains(leftDown));
    }

    @DisplayName("Black piece should move 2 fields to the right up, left up, left down or right down")
    @Test
    public void test02() {
        //GIVEN
        loadStandingParameters(3, 3);
        Field from = field();
        Field leftUp = leftUpTwoFields();
        Field rightUp = rightUpTwoFields();
        Field leftDown = leftDownTwoFields();
        Field rightDown = rightDownTwoFields();

        //WHEN
        Set<Field> possibleMoves = PossibleMoveFacade.blackPieceMove().move(from);

        //THEN
        Assertions.assertTrue(possibleMoves.contains(rightUp));
        Assertions.assertTrue(possibleMoves.contains(leftUp));
        Assertions.assertTrue(possibleMoves.contains(leftDown));
        Assertions.assertTrue(possibleMoves.contains(rightDown));
    }

    @DisplayName("Black piece shouldn't move 1 field to the right up or left up")
    @Test
    public void test03() {
        //GIVEN
        loadStandingParameters(3, 3);
        Field from = field();
        Field leftUp = leftUpOneField();
        Field rightUp = rightUpOneField();

        //WHEN
        Set<Field> possibleMoves = PossibleMoveFacade.blackPieceMove().move(from);

        //THEN
        Assertions.assertFalse(possibleMoves.contains(leftUp));
        Assertions.assertFalse(possibleMoves.contains(rightUp));
    }

    @DisplayName("Black piece shouldn't move straight up, left, down or right")
    @Test
    public void test04() {
        //GIVEN
        loadStandingParameters(3, 3);
        Field from = field();
        Field up = upOneField();
        Field left = leftOneField();
        Field right = rightOneField();
        Field down = downOneField();

        //WHEN
        Set<Field> possibleMoves = PossibleMoveFacade.blackPieceMove().move(from);

        //THEN
        Assertions.assertFalse(possibleMoves.contains(up));
        Assertions.assertFalse(possibleMoves.contains(left));
        Assertions.assertFalse(possibleMoves.contains(right));
        Assertions.assertFalse(possibleMoves.contains(down));
    }

    @DisplayName("Black piece shouldn't move 3 fields to the right up, left up, left down or right down")
    @Test
    public void test05() {
        //GIVEN
        loadStandingParameters(4, 4);
        Field from = field();
        Field leftUp = leftUpThreeFields();
        Field rightUp = rightUpThreeFields();
        Field leftDown = leftDownThreeFields();
        Field rightDown = rightDownThreeFields();

        //WHEN
        Set<Field> possibleMoves = PossibleMoveFacade.blackPieceMove().move(from);

        //THEN
        Assertions.assertFalse(possibleMoves.contains(rightUp));
        Assertions.assertFalse(possibleMoves.contains(leftUp));
        Assertions.assertFalse(possibleMoves.contains(leftDown));
        Assertions.assertFalse(possibleMoves.contains(rightDown));
    }

    @DisplayName("Black piece shouldn't move 1 field to the left up, right up being on the up edge")
    @Test
    public void test06() {
        //GIVEN
        loadStandingParameters(3, Board.MAX_POOL);
        Field from = field();
        Field leftUp = leftUpOneField();
        Field rightUp = rightUpOneField();

        //WHEN
        Set<Field> possibleMoves = PossibleMoveFacade.blackPieceMove().move(from);

        //THEN
        Assertions.assertFalse(possibleMoves.contains(rightUp));
        Assertions.assertFalse(possibleMoves.contains(leftUp));
    }

    @DisplayName("Black piece shouldn't move 2 fields to the left down, right down being on the down edge")
    @Test
    public void test07() {
        //GIVEN
        loadStandingParameters(3, Board.MIN_POOL);
        Field from = field();
        Field leftDown = leftDownTwoFields();
        Field rightDown = rightDownTwoFields();

        //WHEN
        Set<Field> possibleMoves = PossibleMoveFacade.blackPieceMove().move(from);

        //THEN
        Assertions.assertFalse(possibleMoves.contains(rightDown));
        Assertions.assertFalse(possibleMoves.contains(leftDown));
    }

    @DisplayName("Black piece shouldn't move 1 field to the right up being on the right edge")
    @Test
    public void test08() {
        //GIVEN
        loadStandingParameters(Board.MAX_POOL, 4);
        Field from = field();
        Field rightUp = rightUpOneField();

        //WHEN
        Set<Field> possibleMoves = PossibleMoveFacade.blackPieceMove().move(from);

        //THEN
        Assertions.assertFalse(possibleMoves.contains(rightUp));
    }

    @DisplayName("Black piece shouldn't move 1 field to the left up being on the left edge")
    @Test
    public void test09() {
        //GIVEN
        loadStandingParameters(Board.MIN_POOL, 4);
        Field from = field();
        Field leftUp = leftUpOneField();

        //WHEN
        Set<Field> possibleMoves = PossibleMoveFacade.blackPieceMove().move(from);

        //THEN
        Assertions.assertFalse(possibleMoves.contains(leftUp));
    }
}
