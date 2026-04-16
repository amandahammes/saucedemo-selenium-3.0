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

public class CheckoutTest extends BaseTest {
    private LoginFlow loginFlow;
    private PurchaseFlow purchaseFlow;
    private User userPurchase = user("usuarioValido");
    private CheckoutInformation checkoutInformation;

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
    @DisplayName("Checkout sem First Name")
    public void shouldFailDoingCheckoutWithoutFirstName(){
        checkoutInformation = checkoutInformation("userWithoutFirstname");
        loginFlow.realizarLogin(userPurchase.getUser(), userPurchase.getPass());
        purchaseFlow.selectOneItemToCart();
        purchaseFlow.doCheckout(checkoutInformation.getFirstName(), checkoutInformation.getLastName(), checkoutInformation.getZipCode());
    }

    @Test
    @DisplayName("Checkout sem Last Name")
    public void shouldFailDoingCheckoutWithoutLastName(){
        checkoutInformation = checkoutInformation("userWithoutLastname");
        loginFlow.realizarLogin(userPurchase.getUser(), userPurchase.getPass());
        purchaseFlow.selectOneItemToCart();
        purchaseFlow.doCheckout(checkoutInformation.getFirstName(), checkoutInformation.getLastName(), checkoutInformation.getZipCode());
    }

    @Test
    @DisplayName("Checkout sem Zip Code")
    public void shouldFailDoingCheckoutWithoutZipCode(){
        checkoutInformation = checkoutInformation("userWithoutZipCode");
        loginFlow.realizarLogin(userPurchase.getUser(), userPurchase.getPass());
        purchaseFlow.selectOneItemToCart();
        purchaseFlow.doCheckout(checkoutInformation.getFirstName(), checkoutInformation.getLastName(), checkoutInformation.getZipCode());
    }
}