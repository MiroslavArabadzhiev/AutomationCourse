package Homeworks.Lecture14;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;
import java.util.List;

import static org.testng.Assert.assertEquals;


public class Lecture14 {

    private WebDriver driver;
    public static final String username = "Test_MA";
    public static final String password = "Test123";

    public static void main(String[] args) {

    }

    @BeforeSuite
    protected final void setupTestSuite() {
        WebDriverManager.edgedriver().setup();
        WebDriverManager.chromedriver().setup();
        WebDriverManager.firefoxdriver().setup();
    }

    @BeforeMethod
    protected final void setupMethod() {
        this.driver = new EdgeDriver();
        this.driver.manage().window().maximize();
        this.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    @AfterMethod
    protected final void tearDownTest() {
        if (this.driver != null) {
            this.driver.close();
        }
    }

    //invocationCount shows how many times a test should be executed
    @Test()
    private void testLogin() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        //Open the Skillo website
        driver.get("http://training.skillo-bg.com:4300/");

        //Check we are on the correct page
        wait.until(ExpectedConditions.urlContains("http://training.skillo-bg.com:4300/"));

        //Clicks the login link
        WebElement loginLink = wait.until(ExpectedConditions.elementToBeClickable(By.id("nav-link-login")));
        loginLink.click();

        //Validate Sign In form is visible
        WebElement signInForm = driver.findElement(By.cssSelector(".h4"));
        wait.until(ExpectedConditions.visibilityOf(signInForm));

        //Input valid username
        WebElement usernameField = driver.findElement(By.id("defaultLoginFormUsername"));
        usernameField.sendKeys(username);

        //Input valid password
        WebElement passwordField = driver.findElement(By.name("password"));
        passwordField.sendKeys(password);

        //Clicks the "Sign In" button
        WebElement signInButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("sign-in-button")));
        signInButton.click();

        //Clicks the Profile button
        WebElement profileLink = wait.until(ExpectedConditions.elementToBeClickable(By.id("nav-link-profile")));
        profileLink.click();

        //Checks that the username matches the username provided
        Boolean isElementTextDisplayed = wait.until(ExpectedConditions.textToBe(By.tagName("h2"), username));
        Assert.assertTrue(isElementTextDisplayed, "The name of the user is displayed");

        //Get the number of posts
        String numberOfPosts = driver.findElement(By.xpath("//li[contains(text(), \"posts\")]")).getText();
        System.out.println("The number of posts is: " + numberOfPosts);

        //Get the number of followers
        String numberOfFollowers = driver.findElement(By.id("followers")).getText();
        System.out.println("The number of followers is: " + numberOfFollowers);

        //Get the number of followings
        String numberOfFollowings = driver.findElement(By.id("following")).getText();
        System.out.println("The number of followings is: " + numberOfFollowings);

        //Clicks on "All" posts
        WebElement allPosts = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(text(), \"All\")]")));
        allPosts.click();

        //Clicks on "Public" posts
        WebElement publicPosts = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(text(), \"Public\")]")));
        publicPosts.click();

        //Clicks on "Private" posts
        WebElement privatePosts = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(text(), \"Private\")]")));
        privatePosts.click();

    }
}
