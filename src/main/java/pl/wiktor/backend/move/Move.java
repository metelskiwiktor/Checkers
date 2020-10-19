package pl.wiktor.backend.move;

import pl.wiktor.backend.board.Field;

import java.util.Set;

@FunctionalInterface
public interface Move {
    Set<Field> move(Field from);
}
