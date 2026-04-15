package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.WaitUtils;

public class CheckoutCompletePage {
    WebDriver driver;
    WaitUtils wait;

    private By buttonBackHomePage = By.id("back-to-products");

    public CheckoutCompletePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WaitUtils(driver);
    }

    public void backHomePage(){
        wait.waitForClickability(buttonBackHomePage).click();
    }
}