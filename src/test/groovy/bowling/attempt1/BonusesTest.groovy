package bowling.attempt1

import spock.lang.Specification

class BonusesTest extends Specification {

    def bonuses = new Bonuses()

    def "Bonuses creation"() {
        expect: bonuses.apply(5) == 5
    }
}
