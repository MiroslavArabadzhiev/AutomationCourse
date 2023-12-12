package Practice.Lecture17.upload;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProfileClass {
    public static final String PAGE_URL = "http://training.skillo-bg.com:4300/users";

    private final WebDriver driver;

    @FindBy(tagName = "h2")
    private WebElement loggedInUser;

    public ProfileClass(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public boolean isUrlLoaded(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        return wait.until(ExpectedConditions.urlContains(PAGE_URL));
    }

    public String getUsername(){
        return loggedInUser.getText();
    }
}
