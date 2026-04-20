package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.WaitUtils;

public class CheckoutOnePage {
    WebDriver driver;
    WaitUtils wait;

    private By inputFirstName = By.id("first-name");
    private By inputLastName = By.id("last-name");
    private By inputZipCode = By.id("postal-code");
    private By buttonContinue = By.id("continue");
    private By mensagemErro = By.cssSelector("[data-test='error']");

    public CheckoutOnePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WaitUtils(driver);
    }

    public void fillInCheckoutDetails(String firstName, String lastName, String zipCode){
        wait.waitForVisibility(inputFirstName).sendKeys(firstName);
        wait.waitForVisibility(inputLastName).sendKeys(lastName);
        wait.waitForVisibility(inputZipCode).sendKeys(zipCode);
        wait.waitForClickability(buttonContinue).click();
    }

    public String pegarMensagemErro(){
        return wait.waitForVisibility(mensagemErro).getText();
    }
}