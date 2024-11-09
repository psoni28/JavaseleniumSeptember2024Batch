package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LandingPage {

    WebDriver driver;

  public LandingPage(WebDriver driver) {
        this.driver = driver;
    }

    By productText = By.xpath("//node()[text()='Products']");

    public boolean isProductTextDisplayed() {
        return driver.findElement(productText).isDisplayed();
    }
}
