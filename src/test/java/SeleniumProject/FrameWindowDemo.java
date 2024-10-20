package SeleniumProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

public class FrameWindowDemo {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.selenium.dev/selenium/web/window_switching_tests/page_with_frame.html");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        //driver.switchTo().frame("myframe");
        //driver.switchTo().frame(0);
        WebElement iframe = driver.findElement(By.tagName("iframe"));
        driver.switchTo().frame(iframe);
        Thread.sleep(2000);

        WebElement element = driver.findElement(By.xpath("//node()[text()='Simple page with simple test.']"));
        System.out.println(element.getText());
        driver.quit();
    }
}
