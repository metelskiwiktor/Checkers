package pl.wiktor.backend.board;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Field functionality tests")
public class FieldTest {

    @DisplayName("Field should have properly 'x' and 'y' values")
    @Test
    public void test01(){
        //GIVEN
        int x = 3;
        int y = 3;

        //WHEN
        Field field = new Field(x, y);

        //THEN
        assertEquals(x, field.getX());
        assertEquals(y, field.getY());
    }

    @DisplayName("Field is compared by bigger x, than bigger y")
    @Test
    public void test02(){
        //GIVEN
        int bigger = 1;
        int lower = -1;
        Field first = new Field(3,6);
        Field second = new Field(3, 5);
        Field third = new Field(2,7);

        //WHEN
        int firstToSecond = first.compareTo(second);
        int firstToThird = first.compareTo(third);
        int secondToThird = second.compareTo(third);
        int thirdToFirst = third.compareTo(first);

        //THEN
        assertEquals(bigger, firstToSecond);
        assertEquals(bigger, firstToThird);
        assertEquals(bigger, secondToThird);
        assertEquals(lower, thirdToFirst);
    }

    @DisplayName("Between fields should return one properly field")
    @Test
    public void test03(){
        //GIVEN
        Field from = new Field(1,1);
        Field to = new Field(3,3);

        //WHEN
        List<Field> betweenField = from.fieldsBetween(to);

        //THEN
        assertEquals(1, betweenField.size());
        assertEquals(new Field(2,2), betweenField.stream().findAny().orElse(null));
    }

    @DisplayName("Between fields should return one properly field reversed")
    @Test
    public void test04(){
        //GIVEN
        Field from = new Field(3,3);
        Field to = new Field(1,1);

        //WHEN
        List<Field> betweenFields = from.fieldsBetween(to);

        //THEN
        assertEquals(1, betweenFields.size());
        assertEquals(new Field(2,2), betweenFields.stream().findAny().orElse(null));
    }

    @DisplayName("Between fields should return two properly fields")
    @Test
    public void test05(){
        //GIVEN
        Field from = new Field(1,1);
        Field to = new Field(4,4);
        Field betweenFirst = new Field(2, 2);
        Field betweenSecond = new Field(3, 3);

        //WHEN
        List<Field> betweenFields = from.fieldsBetween(to).stream()
                .sorted(Field::compareTo)
                .collect(Collectors.toList());
        int size = betweenFields.size();

        //THEN
        assertEquals(2, size);
        assertEquals(betweenFirst, betweenFields.get(0));
        assertEquals(betweenSecond, betweenFields.get(1));
    }

    @DisplayName("Between fields should return two properly fields reversed")
    @Test
    public void test06(){
        //GIVEN
        Field from = new Field(4,4);
        Field to = new Field(1,1);
        Field betweenFirst = new Field(2, 2);
        Field betweenSecond = new Field(3, 3);

        //WHEN
        List<Field> betweenFields = from.fieldsBetween(to).stream()
                .sorted(Field::compareTo)
                .collect(Collectors.toList());
        int size = betweenFields.size();

        //THEN
        assertEquals(2, size);
        assertEquals(betweenFirst, betweenFields.get(0));
        assertEquals(betweenSecond, betweenFields.get(1));
    }

    @DisplayName("Between fields should return 6 properly fields")
    @Test
    public void test07(){
        //GIVEN
        Field from = new Field(Board.MIN_POOL,Board.MIN_POOL);
        Field to = new Field(Board.MAX_POOL,Board.MAX_POOL);
        Field betweenFirst = new Field(2, 2);
        Field betweenSecond = new Field(3, 3);
        Field betweenThird = new Field(4, 4);
        Field betweenFourth = new Field(5, 5);
        Field betweenFifth = new Field(6, 6);
        Field betweenSixth = new Field(7, 7);

        //WHEN
        List<Field> betweenFields = from.fieldsBetween(to).stream()
                .sorted(Field::compareTo)
                .collect(Collectors.toList());
        int size = betweenFields.size();

        //THEN
        assertEquals(6, size);
        assertEquals(betweenFirst, betweenFields.get(0));
        assertEquals(betweenSecond, betweenFields.get(1));
        assertEquals(betweenThird, betweenFields.get(2));
        assertEquals(betweenFourth, betweenFields.get(3));
        assertEquals(betweenFifth, betweenFields.get(4));
        assertEquals(betweenSixth, betweenFields.get(5));
    }

    @DisplayName("Between fields should return 6 properly fields reversed")
    @Test
    public void test08(){
        //GIVEN
        Field from = new Field(Board.MAX_POOL,Board.MAX_POOL);
        Field to = new Field(Board.MIN_POOL,Board.MIN_POOL);
        Field betweenFirst = new Field(2, 2);
        Field betweenSecond = new Field(3, 3);
        Field betweenThird = new Field(4, 4);
        Field betweenFourth = new Field(5, 5);
        Field betweenFifth = new Field(6, 6);
        Field betweenSixth = new Field(7, 7);

        //WHEN
        List<Field> betweenFields = from.fieldsBetween(to).stream()
                .sorted(Field::compareTo)
                .collect(Collectors.toList());
        int size = betweenFields.size();

        //THEN
        assertEquals(6, size);
        assertEquals(betweenFirst, betweenFields.get(0));
        assertEquals(betweenSecond, betweenFields.get(1));
        assertEquals(betweenThird, betweenFields.get(2));
        assertEquals(betweenFourth, betweenFields.get(3));
        assertEquals(betweenFifth, betweenFields.get(4));
        assertEquals(betweenSixth, betweenFields.get(5));
    }
}
