package bowling.attempt1;

public class Game {

    private int score = 0;
    private Bonuses bonuses;

    public void setBonuses(Bonuses bonuses) {
        this.bonuses = bonuses;
    }

    public int score() {
        return score;
    }

    public Game roll(int pins) {
        score += bonuses.apply(pins);
        return this;
    }

}
