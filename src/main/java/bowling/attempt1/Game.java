package bowling.attempt1;

public class Game {

    private int score = 0;
    private Bonuses bonuses = new EmptyBonus();
    private int rolls = 1;
    private int round = 0;
    private static final int ROUND_ROLLS = 2;
    private static final int MAX_ROUNDS = 10;
    private int remaining_pins = 10;
    private int usedExtraRolls = 0;

    public void setBonuses(Bonuses bonuses) {
        this.bonuses = bonuses;
    }

    public int score() {
        return score;
    }

    public Game roll(int pins) {
        countRoll(pins, bonuses.getExtraRolls());
        score += bonuses.apply(pins);
        return this;
    }

    private void countRoll(int pins, int extra_rolls) {
        rolls++;
        if (rolls > ROUND_ROLLS + extra_rolls) {
            round++;
            rolls = 1;
            remaining_pins = 10 - pins;
        } else if (remaining_pins - pins <= 0) {
            round++;
            rolls = 1;
            remaining_pins = 10;
        }
        if (round == MAX_ROUNDS + 1 && usedExtraRolls < extra_rolls) {
            round--;
            usedExtraRolls++;
        }

        if (round > MAX_ROUNDS){
            throw new IllegalStateException("This roll is not allowed");
        }
    }

}
