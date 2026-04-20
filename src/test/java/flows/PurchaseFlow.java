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
    private FinishOrderPage finishOrderPage;

    public PurchaseFlow(WebDriver driver) {
        this.inventoryPage = new InventoryPage(driver);
        this.headerComponent = new HeaderComponent(driver);
        this.checkoutOnePage = new CheckoutOnePage(driver);
        this.checkoutTwoPage = new CheckoutTwoPage(driver);
        this.checkoutCompletePage = new CheckoutCompletePage(driver);
        this.cartPage = new CartPage(driver);
        this.finishOrderPage = new FinishOrderPage(driver);
    }

    public void goToCheckout(){
        cartPage.madeCheckout();
    }

    public void selectOneItemToCart(){
        String productToSelect = inventoryPage.randomicItem();
        inventoryPage.addItemToCart(productToSelect);
        headerComponent.irParaCarrinho();
    }

    public void selectTwoItemsToCart(){
        String productToSelect1 = inventoryPage.randomicItem();
        String productToSelect2 = inventoryPage.randomicItem();
        inventoryPage.addProducts(productToSelect1, productToSelect2);
        headerComponent.irParaCarrinho();
    }

    public void doCheckout(String firstName, String lastName, String zipCode){
        checkoutOnePage.fillInCheckoutDetails(firstName, lastName, zipCode);
    }

    public void finishCheckout(){
        checkoutTwoPage.finalizandoCheckout();
    }

    public CheckoutOnePage getCheckoutOnePage(){
        return this.checkoutOnePage;
    }

    public CartPage getCartPage(){
        return  this.cartPage;
    }

    public FinishOrderPage getFinishOrderPage(){
        return this.finishOrderPage;
    }
}