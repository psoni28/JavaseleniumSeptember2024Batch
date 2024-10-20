package SeleniumProject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class FormFilling {

    public static void main(String args[]) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/automation-practice-form/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();
        driver.findElement(By.id("firstName")).sendKeys("rohan");
        driver.findElement(By.id("lastName")).sendKeys("sehgal");
        driver.findElement(By.xpath("//input[@id='userEmail']")).sendKeys("rohansehal@gmail.com");

        WebElement radioLabelMale = driver.findElement(By.xpath("//label[@for='gender-radio-1']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", radioLabelMale);
        radioLabelMale.click();

        WebElement datOfBirth = driver.findElement(By.id("dateOfBirthInput"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", datOfBirth);
        datOfBirth.clear();
        datOfBirth.sendKeys("19 Oct 2095");
        driver.findElement(By.xpath("//*[text()='Date of Birth']")).click();

        WebElement hobbies = driver.findElement(By.xpath("//label[@for='hobbies-checkbox-2']"));
        scrollTOElement(driver, hobbies);
        hobbies.click();

        driver.findElement(By.cssSelector("input#uploadPicture")).sendKeys("C:\\Users\\Admin\\Downloads\\download.png");
        driver.findElement(By.id("currentAddress")).sendKeys("Viman nagar four point pune");

        driver.findElement(By.id("submit")).click();

        Thread.sleep(5000);
        driver.quit();

    }

    public static void scrollTOElement(WebDriver driver, WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }
}
