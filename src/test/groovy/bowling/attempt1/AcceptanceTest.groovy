package bowling.attempt1

import spock.lang.Specification


class AcceptanceTest extends Specification {

    def game = new Game()
    def rolls = [1, 4, 4, 5, 6, 4, 5, 5, 10, 0, 1, 7, 3, 6, 4, 10, 2, 8, 6]
    def score = 133

    def "Instructions example"() {
        given:
            game.setBonuses(new StrikesAndSpares())
        when:
            rolls.each {
                game.roll(it)
            }
        then:
            game.score() == score
    }

}
