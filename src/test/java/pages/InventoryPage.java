package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.WaitUtils;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class InventoryPage {


    private WebDriver driver;
    private WaitUtils wait;

    private By buttonAddBackPack = By.id("add-to-cart-sauce-labs-backpack");
    private By buttonRemoveBackPack = By.id("remove-sauce-labs-backpack");

    public InventoryPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WaitUtils(driver);
    }

    public void addItemToCart(String productName){
        String formattedName = productName.toLowerCase().replace(" ", "-");
        By buttonId = By.id("add-to-cart-" + formattedName);
        wait.waitForClickability(buttonId).click();
    }

    public void addProducts(String... productNames){
        for (String name : productNames){
            addItemToCart(name);
        }
    }

    public String randomicItem(){
        List<String> products = Arrays.asList(
                "Sauce Labs Backpack",
                "Sauce Labs Bike Light",
                "Sauce Labs Bolt T-Shirt",
                "Sauce Labs Fleece Jacket",
                "Sauce Labs Onesie",
                "Test.allTheThings() T-Shirt (Red)"
        );

        Random random = new Random();
        int sortedProduct = random.nextInt(products.size());
        String selectProduct = products.get(sortedProduct);

        return selectProduct;
    }
}
