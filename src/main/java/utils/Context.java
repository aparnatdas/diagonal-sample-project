package utils;

import org.openqa.selenium.WebDriver;
import base.BaseClass;
import pageObjects.SearchMoviePage;

public class Context extends BaseClass {

    private SearchMoviePage searchMoviePage;

    public Context() {
        setup();
    }

    public WebDriver getDriver() {
        return driver;
    }


    public SearchMoviePage getSearchMoviePage() {
        if (searchMoviePage == null) {
            searchMoviePage = new SearchMoviePage(driver);
        }
        return searchMoviePage;
    }
}