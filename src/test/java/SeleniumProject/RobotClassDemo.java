package SeleniumProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.awt.*;
import java.awt.event.KeyEvent;

public class RobotClassDemo {
    public static void main(String[] args) throws AWTException, InterruptedException {
        //System.setProperty("webdriver.chrome.driver", "/home/knoldus/Downloads/Ajax handling/browser driver/chromedriver_linux64/chromedriver"); //memory space for your chrome driver
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.guvi.in"); // sample url
        driver.findElement(By.linkText("Courses")).click();
        Robot robot = new Robot();  // Robot class throws AWT Exception
        Thread.sleep(4000);
        robot.keyPress(KeyEvent.VK_DOWN);// moving the keyboard key down.
        Thread.sleep(4000);
        robot.keyPress(KeyEvent.VK_TAB);
        Thread.sleep(4000);
        System.out.println("a");
        robot.keyPress(KeyEvent.VK_TAB);//pressing the tab key
        Thread.sleep(4000);
        System.out.println("b");
        robot.keyPress(KeyEvent.VK_TAB);
        Thread.sleep(4000);
        System.out.println("b");
        robot.keyPress(KeyEvent.VK_TAB);
        Thread.sleep(4000);
        System.out.println("b");
        robot.keyPress(KeyEvent.VK_TAB);
        Thread.sleep(4000);
        System.out.println("c");
        robot.mouseMove(30, 100);//moving the mouse.
        Thread.sleep(4000);
        System.out.println("d");
    }
}

