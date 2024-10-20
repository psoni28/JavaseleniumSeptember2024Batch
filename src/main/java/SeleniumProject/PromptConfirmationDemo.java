package SeleniumProject;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PromptConfirmationDemo {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        //driver.get("https://demoqa.com/alerts");
        driver.navigate().to("https://demoqa.com/alerts");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().window().maximize();
        WebElement button = driver.findElement(By.xpath("//*[@id='promtButton']"));
        scrollTOElement(driver, button);
        button.click();
        Alert alert = driver.switchTo().alert();
        Thread.sleep(2000);
        alert.sendKeys("sonip");
        alert.accept();
        //alert.dismiss();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement element = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("promptResult"))));
        System.out.println("visible element text :" + element.getText());

        if (element.getText().equalsIgnoreCase("You entered sonip"))
            System.out.println("correct details are displayed");
        else
            System.out.println("Incorrect details are displayed");

        Thread.sleep(2000);
        driver.quit();
    }

    public static void scrollTOElement(WebDriver driver, WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }
}
