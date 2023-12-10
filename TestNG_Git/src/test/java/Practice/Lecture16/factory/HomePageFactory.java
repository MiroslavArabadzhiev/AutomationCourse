package Practice.Lecture16.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePageFactory {
    public static final String PAGE_URL = "http://training.skillo-bg.com:4300/";

    private final WebDriver driver;

    public HomePageFactory(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isUrlLoaded(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        return wait.until(ExpectedConditions.urlToBe(PAGE_URL));
    }

    public void navigatTo(){
        driver.get(PAGE_URL);
    }





}