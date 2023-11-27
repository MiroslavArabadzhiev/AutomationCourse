package Practice.Lecture13;

import io.github.bonigarcia.wdm.WebDriverManager;
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


public class Practice {

    private WebDriver driver;
    public static void main(String[] args) {

    }

    @BeforeSuite
    protected final void setupTestSuite(){
        WebDriverManager.edgedriver().setup();
        WebDriverManager.chromedriver().setup();
        WebDriverManager.firefoxdriver().setup();
    }

    @BeforeMethod
    protected final void setupMethod(){
        this.driver = new EdgeDriver();
        this.driver.manage().window().maximize();
        this.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    @AfterMethod
    protected final void tearDownTest(){
        if(this.driver != null){
            this.driver.close();
        }
    }

    @DataProvider(name = "getUsers")
    private Object[][] getUsers(){
        return new Object[][]{
                {"Test_MA","Test123","Test_MA"}
        };
    }

    //invocationCount shows how many times a test should be executed
    @Test(invocationCount = 3, dataProvider = "getUsers")
    private void testLogin(String username, String password, String usernameProfilePage){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        //Open the Skillo website
        driver.get("http://training.skillo-bg.com:4300/");
        wait.until(ExpectedConditions.urlContains("http://training.skillo-bg.com:4300/"));

        //Validate page title is matching the expected page
        String pageTitle = driver.getTitle();
        Assert.assertEquals(pageTitle,"ISkillo");

        //Clicks the login link
        WebElement loginLink = driver.findElement(By.id("nav-link-login"));
        wait.until(ExpectedConditions.visibilityOf(loginLink));
        loginLink.click();

        //Validate if we are on the correct URL of the login link
        String currentURL = driver.getCurrentUrl();
        String expectedURL = "http://training.skillo-bg.com:4300/users/login";
        wait.until(ExpectedConditions.urlToBe(expectedURL));

        //Validate Sign In form is visible
        WebElement signInForm = driver.findElement(By.cssSelector(".h4"));
        wait.until(ExpectedConditions.visibilityOf(signInForm));
        Assert.assertTrue(signInForm.isDisplayed(), "The Sign In form is not visible");

        //Input valid username
        WebElement usernameField = driver.findElement(By.id("defaultLoginFormUsername"));
        usernameField.sendKeys(username);

        //Input valid password
        WebElement passwordField = driver.findElement(By.name("password"));
        passwordField.sendKeys(password);

        //Clicks the Remember Me checkbox
        WebElement remeberMeCheckbox = driver.findElement(By.xpath("//*[@formcontrolname=\"rememberMe\"]"));
        remeberMeCheckbox.click();

        //Validate if the Remember Me checkbox is selected
        Assert.assertTrue(remeberMeCheckbox.isSelected(), "The Remember Me checkbox is not selected");

        //Validate the Sign In button is enabled
        WebElement signInButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("sign-in-button")));

        //Clicks the Sign In button
        signInButton.click();

        //Validate the Profile link
        WebElement profileLink = wait.until(ExpectedConditions.elementToBeClickable(By.id("nav-link-profile")));

        //Clicks the Profile button
        profileLink.click();

        //Validate the Profile's URL
        wait.until(ExpectedConditions.urlContains("http://training.skillo-bg.com:4300/users"));

        //Validate the user's name on Profile page "h2"
        Boolean isElementTextDisplayed = wait.until(ExpectedConditions.textToBe(By.tagName("h2"), usernameProfilePage));
        Assert.assertTrue(isElementTextDisplayed, "The name of the user is displayed");
    }
}