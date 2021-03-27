Feature: Track

Scenario: Search for Track
Given I access Spotify
When I perform the Get operation for music through the Track endpoint
Then I should see the Track with success

Scenario: Invalid search for a Track
Given I access Spotify
When I perform the Get operation with an invalid search to music through the Track endpoint
Then I should be informed that the search for Track is invalid
