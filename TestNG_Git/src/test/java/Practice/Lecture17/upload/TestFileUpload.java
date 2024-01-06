package Practice.Lecture17.upload;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;
import java.io.File;

public class TestFileUpload extends TestClass {

    private WebDriver driver;

    public static void main(String[] args) {

    }

    @DataProvider(name = "getUsers")
    private Object[][] getUsers() {

        File postPicture = new File("src\\main\\resources\\upload\\AutomationQA.jpeg");
        String caption = "The image caption content";

        return new Object[][]{
                {"Test_MA", "Test123", postPicture, caption}
        };
    }

    //invocationCount shows how many times a test should be executed
    @Test(dataProvider = "getUsers")
    private void testFileUpload(String username, String password, File postPicture, String caption) {
        WebDriverWait wait = new WebDriverWait(super.getDriver(), Duration.ofSeconds(30));

        //Load Login Page
        LoginClass loginPage = new LoginClass(super.getDriver());
        loginPage.navigateTo();

        //Validate current URL
        loginPage.isUrlLoaded();

        //Get Sign in text
        String elemText = loginPage.getSignInText();
        Assert.assertEquals(elemText, "Sign in");

        //Login
        loginPage.login(username,password);

        //Click on new post
        HeaderClass headerPage = new HeaderClass(super.getDriver());
        headerPage.clickNewPost();

        //Post Page
        PostPage postPage = new PostPage(super.getDriver());
        Assert.assertTrue(postPage.isUrlLoaded());

        //Uploading a picture
        postPage.uploadPicture(postPicture);

        //Validate that the picture has been uploaded
        Assert.assertTrue(postPage.isImageVisible(), "The image is not uploaded!");

        //Validate that the right picture has been uploaded
        Assert.assertEquals(postPage.getImageName(), postPicture.getName());

        //Fill in caption
        postPage.populateCaption(caption);

        //Toggle to a Private Post
        postPage.privatePostToggle();

        //Click on the Create Post button
        postPage.clickCreatePost();
    }
}