package SeleniumProject;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class ActionsDemoForSimpleActions {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();

        driver.get("https://demoqa.com/droppable");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();


        WebElement dragMe = driver.findElement(By.id("draggable"));
        WebElement dropped = driver.findElement(By.id("droppable"));
        scrollTOElement(driver, dragMe);
        Thread.sleep(5000);

        Actions actions = new Actions(driver);

        actions.doubleClick(dropped).build().perform();
        // actions.dragAndDrop(dragMe, dropped).build().perform();

        // actions.contextClick(dragMe).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();

        //actions.clickAndHold(dragMe).moveToElement(dropped).release().build().perform();
        Thread.sleep(5000);
        driver.quit();


    }

    public static void scrollTOElement(WebDriver driver, WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }
}
