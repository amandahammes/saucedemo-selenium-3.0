package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.WaitUtils;

public class FinishOrderPage {
    WebDriver driver;
    WaitUtils wait;

    private By mensagemCheckoutCompleto = By.id("checkout_complete_container");

    public FinishOrderPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WaitUtils(driver);
    }

    public void esperarMensagemCheckoutCompleto(){
        wait.waitForVisibility(mensagemCheckoutCompleto);
    }
}
