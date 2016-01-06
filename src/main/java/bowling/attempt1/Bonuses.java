package bowling.attempt1;

public interface Bonuses {

    int apply(int score);

    void reset();

    void empty();

    int getExtraRolls();
}
