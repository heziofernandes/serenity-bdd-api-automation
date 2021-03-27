Feature: Album

  Scenario: Search for Album
    Given I access Spotify
    When I perform the Get operation for album Hillsong through the Album endpoint
    Then I should see the Album with success