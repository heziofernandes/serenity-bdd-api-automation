package automation.spotify.app;

import java.util.ArrayList;

public class Categories {

    public static String getPath() {
        return "/browse/categories/";
    }

    public static String getLimit() {
        return "3";
    }

    public static String getOffset() {
        return "5";
    }

    public static ArrayList<String> getCategories() {
        ArrayList<String> categories = new ArrayList<String>();
        categories.add("decades");
        categories.add("hiphop");
        categories.add("in_the_car");
        return categories;
    }

    public static String getLocale() {
        return "pt_BR";
    }
}
