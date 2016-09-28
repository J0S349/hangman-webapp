Feature: Hangman web page
    As a user I want to guess the word that is kept secret


    Scenario: Guessed two correct letters in word
        Given I am on the hangman page
        When I enter "abc"
        Then I see the word "ca."

    Scenario: Hangman fails with empty input
        Given I am on the hangman page
        When I enter ""
        Then I see the word "..."

    Scenario: Entered numbers instead of letters
        Given I am on the hangman page
        When I enter "1234"
        Then I see the word "..."
    

