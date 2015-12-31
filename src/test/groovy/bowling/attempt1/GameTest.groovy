package bowling.attempt1


class GameTest extends spock.lang.Specification {

    def game = new Game();

    def "Game creation"() {
        expect: game.score() == 0
    }
}
