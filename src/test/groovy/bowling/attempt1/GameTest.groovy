package bowling.attempt1


class GameTest extends spock.lang.Specification {

    def game = new Game();

    def "Game creation"() {
        expect: game.score() == 0
    }

    def "First roll"() {
        when: game.roll(1)
        then: game.score() == 1
    }
}
