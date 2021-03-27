package automation.spotify.utils;

import automation.spotify.app.*;
import io.restassured.response.Response;
import io.restassured.specification.ResponseSpecification;
import net.serenitybdd.rest.SerenityRest;

import java.util.ArrayList;

import static org.hamcrest.core.IsEqual.equalTo;

public class CategoryUtil {
    public static ResponseSpecification responseSpec;
    private Response response;
    private String apiPath = Spotify.getPath();
    private  SpotifyUtil spotify = new SpotifyUtil();
    private String categoriesPath = Categories.getPath();
    private ArrayList categoriesList = Categories.getCategories();
    private String categoriesLimit = Categories.getLimit();
    private String categoriesOffset = Categories.getOffset();
    private String categoriesLocale = Categories.getLocale();



    public void getCategories() {
        response = SerenityRest
                .given()
                .queryParam("limit", categoriesLimit)
                .queryParam("offset", categoriesOffset)
                .queryParam("locale", categoriesLocale)
                .header("Authorization",spotify.getToken())
                .get(apiPath + categoriesPath);
    }
    public void verifyCategoriesId() {
        for (int index = 0; index < categoriesList.size(); index++) {
            response.then().log().all().statusCode(200)
                    .body("categories.items[" + index + "].id", equalTo(categoriesList.get(index)));
        }
    }
    public void getCategoriesLimitMustBeLargerThanZero() {
        response = SerenityRest
                .given()
                .queryParam("limit", 0)
                .queryParam("offset", categoriesOffset)
                .queryParam("locale", categoriesLocale)
                .header("Authorization", spotify.getToken())
                .get(apiPath + categoriesPath);
    }
    public void actionIsExecutedFailedLimitMustBeLargerThanZero() {
        response.then().statusCode(400)
                .and()
                .body("error.message", equalTo("Bad limit, limit must be larger than 0"));
    }
}
