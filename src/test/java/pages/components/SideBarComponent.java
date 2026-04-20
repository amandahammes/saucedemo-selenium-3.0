package pages.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.WaitUtils;

public class SideBarComponent {
    WebDriver driver;
    WaitUtils wait;

    private By botaoLogout = By.id("logout_sidebar_link");

    public SideBarComponent(WebDriver driver) {
        this.driver = driver;
        this.wait = new WaitUtils(driver);
    }

    public void realizarLogout(){
        wait.waitForClickability(botaoLogout).click();
    }
}