Feature: Hangman Rest
    As an API user I want to be able to check whether I enter the correct name

    Scenario: Starting Hangman webapp
        When I call the start endpoint
        Then result of start endpoint should be '...'

    Scenario: Testing Hangman webapp with no input
        When I call the match endpoint with ''
        Then the result of match endpoint should be '...'

    Scenario: Testing Hangman webapp with correct input
        When I call the match endpoint with 'abc'
        Then the result of match endpoint should be 'ca.'

    Scenario: Testing Hangman webapp with numbers as input
        When I call the match endpoint with '1234'
        Then the result of match endpoint should be '...'


