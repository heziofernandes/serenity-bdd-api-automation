package automation.spotify.utils;

import automation.spotify.app.Artist;
import automation.spotify.app.Spotify;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;

import static org.hamcrest.core.IsEqual.equalTo;

public class ArtistUtil {
    private final SpotifyUtil spotify = new SpotifyUtil();
    private final String apiPath = Spotify.getPath();
    private final String artistPath = Artist.getPath();
    private final String artistId = Artist.getArtistId();
    private final String artistName = Artist.getArtistName();
    private Response response;

    public void getArtistInvalidId() {
        response = SerenityRest
                .given()
                .queryParam("ids", "123-xxx")
                .header("Authorization", spotify.getToken())
                .get(apiPath + artistPath);
    }

    public void actionIsExecutedFailedInvalidId() {
        response.then().statusCode(400)
                .and()
                .body("error.message", equalTo("invalid id"));
    }

    public void getArtist() {
        response = SerenityRest
                .given()
                .queryParam("ids", artistId)
                .header("Authorization", spotify.getToken())
                .get(apiPath + artistPath);
    }

    public void verifyArtistName() {
        response.then()
                .statusCode(200)
                .and()
                .body("artists[0].name", equalTo(artistName));
    }

    public void getArtistNoId() {
        response = SerenityRest
                .given()
                .queryParam("ids", toString().isEmpty())
                .header("Authorization", spotify.getToken())
                .get(apiPath + artistPath);
    }

    public void actionIsExecutedNullArtist() {
        response.then().statusCode(200)
                .and()
                .body("artists[0]", equalTo(null));
    }

}
