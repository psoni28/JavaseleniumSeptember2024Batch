package SeleniumProject;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ConfirmationAlertsDemo {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/alerts");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().window().maximize();
        WebElement button = driver.findElement(By.xpath("//*[@id='confirmButton']"));
        scrollTOElement(driver, button);
        button.click();
        Alert alert = driver.switchTo().alert();
        Thread.sleep(2000);
        //alert.accept();
        alert.dismiss();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement element = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("confirmResult"))));
        System.out.println("visible element text :" + element.getText());

        if (element.getText().equalsIgnoreCase("You selected Cancel"))
            System.out.println("correct cancel button selected");
        else
            System.out.println("Incorrect cancel button selected");

        Thread.sleep(2000);
        driver.quit();
    }

    public static void scrollTOElement(WebDriver driver, WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }
}
