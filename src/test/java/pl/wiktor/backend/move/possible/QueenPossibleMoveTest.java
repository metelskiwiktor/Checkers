package pl.wiktor.backend.move.possible;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pl.wiktor.backend.board.Field;
import pl.wiktor.backend.move.PossibleMoveFacade;

import java.util.Set;

@DisplayName("Queen possible moves tests")
public class QueenPossibleMoveTest extends FigurePossibleMoveTestTemplate {
    @DisplayName("Queen should move 1 field to the right up, left up, left down, right down")
    @Test
    public void test01(){
        //GIVEN
        loadStandingParameters(4, 4);
        Field from = field();
        Field rightUp = rightUpOneField();
        Field leftUp = leftUpOneField();
        Field leftDown = leftDownOneField();
        Field rightDown = rightDownOneField();

        //WHEN
        Set<Field> possibleMoves = PossibleMoveFacade.queenMove().move(from);

        System.out.println(possibleMoves);
    }
}
