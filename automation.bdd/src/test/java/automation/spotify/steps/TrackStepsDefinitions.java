package automation.spotify.steps;

import automation.spotify.utils.TrackUtil;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TrackStepsDefinitions {

    private TrackUtil track = new TrackUtil();

    @When("I perform the Get operation for music through the Track endpoint")
    public void i_perform_the_Get_operation_for_music_through_the_Track_endpoint() {
        track.getTracks();
    }

    @Then("I should see the Track with success")
    public void i_should_see_the_Track_with_success() {
        track.verifyTrackDetails();
    }

    @When("I perform the Get operation with an invalid search to music through the Track endpoint")
    public void i_perform_the_Get_operation_with_an_invalid_search_to_music_through_the_Track_endpoint() {
        track.getTrackInvalidId();
    }

    @Then("I should be informed that the search for Track is invalid")
    public void i_should_be_informed_that_the_search_for_Track_is_invalid() {
        track.actionIsExecutedFailedInvalidId();
    }
}
