package pl.wiktor.backend.mechanism;

import pl.wiktor.backend.board.Field;
import pl.wiktor.backend.player.FieldView;
import pl.wiktor.backend.player.PlayerType;

import java.util.Map;

@FunctionalInterface
public interface Mechanism {
    void run(PlayerType playerType, Map<Field, FieldView> board);
}
