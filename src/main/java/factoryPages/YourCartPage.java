package factoryPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class YourCartPage {

    WebDriver driver;
    @FindBy(id = "continue-shopping")
    WebElement continueShoppingButtonLink;

    public YourCartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void perFormContinueShopping() {
        continueShoppingButtonLink.click();
    }
}
