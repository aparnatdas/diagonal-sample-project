package pageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

public class SearchMoviePage {

    private static final Logger LOGGER = LoggerFactory.getLogger(SearchMoviePage.class);

    WebDriver driver;
    WebDriverWait wait;

    @FindBy(css = "input[id='search']")
    WebElement searchBox;

    @FindBy(css = "button[id='search-icon-legacy']")
    WebElement searchButton;

    @FindBy(xpath = "//*[contains(text(),'Post Malone')]")
    WebElement searchElement;

    @FindBy(css = "button[title^='Pause']")
    WebElement pauseButton;

    public SearchMoviePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(this.driver, Duration.ofSeconds(1));
    }

    public String getPageTitle() {
        LOGGER.debug("Getting Page Title");
        return driver.getTitle();
    }

    public void enterSearchKey(String searchKey) {
        wait.until(ExpectedConditions.visibilityOf(searchBox));
        try {
            Thread.sleep(500);
        } catch (InterruptedException ignored) {

        }
        searchBox.clear();
        searchBox.sendKeys(searchKey);
    }

    public void enterSearch() {
        searchBox.sendKeys(Keys.ENTER);
    }

    public void clicksThumbnail() {
        wait.until(ExpectedConditions.visibilityOf(searchElement));
        try {
            Thread.sleep(500);
        } catch (InterruptedException ignored) {
        }
        searchElement.click();
    }

    public boolean checkIfPauseButtonIsVisible() {
        try {
            if (pauseButton.isDisplayed())
                return true;
        } catch (Exception ignored){
        }
        return false;
    }
}
