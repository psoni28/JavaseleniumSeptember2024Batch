package SeleniumProject;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ElementScreenShotDemo {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.amazon.in/");
        driver.manage().window().maximize();
        System.out.println(driver.getTitle());

        WebElement link = driver.findElement(By.xpath("//a[@id='nav-hamburger-menu']"));
        scrollTOElement(driver, link);

        File source = link.getScreenshotAs(OutputType.FILE);

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
