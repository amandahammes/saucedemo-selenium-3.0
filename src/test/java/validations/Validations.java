package validations;

import pages.InventoryPage;
import pages.LoginPage;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;

public class Validations {
    private LoginPage loginPage;
    private InventoryPage inventoryPage;

    public Validations(LoginPage loginPage, InventoryPage inventoryPage) {
        this.loginPage = loginPage;
        this.inventoryPage = inventoryPage;
    }

    public void validarMensagemErroLogin(){
        assertThat(loginPage.pegarMensagemErro())
                .as("Mensagem de erro de login (sem credenciais ou credenciais inválidas).")
                .isNotNull()
                .isNotEmpty()
                .contains("Epic sadface");
    }

    public void validarLoginComSucesso(){
        assertThatCode(() -> inventoryPage.esperarListaProdutosVisivel())
                .as("Login realizado com sucesso.")
                .doesNotThrowAnyException();
    }

}
