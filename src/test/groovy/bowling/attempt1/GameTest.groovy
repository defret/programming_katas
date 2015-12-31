package bowling.attempt1


class GameTest extends spock.lang.Specification {

    def game = new Game()
    def bonuses = Mock(Bonuses)
    def any_hits_number = 4
    def any_score = 8

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

    def "First strike and follow up"() {
        when: game.roll(10).roll(5)
        then: game.score() == 20
    }
}
