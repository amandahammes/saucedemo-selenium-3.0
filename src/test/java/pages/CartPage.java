package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.WaitUtils;

public class CartPage {

    private WebDriver driver;
    private WaitUtils wait;

    By buttonCheckout = By.id("checkout");

    public CartPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WaitUtils(driver);
    }

    public void madeCheckout(){
        wait.waitForClickability(buttonCheckout).click();
    }
}