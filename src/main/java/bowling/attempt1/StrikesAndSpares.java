package bowling.attempt1;

import java.util.LinkedList;
import java.util.List;

public class StrikesAndSpares implements Bonuses {

    private List<Integer> multipliers = new LinkedList<Integer>();
    private int extraRolls = 0;
    private int pinsRemaining = 10;

    public int apply(int pins) {
        fillMultipliers();
        int multiplier = multipliers.get(0);
        multipliers.remove(0);
        fillMultipliers();
        pinsRemaining -= pins;
        if (pinsRemaining == 0) {
            extraRolls = 1;
            incrementMultiplier(0);
        } else {
            extraRolls = 0;
        }
        if (pins == 10) {
            incrementMultiplier(1);
        }
        return multiplier * pins;
    }

    private void incrementMultiplier(int index) {
        multipliers.set(index, multipliers.get(index) + 1);
    }

    private void fillMultipliers() {
        while (multipliers.size() < 2) {
            multipliers.add(1);
        }
    }

    public void reset() {
        pinsRemaining = 10;
    }

    public void empty() {
        multipliers.remove(0);
        multipliers.remove(0);
    }

    public int getExtraRolls() {
        return extraRolls;
    }


}
