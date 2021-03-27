Feature: Artist

  Scenario: Search for Artist
    Given I access Spotify
    When I perform the Get operation for artist Hillsong through the Artist endpoint
    Then I should see the Artist with success

  Scenario: Invalid search for an Artist
    Given I access Spotify
    When I perform the Get operation with an invalid search to an artist through the Artist endpoint
    Then I should be informed that the invalid search

  Scenario: Search for a Non-existent artist
    Given I access Spotify
    When I perform the Get operation for Non-existent artist through the Artist endpoint
    Then I should be informed that the result to an artist is null