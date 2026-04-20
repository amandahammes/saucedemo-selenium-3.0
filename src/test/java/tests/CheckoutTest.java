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
import validations.Validations;

public class CheckoutTest extends BaseTest {
    private LoginFlow loginFlow;
    private PurchaseFlow purchaseFlow;
    private User userPurchase = usuario("usuarioValido");
    private CheckoutInformation checkoutInformation;
    private Validations validations;

    @BeforeEach
    void initFlow(){
        loginFlow = new LoginFlow(driver);
        purchaseFlow = new PurchaseFlow(driver);
        validations = new Validations(purchaseFlow.getCheckoutOnePage());
    }
    private User usuario(String userType) {
        return JsonDataReader.getUser(userType);
    }

    private CheckoutInformation checkoutInformation(String checkoutInformationUser){
        return JsonDataReader.getCheckoutInformation(checkoutInformationUser);
    }

    @Test
    @DisplayName("Checkout sem First Name")
    public void deveFalharAoRealizarCheckoutSemPrimeiroNome(){
        checkoutInformation = checkoutInformation("userWithoutFirstname");
        loginFlow.realizarLogin(userPurchase.getUser(), userPurchase.getPass());
        purchaseFlow.selectOneItemToCart();
        purchaseFlow.goToCheckout();
        purchaseFlow.doCheckout(checkoutInformation.getFirstName(), checkoutInformation.getLastName(), checkoutInformation.getZipCode());
        validations.validarMensagemErroCheckout();
    }

    @Test
    @DisplayName("Checkout sem Last Name")
    public void deveFalharAoRealizarCheckoutSemSobrenome(){
        checkoutInformation = checkoutInformation("userWithoutLastname");
        loginFlow.realizarLogin(userPurchase.getUser(), userPurchase.getPass());
        purchaseFlow.selectOneItemToCart();
        purchaseFlow.goToCheckout();
        purchaseFlow.doCheckout(checkoutInformation.getFirstName(), checkoutInformation.getLastName(), checkoutInformation.getZipCode());
        validations.validarMensagemErroCheckout();
    }

    @Test
    @DisplayName("Checkout sem Zip Code")
    public void deveFalharAoRealizarCheckoutSemCodigoPostal(){
        checkoutInformation = checkoutInformation("userWithoutZipCode");
        loginFlow.realizarLogin(userPurchase.getUser(), userPurchase.getPass());
        purchaseFlow.selectOneItemToCart();
        purchaseFlow.goToCheckout();
        purchaseFlow.doCheckout(checkoutInformation.getFirstName(), checkoutInformation.getLastName(), checkoutInformation.getZipCode());
        validations.validarMensagemErroCheckout();
    }
}