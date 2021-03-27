package automation.spotify.steps;

import automation.spotify.utils.CategoryUtil;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CategoryStepsDefinitions {
  private CategoryUtil category= new CategoryUtil();

    @When("I perform the Get operation for the category of an artist through the categories endpoint")
    public void i_perform_the_Get_operation_for_the_category_of_an_artist_through_the_categories_endpoint() {
        category.getCategories();
    }

    @Then("I should see the list of information about categories")
    public void i_should_see_the_list_of_information_about_categories() {
        category.verifyCategoriesId();
    }

    @When("I perform the Get operation for the category of an artist with limit zero through the categories endpoint")
    public void i_perform_the_Get_operation_for_the_category_of_an_artist_with_limit_zero_through_the_categories_endpoint() {
        category.getCategoriesLimitMustBeLargerThanZero();

    }

    @Then("I should see the list of information limit of category must be larger than Zero")
    public void i_should_see_the_list_of_information_limit_of_category_must_be_larger_than_Zero() {
        category.actionIsExecutedFailedLimitMustBeLargerThanZero();
    }
}
