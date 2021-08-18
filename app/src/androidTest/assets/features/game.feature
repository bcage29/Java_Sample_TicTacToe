Feature: PlayGame

  @play-game-feature
  Scenario: Player one wins
    Given check winning user

  @play-game-feature
  Scenario: Player one wins a game
    Given check player one score

  @play-game-feature
  Scenario: Player two wins a game
    Given check player two score

  @play-game-feature
  Scenario: reset game
    Given reset game