package flows;

import org.openqa.selenium.WebDriver;
import pages.InventoryPage;
import pages.LoginPage;

public class LoginFlow {
    private LoginPage loginPage;
    private InventoryPage inventoryPage;

    public LoginFlow (WebDriver driver){
        this.loginPage = new LoginPage(driver);
        this.inventoryPage = new InventoryPage(driver);
    }

    public void realizarLogin(String usuario, String senha){
        loginPage.preencherUsuario(usuario);
        loginPage.preencherSenha(senha);
        loginPage.clicarBotaoLogin();
    }


    public LoginPage getLoginPage() {
        return loginPage;
    }

    public InventoryPage getInventoryPage() {
        return inventoryPage;
    }

}
