Feature: basic dev to functionalities
  Scenario: select first podcast and play it
    Given DevTo main page is open
    When User click on podcast
    And user select first podcast
    Then user can see its title
    And user can play it

  Scenario: Select first video
    Given DevTo main page is open
    When User click on videos
    And User select first video

    Then User is redirected to proper page
  Scenario: Searching for right phrase
    Given DevTo main page is open
    When User search "testing"
    Then Top result should contain the word "testing"

