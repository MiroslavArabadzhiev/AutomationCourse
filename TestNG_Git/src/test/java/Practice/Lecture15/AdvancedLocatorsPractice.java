package Practice.Lecture15;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertEquals;


public class AdvancedLocatorsPractice {

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

    //invocationCount shows how many times a test should be executed
    @Test()
    private void testCheckBox() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        //Open the DemoQA website
        driver.get("https://demoqa.com/checkbox");
        wait.until(ExpectedConditions.urlContains("https://demoqa.com"));

        //Clicks the "Home" label
        WebElement homeLabel = driver.findElement(By.cssSelector(".rct-title"));
        homeLabel.click();

        //Checks if the "Home" label is selected
        WebElement checkBox = driver.findElement(By.id("tree-node-home"));
        Assert.assertTrue(checkBox.isSelected());

        //Checks if the text is displayed
        WebElement result = driver.findElement(By.id("result"));
        Assert.assertTrue(result.isDisplayed());

        //Uncheck the "Home" label
        homeLabel.click();

        //Validate the "Home" label is unchecked
        Assert.assertFalse(checkBox.isSelected());
    }

    @Test
    public void testCheckBoxExpand(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        //Open the DemoQA website
        driver.get("https://demoqa.com/checkbox");
        wait.until(ExpectedConditions.urlContains("https://demoqa.com"));

        //Clicks on the arrow to expand the Home menu
        WebElement homeArrow = driver.findElement(By.xpath("//*[@for=\"tree-node-home\"]/preceding-sibling::button"));
        homeArrow.click();

        //Clicks the "Documents" label
        WebElement documentsLabel = driver.findElement(By.xpath("//label[@for=\"tree-node-documents\"]"));
        documentsLabel.click();

        //Checks if the "Documents" label is selected
        WebElement documentsCheckBox = driver.findElement(By.id("tree-node-documents"));
        Assert.assertTrue(documentsCheckBox.isSelected());

        //Checks if the text is displayed
        WebElement documentsText = driver.findElement(By.id("result"));
        Assert.assertTrue(documentsText.isDisplayed());
    }

    @Test
    public void testRadioButtons(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        //Open the DemoQA website
        driver.get("https://demoqa.com/radio-button");
        wait.until(ExpectedConditions.urlContains("https://demoqa.com"));

        //Clicks on the "Yes" radio button
        WebElement yesButton = driver.findElement(By.xpath("//*[@for=\"yesRadio\"]"));
        yesButton.click();

        //Checks if the "Yes" radio button is selected
        WebElement yesRadioButton = driver.findElement(By.id("yesRadio"));
        Assert.assertTrue(yesRadioButton.isSelected());

        //Checks if the text is displayed
        String yesText = driver.findElement(By.cssSelector(".mt-3")).getText();
        Assert.assertEquals(yesText, "You have selected Yes");

        //Clicks on the "Impressive" radio button
        WebElement impressiveButton = driver.findElement(By.xpath("//*[@for=\"impressiveRadio\"]"));
        impressiveButton.click();

        //Checks if the "Impressive" radio button is selected
        WebElement impressiveRadioButton = driver.findElement(By.id("impressiveRadio"));
        Assert.assertTrue(impressiveRadioButton.isSelected());

        //Checks if the text is displayed
        String impressiveText = driver.findElement(By.cssSelector(".mt-3")).getText();
        Assert.assertEquals(impressiveText, "You have selected Impressive");

        //Checks if the "No" radio button is disabled
        WebElement noRadioButton = driver.findElement(By.id("noRadio"));
        Assert.assertFalse(noRadioButton.isEnabled());
    }

    @Test
    public void testWebTables() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        //Open the DemoQA website
        driver.get("https://demoqa.com/webtables");
        wait.until(ExpectedConditions.urlContains("https://demoqa.com"));

        //Table locator
        WebElement table = driver.findElement(By.className("rt-table"));

        //Get header elements
        WebElement tableHeaders = table.findElement(By.className("-header"));
        List<WebElement> columnHeaders = tableHeaders.findElements(By.xpath("//*[@role=\"columnheader\"]"));

        //Find email in element index and store it
        int emailIndex = 0;

        for(WebElement column : columnHeaders){
            String columnName = column.getText();
            if(columnName.equalsIgnoreCase("email")){
                emailIndex = columnHeaders.indexOf(column);
            }
        }

        //Get table rows
        WebElement tableBody = table.findElement(By.className("rt-tbody"));
        //List contains all rows in the table
        List<WebElement> tableRows = tableBody.findElements(By.xpath("//*[@role=\"row\"]"));

        //Find row by email value and delete it (alden@example.com)
        for (WebElement row : tableRows){
            //List contains individual cells
            List<WebElement> cells = row.findElements(By.xpath("//*[@role=\"gridcell\"]"));
            String cellText = cells.get(emailIndex).getText();
            if(cellText.equalsIgnoreCase("alden@example.com")){
                //Delete row
                WebElement deleteButton = row.findElement(By.cssSelector("[id^=\"delete-record\"]"));
                deleteButton.click();
                break;
            }
        }

        //Get table rows
        tableBody = table.findElement(By.className("rt-tbody"));
        tableRows = tableBody.findElements(By.xpath("//*[@role=\"row\"]"));

        //Verify deleted row is removed
        for(WebElement row : tableRows){
            List<WebElement> cells = row.findElements(By.xpath("//*[@role=\"gridcell\"]"));
            String cellText = cells.get(emailIndex).getText();
            Assert.assertNotEquals(cellText,"alden@example.com");
        }
    }

    @Test
    public void testBrowserWindows() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        //Open the DemoQA website
        driver.get("https://demoqa.com/browser-windows");
        wait.until(ExpectedConditions.urlContains("https://demoqa.com"));

        //Clicks the "New Tab" button
        WebElement newTabButton = driver.findElement(By.id("tabButton"));
        newTabButton.click();

        //Check driver focus
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, "https://demoqa.com/browser-windows");

        //Get available browser tabs
        List<String> windows = new ArrayList<>(driver.getWindowHandles());
        String secondWindow = windows.get(1);

        //Switch to another tab
        driver.switchTo().window(secondWindow);

        //Check driver focus
        currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, "https://demoqa.com/sample");

        //Validate the text on the second window
        String displayedText = driver.findElement(By.id("sampleHeading")).getText();
        Assert.assertEquals(displayedText, "This is a sample page");

        //Return to initial window
        String firstWindow = windows.get(0);
        driver.switchTo().window(firstWindow);

        //Check driver focus
        currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, "https://demoqa.com/browser-windows");

        //driver.close() closes only the current window -> driver.quits() closes all open windows
    }

    @Test
    public void testAlerts() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        //Open the DemoQA website
        driver.get("https://demoqa.com/alerts");
        wait.until(ExpectedConditions.urlContains("https://demoqa.com"));

        //Clicks the first alert
        WebElement alertButton = driver.findElement(By.id("alertButton"));
        alertButton.click();

        //Interact with alerts
        Alert alert = driver.switchTo().alert();
        Assert.assertEquals(alert.getText(), "You clicked a button");

        //Accept the alert
        alert.accept();

        //After alert().accept() we can interact with elements from the main window
        alertButton.getText();
    }

    @Test
    public void testConfirmBox() {
        driver.get("https://demoqa.com/alerts");
        WebElement confirmBoxButton = driver.findElement(By.id("confirmButton"));
        confirmBoxButton.click();

        //Interact with ConfirmBox
        Alert alert = driver.switchTo().alert();

        //Confirm Box can be accepted or dismissed
        alert.dismiss();
        String actualMessage = driver.findElement(By.id("confirmResult")).getText();
        Assert.assertEquals(actualMessage, "You selected Cancel");
    }

    @Test
    public void testPromptBox() {
        driver.get("https://demoqa.com/alerts");
        WebElement promptBoxButton = driver.findElement(By.id("promtButton"));
        promptBoxButton.click();

        String name = "Kaloyan";

        //Interact with PromptBox
        Alert alert = driver.switchTo().alert();
        alert.sendKeys(name);
        alert.accept();

        String actualText = driver.findElement(By.id("promptResult")).getText();
        String expectedText = "You entered " + name;
        Assert.assertEquals(actualText, expectedText);
    }

    @Test
    public void testHoover() {
        driver.get("https://demoqa.com/tool-tips");
        WebElement element = driver.findElement(By.id("toolTipButton"));

        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
        String tooltipText = driver.findElement(By.className("tooltip-inner")).getText();
        Assert.assertEquals(tooltipText, "You hovered over the Button");
    }

    @Test
    public void testIFrames() {
        driver.get("https://demoqa.com/frames");

        //Find all iframes
        List<WebElement> iframes = driver.findElements(By.tagName("iframe"));

        /*
        iframe content is available after switch
        cannot execute before switch driver.findElement(By.id("sampleHeading")).getText();
        */
        //Switch by iframe name or id
        driver.switchTo().frame("frame1");
        String frameHeadingText = driver.findElement(By.id("sampleHeading")).getText();
        Assert.assertEquals(frameHeadingText, "This is a sample page");

        /*
        While driver is switched to particular frame the other page content is unavailable
        driver.findElement(By.cssSelector("#framesWrapper div")).getText();
         */

        //Go back to main page
        driver.switchTo().defaultContent();
        String mainPageText = driver.findElement(By.cssSelector("#framesWrapper div")).getText();
        Assert.assertEquals(mainPageText, "Sample Iframe page There are 2 Iframes in this page. Use browser inspecter or firebug to check out the HTML source. In total you can switch between the parent frame, which is this window, and the two frames below");

        //Switch to 3rd frame by index
        driver.switchTo().frame(2);
        frameHeadingText = driver.findElement(By.id("sampleHeading")).getText();
        Assert.assertEquals(frameHeadingText, "This is a sample page");

        //Switch to 2nd frame by WebElement
        driver.switchTo().defaultContent();
        iframes = driver.findElements(By.tagName("iframe"));
        WebElement iframeElement = iframes.get(2);
        driver.switchTo().frame(iframeElement);
        frameHeadingText = driver.findElement(By.id("sampleHeading")).getText();
        Assert.assertEquals(frameHeadingText, "This is a sample page");
    }
}