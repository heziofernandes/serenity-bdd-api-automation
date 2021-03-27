package automation.spotify.utils;

import automation.spotify.app.Album;
import automation.spotify.app.Artist;
import automation.spotify.app.Spotify;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;

import static org.hamcrest.core.IsEqual.equalTo;

public class AlbumUtil {
    private final SpotifyUtil spotify = new SpotifyUtil();
    private final String apiPath = Spotify.getPath();
    private final String artistPath = Artist.getPath();
    private final String artistId = Artist.getArtistId();
    private final String artistGenre = Artist.getArtistGenre();
    private final String artistName = Artist.getArtistName();
    private final String albumId = Album.getAlbumId();
    private final String albumMarketTrack = Album.getMarketTrack();
    private Response response;

    public void getAlbum() {
        response = SerenityRest
                .given()
                .queryParam("ids", albumId)
                .queryParam("market", albumMarketTrack)
                .header("Authorization", spotify.getToken())
                .get(apiPath + artistPath + artistId);
    }

    public void verifyAlbumDetails() {
        response.then().statusCode(200)
                .body("name", equalTo(artistName))
                .and()
                .body("genres[3]", equalTo(artistGenre));
    }
}