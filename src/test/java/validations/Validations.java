package validations;

import pages.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;

public class Validations {
    private LoginPage loginPage;
    private InventoryPage inventoryPage;
    private CheckoutOnePage checkoutOnePage;
    private CartPage cartPage;
    private FinishOrderPage finishOrderPage;

    public Validations(LoginPage loginPage, InventoryPage inventoryPage, CartPage cartPage, FinishOrderPage finishOrderPage) {
        this.loginPage = loginPage;
        this.inventoryPage = inventoryPage;
        this.cartPage = cartPage;
        this.finishOrderPage = finishOrderPage;
    }

    public Validations(LoginPage loginPage, InventoryPage inventoryPage) {
        this.loginPage = loginPage;
        this.inventoryPage = inventoryPage;
    }

    public Validations(CheckoutOnePage checkoutOnePage) {
        this.checkoutOnePage = checkoutOnePage;

    }

    public void validarLoginComSucesso(){
        assertThatCode(() -> inventoryPage.esperarListaProdutosVisivel())
                .as("Usuário deve ver a lista de produtos após login.")
                .doesNotThrowAnyException();
    }

    public void validarMensagemErroLogin(){
        assertThat(loginPage.pegarMensagemErro())
                .as("Mensagem de erro de login (sem credenciais ou credenciais inválidas).")
                .isNotNull()
                .isNotEmpty()
                .contains("Epic sadface");
    }

    public void validarMensagemErroCheckout(){
        assertThat(checkoutOnePage.pegarMensagemErro())
                .as("Mensagem de erro de checkout (sem primeiro nome, sem último nome e/ou sem código postal).")
                .isNotNull()
                .isNotEmpty()
                .contains("Error")
                .contains("is required");
    }

    public void validarItemNoCarrinho(){
        assertThatCode(() -> cartPage.verificaExistenciaItensCarrinho())
                .as("Existência de itens no carrinho")
                .doesNotThrowAnyException();
    }

    public void validarFinalizacaoCompra(){
        assertThatCode(() -> finishOrderPage.esperarMensagemCheckoutCompleto())
                .as("Compra foi finalizada!")
                .doesNotThrowAnyException();
    }

    public void validarPaginaLogin(){
        assertThatCode(() -> loginPage.esperarCaixaLoginVisivel())
                .as("Está na página de login")
                .doesNotThrowAnyException();
    }

}
