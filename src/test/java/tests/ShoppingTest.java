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

public class ShoppingTest extends BaseTest {

    private LoginFlow loginFlow;
    private PurchaseFlow purchaseFlow;
    private User userPurchase = usuario("usuarioValido");
    private CheckoutInformation checkoutInformation = checkoutInformation("user1");
    private Validations validations;

    @BeforeEach
    void initFlow(){
        loginFlow = new LoginFlow(driver);
        purchaseFlow = new PurchaseFlow(driver);
        validations = new Validations(loginFlow.getLoginPage(), loginFlow.getInventoryPage(), purchaseFlow.getCartPage(), purchaseFlow.getFinishOrderPage());
    }
    private User usuario(String userType) {
        return JsonDataReader.getUser(userType);
    }

    private CheckoutInformation checkoutInformation(String checkoutInformationUser){
        return JsonDataReader.getCheckoutInformation(checkoutInformationUser);
    }

    @Test
    @DisplayName("Compra de um Item")
    public void reaLizarCompraDeUmItem(){
        loginFlow.realizarLogin(userPurchase.getUser(), userPurchase.getPass());
        validations.validarLoginComSucesso();
        purchaseFlow.selectOneItemToCart();
        validations.validarItemNoCarrinho();
        purchaseFlow.goToCheckout();
        purchaseFlow.doCheckout(checkoutInformation.getFirstName(), checkoutInformation.getLastName(), checkoutInformation.getZipCode());
        purchaseFlow.finishCheckout();
        validations.validarFinalizacaoCompra();
        loginFlow.realizarLogout();
        validations.validarPaginaLogin();
    }

    @Test
    @DisplayName("Compra de dois Itens")
    public void realizarCompraDeDoisItens(){
        loginFlow.realizarLogin(userPurchase.getUser(), userPurchase.getPass());
        validations.validarLoginComSucesso();
        purchaseFlow.selectTwoItemsToCart();
        validations.validarItemNoCarrinho();
        purchaseFlow.goToCheckout();
        purchaseFlow.doCheckout(checkoutInformation.getFirstName(), checkoutInformation.getLastName(), checkoutInformation.getZipCode());
        purchaseFlow.finishCheckout();
        validations.validarFinalizacaoCompra();
        loginFlow.realizarLogout();
        validations.validarPaginaLogin();
    }
}