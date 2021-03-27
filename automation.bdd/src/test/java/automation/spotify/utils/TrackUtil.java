package automation.spotify.utils;

import automation.spotify.app.Album;
import automation.spotify.app.Spotify;
import automation.spotify.app.Track;
import io.restassured.response.Response;
import io.restassured.specification.ResponseSpecification;
import net.serenitybdd.rest.SerenityRest;

import static org.hamcrest.core.IsEqual.equalTo;

public class TrackUtil {
    private SpotifyUtil spotify = new SpotifyUtil();
    public static ResponseSpecification responseSpec;
    private Response response;
    private String apiPath = Spotify.getPath();
    private String trackPath = Track.getTrackPath();
    private String trackId = Track.getTrackId();
    private String trackName = Track.getTrackName();
    private int trackNumber = Track.getTrackNumber();
    private String albumMarketTrack = Album.getMarketTrack();

    public void getTrackInvalidId() {
        response = SerenityRest
                .given()
                .queryParam("ids", "xpto-010203")
                .queryParam("market", albumMarketTrack)
                .header("Authorization", spotify.getToken())
                .get(apiPath + trackPath);
    }

    public void getTracks() {
        response = SerenityRest
                .given()
                .queryParam("ids", trackId)
                .queryParam("market", albumMarketTrack)
                .header("Authorization", spotify.getToken())
                .get(apiPath + trackPath + trackId);
    }

    public void verifyTrackDetails() {
        response.then().statusCode(200)
                .body("id", equalTo(trackId))
                .and()
                .body("name", equalTo(trackName))
                .and()
                .body("track_number", equalTo(trackNumber));
    }
    public void actionIsExecutedFailedInvalidId() {
        response.then().statusCode(400)
                .and()
                .body("error.message", equalTo("invalid id"));
    }
}
