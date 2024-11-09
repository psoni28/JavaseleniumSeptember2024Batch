package factoryPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {

    WebDriver driver;

    public LandingPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//node()[text()='Products']")
    WebElement productText;

    @FindBy(xpath = "(//button[text()='Add to cart'])[1]")
    WebElement firstProductAddToCartButton;

    @FindBy(xpath = "//a[@class='shopping_cart_link']")
    WebElement shoppingCartLink;

    public boolean isProductTextDisplayed() {
        return
                productText.isDisplayed();
    }

    public void performAddToCart() {
        firstProductAddToCartButton.click();
    }

    public void goToCart() {
        shoppingCartLink.click();
    }
}
