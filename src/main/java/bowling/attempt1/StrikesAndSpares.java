package bowling.attempt1;

import java.util.List;

public class StrikesAndSpares implements Bonuses {

    private List<Integer> multipliers;
    private int extraRolls = 0;

    public int apply(int score) {
        if (score == 10) {
            extraRolls = 1;
        } else {
            extraRolls = 0;
        }
        return score;
    }

    public int getExtraRolls() {
        return extraRolls;
    }


}
