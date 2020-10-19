package pl.wiktor.backend.player;

import pl.wiktor.backend.mechanism.Mechanism;

public abstract class Player {
    private final PlayerType playerType;
    private final Mechanism mechanism;

    public Player(PlayerType playerType, Mechanism mechanism) {
        this.playerType = playerType;
        this.mechanism = mechanism;
    }

    public PlayerType getPlayerType() {
        return playerType;
    }

    public Mechanism getMechanism() {
        return mechanism;
    }
}
