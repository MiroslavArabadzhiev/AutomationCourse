package Practice.Lecture14;

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


public class PracticingWaits {

    private WebDriver driver;
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
    private void testRegistration() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        //Open the Skillo website
        driver.get("http://training.skillo-bg.com:4300/");
        wait.until(ExpectedConditions.urlContains("http://training.skillo-bg.com:4300/"));

        //Validate page title is matching the expected page
        String pageTitle = driver.getTitle();
        Assert.assertEquals(pageTitle, "ISkillo");

        //Clicks the login link
        WebElement loginLink = wait.until(ExpectedConditions.elementToBeClickable(By.id("nav-link-login")));
        loginLink.click();

        //Validate Sign In form is visible
        WebElement signInForm = driver.findElement(By.cssSelector(".h4"));
        wait.until(ExpectedConditions.visibilityOf(signInForm));

        //Click the Register button
        WebElement registerButton = driver.findElement(By.linkText("Register"));
        registerButton.click();

        //Validate the URL of the Registration form
        String expectedURL = "http://training.skillo-bg.com:4300/users/register";
        wait.until(ExpectedConditions.urlToBe(expectedURL));

        //Validate Sign Up form is visible
        WebElement signUpForm = driver.findElement(By.xpath("//*[contains(text(), \"Sign up\")]"));
        wait.until(ExpectedConditions.visibilityOf(signUpForm));

        //Input username
        WebElement usernameField = driver.findElement(By.name("username"));
        String username = generateRandomString(7,10);
        usernameField.sendKeys(username);

        //Input email
        WebElement emailField = driver.findElement(By.xpath("//*[@formcontrolname=\"email\"]"));
        String email = generateRandomEmail(5,8);
        emailField.sendKeys(email);

        //Add birthday
        WebElement birthdayField = driver.findElement(By.xpath("//*[@formcontrolname=\"birthDate\"]"));
        String birthday = "01012000";
        birthdayField.sendKeys(birthday);

        //Input password
        WebElement passwordField = driver.findElement(By.xpath("//*[@formcontrolname=\"password\"]"));
        passwordField.sendKeys(password);

        //Input confirm password
        WebElement confirmPasswordField = driver.findElement(By.xpath("//*[@formcontrolname=\"confirmPassword\"]"));
        confirmPasswordField.sendKeys(password);

        //Input Public Info
        WebElement publicInfoField = driver.findElement(By.xpath("//*[@formcontrolname=\"publicInfo\"]"));
        String publicInfo = generateRandomString(10,15);
        publicInfoField.sendKeys(publicInfo);

        //Click the Sign In button
        WebElement signInButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("sign-in-button")));
        signInButton.click();

        //Wait for page reload
        wait.until(ExpectedConditions.urlToBe("http://training.skillo-bg.com:4300/posts/all"));

        //Click on Profile
        WebElement profileLink = wait.until(ExpectedConditions.elementToBeClickable(By.id("nav-link-profile")));
        profileLink.click();

        //Validate user profile link
        wait = new WebDriverWait(driver, Duration.ofMinutes(1));
        wait.until(ExpectedConditions.urlContains("http://training.skillo-bg.com:4300/users/"));

        //Validate username
        Boolean isTextDisplayed = wait.until(ExpectedConditions.textToBe(By.tagName("h2"),username));
        Assert.assertTrue(isTextDisplayed, "The name is not matching");
    }

    private String generateRandomString(int minLenghtInclusive, int maxLenghtInclusive) {
        return RandomStringUtils.randomAlphanumeric(minLenghtInclusive, maxLenghtInclusive);
    }

    private String generateRandomEmail(int minLenghtInclusive, int maxLenghtInclusive) {
        return RandomStringUtils.randomAlphanumeric(minLenghtInclusive, maxLenghtInclusive) + "@gmail.com";
    }

}