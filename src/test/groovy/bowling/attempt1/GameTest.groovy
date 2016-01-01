package bowling.attempt1

import spock.lang.Specification


class GameTest extends Specification {

    def game = new Game()
    def bonuses = Mock(Bonuses)
    def any_hits_number = 4
    def any_score = 8
    def less_than_half = 2
    def any_rolls = 5
    def max_rolls = 21
    def max_full_rolls = 12
    def more_than_allowed_rolls = max_rolls + 1
    def max_pins = 10

    def "Game creation"() {
        expect: game.score() == 0
    }

    def "First roll"() {
        when: game.roll(any_hits_number)
        then: game.score() == any_hits_number
    }

    def "Two rolls"() {
        when: game.roll(1).roll(4)
        then: game.score() == 5
    }

    def "Bonus application"() {
        given:
            bonuses.apply(_) >> any_score
            game.setBonuses(bonuses)
        when: game.roll(any_hits_number)
        then: game.score() == any_score
    }

    def "Multiple rounds"() {
        when:
            any_rolls.times {
                game.roll(less_than_half)
             }
        then: game.score() == any_rolls * less_than_half
    }

    def "Limited number of rounds"() {
        when:
            more_than_allowed_rolls.times {
                game.roll(less_than_half)
            }
        then: thrown(IllegalStateException)
    }

    def "Extra rolls"() {
        given:
            bonuses.getExtraRolls() >> 2
            bonuses.apply(_) >> 10
            game.setBonuses(bonuses)
        when:
            12.times {
                game.roll(max_pins)
            }
        then: game.score() == 120
    }

}
