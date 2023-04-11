package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pageObjects.SearchMoviePage;
import utils.Context;

public class SearchMovieSteps {

    private static final Logger LOGGER = LoggerFactory.getLogger(SearchMovieSteps.class);

    Context context;
    SearchMoviePage searchMoviePage;

    public SearchMovieSteps(Context context) {
        this.context = context;
        searchMoviePage = context.getSearchMoviePage();
    }

    @Given("User searches for movie name {string}")
    public void movieNameSearch(String movieName) {
        context.openBaseURL();
        LOGGER.info("User is on Youtube home page\n");
        LOGGER.info("User enters search keyword : "+movieName+"\n");
        searchMoviePage.enterSearchKey(movieName);
        searchMoviePage.enterSearch();
    }

    @When("User clicks on the movie thumbnail listed")
    public void clickMovieThumbnail() {
        LOGGER.info("User click movie Thumbnail");
        searchMoviePage.clicksThumbnail();
    }

    @Then("Verifies if the movie is playing")
    public void verifiesIfTheMovieIsPlaying() {
        LOGGER.info("Make sure if the movie is playing\n");
        String pageTitle = searchMoviePage.getPageTitle();
        LOGGER.info(pageTitle);
        Assert.assertEquals ("Assertion Passed", "sunflower post malone - YouTube", pageTitle);
    }

    @And("User closes the browser")
    public void userClosesTheBrowser() {
        LOGGER.info("Closing the browser");
        context.tearDown();
    }
}
