package tests;

import flows.LoginFlow;
import flows.PurchaseFlow;
import models.CheckoutInformation;
import models.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import tests.base.BaseTest;
import utils.JsonDataReader;

public class ShoppingTest extends BaseTest {

    private LoginFlow loginFlow;
    private PurchaseFlow purchaseFlow;
    private User userPurchase = user("usuarioValido");
    private CheckoutInformation checkoutInformation = checkoutInformation("user1");

    @BeforeEach
    void initFlow(){
        loginFlow = new LoginFlow(driver);
        purchaseFlow = new PurchaseFlow(driver);
    }
    private User user(String userType) {
        return JsonDataReader.getUser(userType);
    }

    private CheckoutInformation checkoutInformation(String checkoutInformationUser){
        return JsonDataReader.getCheckoutInformation(checkoutInformationUser);
    }

    @Test
    @DisplayName("Compra de um Item")
    public void purchaseOneItem(){
        loginFlow.realizarLogin(userPurchase.getUser(), userPurchase.getPass());
        purchaseFlow.selectOneItemToCart();
        purchaseFlow.doCheckout(checkoutInformation.getFirstName(), checkoutInformation.getLastName(), checkoutInformation.getZipCode());
        purchaseFlow.finishCheckout();
    }

    @Test
    @DisplayName("Compra de dois Itens")
    public void purchaseTwoItems(){
        loginFlow.realizarLogin(userPurchase.getUser(), userPurchase.getPass());
        purchaseFlow.selectTwoItemsToCart();
        purchaseFlow.doCheckout(checkoutInformation.getFirstName(), checkoutInformation.getLastName(), checkoutInformation.getZipCode());
        purchaseFlow.finishCheckout();
    }
}