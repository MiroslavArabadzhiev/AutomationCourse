package Practice.Lecture16.object;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

import static org.testng.Assert.assertEquals;


public class PageObject {

    private WebDriver driver;


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
            this.driver.quit();
        }
    }

    @DataProvider(name = "getUsers")
    private Object[][] getUsers() {
        return new Object[][]{
                {"Test_MA", "Test123", "Test_MA"}
        };
    }

    //invocationCount shows how many times a test should be executed
    @Test(dataProvider = "getUsers")
    private void testLogin(String username, String password, String usernameProfilePage) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        //Home Page Class
        HomePage homePage = new HomePage(driver);
        homePage.navigatTo();
        homePage.isUrlLoaded();

        //Header Class
        HeaderClass headerMenu = new HeaderClass(driver);
        headerMenu.clickLoginLink();

        //Login Class
        LoginClass loginPage = new LoginClass(driver);
        loginPage.isUrlLoaded();

        //Get Sign in text
        String elemText = loginPage.getSignInText();
        Assert.assertEquals(elemText, "Sign in");

        //Input valid username
        loginPage.populateUsername(username);

        //Input valid password
        loginPage.populatePassword(password);

        //Click the Sign in button
        loginPage.clickSignIn();

        //Click the Profile button
        headerMenu.clickProfileLink();

        //Create Profile Class
        ProfileClass profilePage = new ProfileClass(driver);
        profilePage.isUrlLoaded();

        //Get Logged in user text
        Assert.assertEquals(profilePage.getUsername(), usernameProfilePage);
    }
}