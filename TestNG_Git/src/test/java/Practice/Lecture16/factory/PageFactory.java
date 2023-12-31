package Practice.Lecture16.factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;


public class PageFactory extends TestClass{

    private WebDriver driver;

    public static void main(String[] args) {

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
        WebDriverWait wait = new WebDriverWait(super.getDriver(), Duration.ofSeconds(30));

        //Home Page Class
        HomePage homePage = new HomePage(super.getDriver());
        homePage.navigatTo();
        homePage.isUrlLoaded();

        //Header Class
        HeaderClass headerMenu = new HeaderClass(super.getDriver());
        headerMenu.clickLoginLink();

        //Login Class
        LoginClass loginPage = new LoginClass(super.getDriver());
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
        ProfileClass profilePage = new ProfileClass(super.getDriver());
        profilePage.isUrlLoaded();

        //Get Logged in user text
        Assert.assertEquals(profilePage.getUsername(), usernameProfilePage);
    }
}