package SeleniumProject;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

//Note: Full page screenshot method is only available with firefox driver
public class FullPageScreenShotDemo {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.amazon.in/");
        driver.manage().window().maximize();
        System.out.println(driver.getTitle());

       // WebElement footer = driver.findElement(By.xpath("//*[text()='Connect with Us']"));
        //scrollTOElement(driver, footer);

        File source = ((FirefoxDriver) driver).getFullPageScreenshotAs(OutputType.FILE);
        try {
            FileHandler.copy(source, new File(System.getProperty("user.dir") + "\\screenshot\\" + getTimeStamp() + ".png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        driver.quit();
    }

    public static String getTimeStamp() {
        LocalDateTime now = LocalDateTime.now();

// Define the format
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");

// Format the current date and time
        String formattedNow = now.format(formatter);

// Print the formatted date and time
        System.out.println("Current Timestamp:" + formattedNow);
        return formattedNow;
    }

    public static void scrollTOElement(WebDriver driver, WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }
}
