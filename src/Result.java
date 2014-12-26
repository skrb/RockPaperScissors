
public enum Result {

    WIN {
                @Override
                public String toString() {
                    return "I Win!";
                }
            },
    LOSE {
                @Override
                public String toString() {
                    return "I Lose!";
                }
            },
    DRAW {
                @Override
                public String toString() {
                    return "Draw\nOnce Again!";
                }
            }
}
