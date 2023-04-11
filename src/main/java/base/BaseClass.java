package base;

import io.cucumber.java.After;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BaseClass {
    public WebDriver driver;

    public void setup() {
        String path = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\src\\test\\drivers\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
    }

    public void openBaseURL() {
        driver.get("https://www.youtube.com");
    }

    public void tearDown() {
        driver.close();
    }

    @After
    public void windUp() {
        //Close browser and DB connections
        System.out.println("Successfully completed all Scenarios");
    }
}