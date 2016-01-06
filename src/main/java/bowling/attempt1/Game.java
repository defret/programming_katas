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
        int current_round = round;
        countRoll(pins, bonuses.getExtraRolls());
        score += bonuses.apply(pins);
        if (current_round != round) {
            bonuses.reset();
        }
        return this;
    }

    private void countRoll(int pins, int extra_rolls) {
        if (round == MAX_ROUNDS && usedExtraRolls < extra_rolls) {
            bonuses.empty();
            usedExtraRolls++;
            return;
        }
        rolls++;
        if (remaining_pins - pins <= 0 || rolls > ROUND_ROLLS + extra_rolls) {
            round++;
            rolls = 1;
            remaining_pins = 10;
        }
        if (rolls > ROUND_ROLLS + extra_rolls) {
            remaining_pins = 10 - pins;
        }
        if (round > MAX_ROUNDS){
            throw new IllegalStateException("This roll is not allowed");
        }
    }

}
