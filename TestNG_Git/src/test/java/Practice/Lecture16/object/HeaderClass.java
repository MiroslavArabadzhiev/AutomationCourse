package Practice.Lecture16.object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HeaderClass {
    private final WebDriver driver;
    public HeaderClass(WebDriver driver) {
        this.driver = driver;
    }

    public void clickProfileLink(){
        //Validate the Profile link
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement profileLink = wait.until(ExpectedConditions.elementToBeClickable(By.id("nav-link-profile")));

        //Clicks the Profile button
        profileLink.click();

    }

    public void clickLoginLink(){
        WebElement loginLink = driver.findElement(By.id("nav-link-login"));
        loginLink.click();
    }

}