package automation.spotify.steps;

import automation.spotify.utils.ArtistUtil;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ArtistStepsDefinitions {
    ArtistUtil artist = new ArtistUtil();

    @When("I perform the Get operation for artist Hillsong through the Artist endpoint")
    public void i_perform_the_Get_operation_for_artist_Hillsong_through_the_Artist_endpoint() {
        artist.getArtist();
    }

    @Then("I should see the Artist with success")
    public void i_should_see_the_Artist_with_success() {
        artist.verifyArtistName();
    }

    @When("I perform the Get operation with an invalid search to an artist through the Artist endpoint")
    public void i_perform_the_Get_operation_with_an_invalid_search_to_an_artist_through_the_Artist_endpoint() {
        artist.getArtistInvalidId();
    }

    @Then("I should be informed that the invalid search")
    public void i_should_be_informed_that_the_invalid_search() {
        artist.actionIsExecutedFailedInvalidId();
    }

    @When("I perform the Get operation for Non-existent artist through the Artist endpoint")
    public void i_perform_the_Get_operation_for_Non_existent_artist_through_the_Artist_endpoint() {
        artist.getArtistNoId();
    }

    @Then("I should be informed that the result to an artist is null")
    public void i_should_be_informed_that_the_result_to_an_artist_is_null() {
        artist.actionIsExecutedNullArtist();
    }

}
