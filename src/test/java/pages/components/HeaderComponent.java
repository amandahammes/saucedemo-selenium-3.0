package pages.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.WaitUtils;

public class HeaderComponent {
    private WebDriver driver;
    private WaitUtils wait;

    private By buttonMenu = By.id("react-burger-menu-btn");
    private By buttonCart = By.id("shopping_cart_container");

    public HeaderComponent(WebDriver driver) {
        this.driver = driver;
        this.wait = new WaitUtils(driver);
    }

    public void irParaCarrinho(){
        wait.waitForClickability(buttonCart).click();
    }

    public void irParaMenu(){
        wait.waitForClickability(buttonMenu).click();
    }


}
