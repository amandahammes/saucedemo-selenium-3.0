package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.WaitUtils;

public class CheckoutTwoPage {
    WebDriver driver;
    WaitUtils wait;

    private By buttonFinish = By.id("finish");

    public CheckoutTwoPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WaitUtils(driver);
    }

    public void finalizandoCheckout(){
        wait.waitForClickability(buttonFinish).click();
    }
}