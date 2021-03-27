package automation.spotify.utils;

import automation.spotify.app.Spotify;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.ResponseSpecification;
import net.serenitybdd.rest.SerenityRest;
import org.junit.BeforeClass;

public class SpotifyUtil {
    private final String getTokenAddress;
    private final String token;
    private final String grantType;

    {
        getTokenAddress = Spotify.getTokenAddress();
        token = Spotify.getTokenSpotify();
        grantType = Spotify.getGrantTypeCredentials();
    }

    @BeforeClass
    public static void createResponseSpecification() {
        ResponseSpecification responseSpec = new ResponseSpecBuilder().
                expectStatusCode(200)
                .expectContentType(ContentType.JSON)
                .build();
    }

    public String getToken() {
        Response response = SerenityRest
                .given()
                .header("Content-Type", "application/x-www-form-urlencoded")
                .header("Authorization", token)
                .body(grantType)
                .post(getTokenAddress);
        String tokenAuthenticator;
        tokenAuthenticator = "Bearer " + response.jsonPath().get("access_token");
        return tokenAuthenticator;
    }
}
