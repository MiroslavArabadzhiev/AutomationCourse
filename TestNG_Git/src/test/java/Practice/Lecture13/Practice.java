package Practice.Lecture13;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

import static org.testng.Assert.assertEquals;


public class Practice {

    public static void main(String[] args) {

    }

    @Test
    private static void testLogin(){
        WebDriverManager.edgedriver().setup();
        EdgeDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("http://training.skillo-bg.com:4300/");

        //Validate page title is matching the expected page
        String pageTitle = driver.getTitle();
        Assert.assertEquals(pageTitle,"ISkillo");

        //Clicks the login link
        WebElement loginLink = driver.findElement(By.id("nav-link-login"));
        loginLink.click();

        //Validate if we are on the correct URL of the login link
        String currentURL = driver.getCurrentUrl();
        Assert.assertEquals(currentURL,"http://training.skillo-bg.com:4300/users/login");

        //Validate Sign In form is visible
        WebElement signInForm = driver.findElement(By.cssSelector(".h4"));
        Assert.assertTrue(signInForm.isDisplayed(), "The Sign In form is not visible");

        //Input valid username
        WebElement username = driver.findElement(By.id("defaultLoginFormUsername"));
        username.sendKeys("Test_MA");

        //Input valid password
        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("Test123");

        //Clicks the Remember Me checkbox
        WebElement remeberMeCheckbox = driver.findElement(By.xpath("//*[@formcontrolname=\"rememberMe\"]"));
        remeberMeCheckbox.click();

        //Validate if the Remember Me checkbox is selected
        Assert.assertTrue(remeberMeCheckbox.isSelected(), "The Remember Me checkbox is not selected");

        //Validate the Sign In button is enabled
        WebElement signInButton = driver.findElement(By.id("sign-in-button"));
        Assert.assertTrue(signInButton.isEnabled(), "The Sign In button is not enabled");

        //Clicks the Sign In button
        signInButton.click();

        //Validate the Profile link
        WebElement profileLink = driver.findElement(By.id("nav-link-profile"));
        Assert.assertTrue(profileLink.isDisplayed(), "The Profile link is not visible");

        //Clicks the Profile button
        profileLink.click();

        //Validate the user's name
        WebElement usernameProfilePage = driver.findElement(By.tagName("h2"));
        String actualUsername = usernameProfilePage.getText();
        String expectedUsername = "Test_MA";
        Assert.assertEquals(actualUsername,expectedUsername);

        //Validate the Profile's URL
        currentURL = driver.getCurrentUrl();
        Assert.assertEquals(currentURL,"http://training.skillo-bg.com:4300/users/5067");

        driver.close();
    }



}