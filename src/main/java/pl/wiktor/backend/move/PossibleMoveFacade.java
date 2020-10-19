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
            if (x > Board.MAX_POOL || x < Board.MIN_POOL || y > Board.MAX_POOL || y < Board.MIN_POOL) return fields;
            if (x + 1 <= Board.MAX_POOL && y + 1 <= Board.MAX_POOL) fields.add(new Field(x+1, y+1));
            if (x - 1 >= Board.MIN_POOL && y + 1 <= Board.MAX_POOL) fields.add(new Field(x-1, y+1));
            if (x + 2 <= Board.MAX_POOL && y + 2 <= Board.MAX_POOL) fields.add(new Field(x+2, y+2));
            if (x - 2 >= Board.MIN_POOL && y + 2 <= Board.MAX_POOL) fields.add(new Field(x-2, y+2));
            if (x + 2 <= Board.MAX_POOL && y - 2 >= Board.MIN_POOL) fields.add(new Field(x+2, y-2));
            if (x - 2 >= Board.MIN_POOL && y - 2 >= Board.MIN_POOL) fields.add(new Field(x-2, y-2));

            return fields;
        };
    }

    public static Move blackPieceMove() {
        Set<Field> fields = new HashSet<>();

        return from -> {
            int x = from.getX();
            int y = from.getY();
            if (x > Board.MAX_POOL || x < Board.MIN_POOL || y > Board.MAX_POOL || y < Board.MIN_POOL) return fields;
            if (x - 1 >= Board.MIN_POOL && y - 1 >= Board.MIN_POOL) fields.add(new Field(x-1, y-1));
            if (x + 1 <= Board.MAX_POOL && y - 1 >= Board.MIN_POOL) fields.add(new Field(x+1, y-1));
            if (x - 2 >= Board.MIN_POOL && y + 2 <= Board.MAX_POOL) fields.add(new Field(x-2, y+2));
            if (x + 2 <= Board.MAX_POOL && y + 2 <= Board.MAX_POOL) fields.add(new Field(x+2, y+2));
            if (x - 2 >= Board.MIN_POOL && y - 2 >= Board.MIN_POOL) fields.add(new Field(x-2, y-2));
            if (x + 2 <= Board.MAX_POOL && y - 2 >= Board.MIN_POOL) fields.add(new Field(x+2, y-2));

            return fields;
        };
    }


}