package SeleniumProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class WindowTabHandleMain {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.selenium.dev/selenium/web/window_switching_tests/page_with_frame.html");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        //driver.navigate().refresh();
        driver.manage().window().maximize();
        driver.findElement(By.linkText("Open new window")).click();
        Thread.sleep(2000);
        System.out.println(driver.getTitle());

        Set<String> ids = driver.getWindowHandles();
        Iterator<String> itr = ids.iterator();
        String firstWinId = itr.next();
        String secondWinId = itr.next();
        driver.switchTo().window(secondWinId);
        Thread.sleep(2000);
        System.out.println(driver.getTitle());
        //driver.close();
        driver.switchTo().window(firstWinId);
        Thread.sleep(2000);
        System.out.println(driver.getTitle());
        driver.quit();
    }
}