Feature: Categories

  Scenario: Search for Album/Music by Categories
    Given I access Spotify
    When I perform the Get operation for the category of an artist through the categories endpoint
    Then I should see the list of information about categories

  Scenario: Search for Categories must be larger than Zero
    Given I access Spotify
    When I perform the Get operation for the category of an artist with limit zero through the categories endpoint
    Then I should see the list of information limit of category must be larger than Zero

