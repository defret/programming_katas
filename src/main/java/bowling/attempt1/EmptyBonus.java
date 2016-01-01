package bowling.attempt1;

public class EmptyBonus implements Bonuses {

    public int apply(int score) {
        return score;
    }

    public int getExtraRolls() {
        return 0;
    }

}
