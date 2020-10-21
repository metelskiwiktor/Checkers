package pl.wiktor.backend.move;

import pl.wiktor.backend.board.Board;
import pl.wiktor.backend.board.Field;

import java.util.HashSet;
import java.util.Set;

public class PossibleMoveFacade {
    public static Move whitePieceMove() {
        Set<Field> fields = new HashSet<>();

        return from -> {
            int x = from.getX();
            int y = from.getY();
            if (invalidField(from)) return fields;
            if (x + 1 <= Board.MAX_POOL && y + 1 <= Board.MAX_POOL) fields.add(new Field(x + 1, y + 1));
            if (x - 1 >= Board.MIN_POOL && y + 1 <= Board.MAX_POOL) fields.add(new Field(x - 1, y + 1));
            if (x + 2 <= Board.MAX_POOL && y + 2 <= Board.MAX_POOL) fields.add(new Field(x + 2, y + 2));
            if (x - 2 >= Board.MIN_POOL && y + 2 <= Board.MAX_POOL) fields.add(new Field(x - 2, y + 2));
            if (x + 2 <= Board.MAX_POOL && y - 2 >= Board.MIN_POOL) fields.add(new Field(x + 2, y - 2));
            if (x - 2 >= Board.MIN_POOL && y - 2 >= Board.MIN_POOL) fields.add(new Field(x - 2, y - 2));

            return fields;
        };
    }

    public static Move blackPieceMove() {
        Set<Field> fields = new HashSet<>();

        return from -> {
            int x = from.getX();
            int y = from.getY();
            if (invalidField(from)) return fields;
            if (x - 1 >= Board.MIN_POOL && y - 1 >= Board.MIN_POOL) fields.add(new Field(x - 1, y - 1));
            if (x + 1 <= Board.MAX_POOL && y - 1 >= Board.MIN_POOL) fields.add(new Field(x + 1, y - 1));
            if (x - 2 >= Board.MIN_POOL && y + 2 <= Board.MAX_POOL) fields.add(new Field(x - 2, y + 2));
            if (x + 2 <= Board.MAX_POOL && y + 2 <= Board.MAX_POOL) fields.add(new Field(x + 2, y + 2));
            if (x - 2 >= Board.MIN_POOL && y - 2 >= Board.MIN_POOL) fields.add(new Field(x - 2, y - 2));
            if (x + 2 <= Board.MAX_POOL && y - 2 >= Board.MIN_POOL) fields.add(new Field(x + 2, y - 2));

            return fields;
        };
    }

    public static Move queenMove() {
        Set<Field> fields = new HashSet<>();

        return from -> {
            int x = from.getX();
            int y = from.getY();
            if (invalidField(from)) return fields;
            for (int i = 1; i < Board.MAX_POOL; i++) {
                Field rightUp = new Field(x + i, y + i);
                Field leftUp = new Field(x - i, y + i);
                Field leftDown = new Field(x - i, y - i);
                Field rightDown = new Field(x + i, y - i);
                if (!invalidField(rightUp)) fields.add(rightUp);
                if (!invalidField(leftUp)) fields.add(leftUp);
                if (!invalidField(leftDown)) fields.add(leftDown);
                if (!invalidField(rightDown)) fields.add(rightDown);
            }

            return fields;
        };
    }

    private static boolean invalidField(Field field) {
        return field.getX() > Board.MAX_POOL || field.getX() < Board.MIN_POOL || field.getY() > Board.MAX_POOL || field.getY() < Board.MIN_POOL;
    }
}