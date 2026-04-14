package flows;

import org.openqa.selenium.WebDriver;
import pages.*;
import pages.components.HeaderComponent;

public class PurchaseFlow {
    private HeaderComponent headerComponent;
    private InventoryPage inventoryPage;
    private CheckoutOnePage checkoutOnePage;
    private CheckoutTwoPage checkoutTwoPage;
    private CheckoutCompletePage checkoutCompletePage;
    private CartPage cartPage;

    public PurchaseFlow(WebDriver driver) {
        this.inventoryPage = new InventoryPage(driver);
        this.headerComponent = new HeaderComponent(driver);
        this.checkoutOnePage = new CheckoutOnePage(driver);
        this.checkoutTwoPage = new CheckoutTwoPage(driver);
        this.checkoutCompletePage = new CheckoutCompletePage(driver);
        this.cartPage = new CartPage(driver);
    }

    public void selectOneItemToCart(){
        String productToSelect = inventoryPage.randomicItem();
        inventoryPage.addItemToCart(productToSelect);
        headerComponent.goToCart();
        cartPage.madeCheckout();
    }

    public void selectTwoItemsToCart(){
        String productToSelect1 = inventoryPage.randomicItem();
        String productToSelect2 = inventoryPage.randomicItem();
        inventoryPage.addItemToCart(productToSelect1);
        inventoryPage.addItemToCart(productToSelect2);
        headerComponent.goToCart();
        cartPage.madeCheckout();
    }

    public void doCheckout(String firstName, String lastName, String zipCode){
        checkoutOnePage.fillInCheckoutDetails(firstName, lastName, zipCode);
    }

    public void finishCheckout(){
        checkoutTwoPage.finishingCheckout();
        checkoutCompletePage.backHomePage();
    }
}
