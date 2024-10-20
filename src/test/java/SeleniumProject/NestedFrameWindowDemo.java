package SeleniumProject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class NestedFrameWindowDemo {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/nestedframes");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().window().maximize();

        driver.switchTo().frame("frame1");
        driver.switchTo().frame(0);
        Thread.sleep(2000);

        WebElement element = driver.findElement(By.xpath("//*[text()='Child Iframe']"));
        scrollTOElement(driver, element);
        System.out.println(element.getText());

        driver.switchTo().defaultContent();
        WebElement element2 = driver.findElement(By.xpath("//h1[text()='Nested Frames']"));
        scrollTOElement(driver, element2);

        System.out.println(element2.getText());
        driver.quit();
    }

    public static void scrollTOElement(WebDriver driver, WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }
}
