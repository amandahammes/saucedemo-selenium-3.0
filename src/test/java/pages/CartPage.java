package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.WaitUtils;

public class CartPage {

    private WebDriver driver;
    private WaitUtils wait;

    private By buttonCheckout = By.id("checkout");
    private By itensCarrinho = By.className("cart_item");

    public CartPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WaitUtils(driver);
    }

    public void madeCheckout(){
        wait.waitForClickability(buttonCheckout).click();
    }

    public void verificaExistenciaItensCarrinho(){
        wait.waitForVisibility(itensCarrinho);
    }
}