package pl.wiktor.backend.player;

public enum PlayerType {
    BLACK{
        @Override
        public PlayerType oppositePlayerType() {
            return WHITE;
        }
    }, WHITE {
        @Override
        public PlayerType oppositePlayerType() {
            return BLACK;
        }
    };

    public abstract PlayerType oppositePlayerType();
}
