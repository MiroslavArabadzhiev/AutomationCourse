package Practice.Lecture12;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

import static org.testng.Assert.assertEquals;


public class FirstSeleniumTests {

    public static void main(String[] args) {
        WebDriverManager.edgedriver().setup();
        //testMyFirstDriver();
        //testFindElement();
        //testFindElements();
        //testClick();
        //testSendKeys();
        //testClear();
        //testCommonCommands();
        testDropdown();

    }

    private static void testMyFirstDriver(){
        EdgeDriver driver = new EdgeDriver();
        driver.get("http://training.skillo-bg.com:4300/posts/all");
        driver.manage().window().maximize();
        driver.close();
    }

    private static void testFindElement() {

        EdgeDriver driver = new EdgeDriver();
        driver.get("http://training.skillo-bg.com:4300/posts/all");
        driver.manage().window().maximize();

//        WebElement loginLink = driver.findElement(By.id("nav-link-login"));
//        loginLink.click();

        WebElement homeElement = driver.findElement(By.linkText("Home"));
        homeElement.click();

        driver.close();
    }

    private static void testFindElements(){

        EdgeDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("http://training.skillo-bg.com:4300/posts/all");

        List<WebElement> posts = driver.findElements(By.xpath("//*[@class='post-feed-img']"));
        System.out.println("The number of elements is: " + posts.size());
        assertEquals(posts.size(),3);

        driver.close();

    }

    private static void testClick(){

        EdgeDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("http://training.skillo-bg.com:4300/posts/all");

        WebElement loginLink = driver.findElement(By.id("nav-link-login"));
        loginLink.click();

        driver.close();
    }

    private static void  testSendKeys(){

        EdgeDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("http://training.skillo-bg.com:4300/posts/all");

        WebElement loginLink = driver.findElement(By.id("nav-link-login"));
        loginLink.click();

        WebElement username = driver.findElement(By.id("defaultLoginFormUsername"));
        username.sendKeys("username");

        driver.close();
    }

    private static void  testClear(){

        EdgeDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("http://training.skillo-bg.com:4300/posts/all");

        WebElement loginLink = driver.findElement(By.id("nav-link-login"));
        loginLink.click();

        WebElement username = driver.findElement(By.id("defaultLoginFormUsername"));
        username.sendKeys("username");

        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("password");

        username.clear();

        username.sendKeys("anotherUsername");

        driver.close();
    }

    private static void  testCommonCommands() {

        EdgeDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("http://training.skillo-bg.com:4300/posts/all");

        String titleOfPage = driver.getTitle();
        System.out.println("The page title is: " + titleOfPage);

        WebElement loginLink = driver.findElement(By.id("nav-link-login"));
        loginLink.click();

        WebElement checkBox = driver.findElement(By.xpath("//*[@formcontrolname=\"rememberMe\"]"));
        checkBox.click();
        System.out.println("Is the element selected? " + checkBox.isSelected());

        WebElement textRememberMe = driver.findElement(By.xpath("//*[contains(text(), \"Remember me\")]"));
        System.out.println("The text is: " + textRememberMe.getText());

        WebElement signInButton = driver.findElement(By.id("sign-in-button"));
        System.out.println("Is the button displayed? " + signInButton.isDisplayed());
        System.out.println("Is the button enabled? " + signInButton.isEnabled());

        driver.close();
    }

    private static void  testDropdown() {

        EdgeDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.mobile.bg/pcgi/mobile.cgi");

        //Closes the pop-up window
        WebElement siteClick = driver.findElement(By.xpath("//*[contains(text(), \"Към сайта\")]"));
        siteClick.click();

        Select dropdown = new Select(driver.findElement(By.name("pubtype")));
        dropdown.selectByVisibleText("Ремаркета");


        driver.close();


    }


}