package bowling.attempt1

import spock.lang.Specification

class BonusesTest extends Specification {

    def bonuses = new StrikesAndSpares() {}

    def "Bonuses creation"() {
        expect:
            bonuses.apply(5) == 5
    }

    def "Apply bonus"() {
        when:
            bonuses.apply(10)
        then:
            bonuses.apply(1) > 1
    }

    def "Reset"() {
        given:
            bonuses.apply(1)
        when:
            bonuses.reset()
        then:
            bonuses.apply(9)
            bonuses.apply(1) == 1
    }
}
