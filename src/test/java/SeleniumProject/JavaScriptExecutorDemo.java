package SeleniumProject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class JavaScriptExecutorDemo {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.amazon.in/");
        driver.manage().window().maximize();
        System.out.println(driver.getTitle());
        Thread.sleep(2000);

        WebElement link = driver.findElement(By.xpath("//a[text()='Mobiles']"));

      //  link.click();
        JavascriptExecutor js = ((JavascriptExecutor) driver);
       // js.executeScript("arguments[0].click();", link);
        //js.executeScript("alert('Welcome To Selenium Testing');");
        //js.executeScript("history.go(0)");

       // driver.navigate().refresh();

        String innerText = js.executeScript(" return document.documentElement.innerText;").toString();
        System.out.println(innerText);

        Thread.sleep(2000);

        //System.out.println(driver.getTitle());

        driver.quit();
    }
}
