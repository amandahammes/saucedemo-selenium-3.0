package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.WaitUtils;

public class CheckoutOnePage {
    WebDriver driver;
    WaitUtils wait;

    By inputFirstName = By.id("first-name");
    By inputLastName = By.id("last-name");
    By inputZipCode = By.id("postal-code");
    By buttonContinue = By.id("continue");

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
}