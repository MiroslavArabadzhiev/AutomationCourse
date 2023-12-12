package Practice.Lecture17.download;

import Practice.Lecture17.upload.TestClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.time.Duration;

public class DownloadFiles extends TestClass {

    @Test
    public void testDownload() throws InterruptedException {
        WebDriver driver = super.getDriver();
        driver.get("https://demoqa.com/upload-download");
        WebElement downloadButton = driver.findElement(By.id("downloadButton"));
        downloadButton.click();

        String fileName = "sampleFile.jpeg";
        File file = new File(DOWNLOAD_DIR.concat(fileName));
        Assert.assertTrue(super.isFilePresent(file), "The file is not downloaded!");
    }
}