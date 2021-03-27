package automation.spotify.steps;

import automation.spotify.utils.AlbumUtil;
import automation.spotify.utils.SpotifyUtil;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AlbumStepDefinitions {

    private AlbumUtil album = new AlbumUtil();

    @Given("I access Spotify")
    public void i_access_Spotify() {
        SpotifyUtil.createResponseSpecification();
    }

    @When("I perform the Get operation for album Hillsong through the Album endpoint")
    public void i_perform_the_Get_operation_for_album_Hillsong_through_the_Album_endpoint() {
        album.getAlbum();
    }

    @Then("I should see the Album with success")
    public void i_should_see_the_Album_with_success() {
        album.verifyAlbumDetails();
    }
}
