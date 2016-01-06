package bowling.attempt1;

public class EmptyBonus implements Bonuses {

    public int apply(int score) {
        return score;
    }

    public void reset() {
    }

    public void empty() {
    }

    public int getExtraRolls() {
        return 0;
    }

}
