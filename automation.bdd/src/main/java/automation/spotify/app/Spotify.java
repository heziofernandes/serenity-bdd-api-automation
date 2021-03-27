package automation.spotify.app;

public class Spotify {

    public static String getPath() {
        return "https://api.spotify.com/v1";
    }

    public static String getTokenSpotify() {
        return System.getenv("SPOTIFY_TOKEN");
    }
    public static String getTokenAddress() {
        return "https://accounts.spotify.com/api/token";
    }
    public static String getGrantTypeCredentials() {
        return "grant_type=client_credentials";
    }
}
