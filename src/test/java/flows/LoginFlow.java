package flows;

import org.openqa.selenium.WebDriver;
import pages.InventoryPage;
import pages.LoginPage;
import pages.components.HeaderComponent;
import pages.components.SideBarComponent;

public class LoginFlow {
    private LoginPage loginPage;
    private InventoryPage inventoryPage;
    private HeaderComponent headerComponent;
    private SideBarComponent sideBarComponent;

    public LoginFlow (WebDriver driver){
        this.loginPage = new LoginPage(driver);
        this.inventoryPage = new InventoryPage(driver);
        this.headerComponent = new HeaderComponent(driver);
        this.sideBarComponent = new SideBarComponent(driver);
    }

    public void realizarLogin(String usuario, String senha){
        loginPage.preencherUsuario(usuario);
        loginPage.preencherSenha(senha);
        loginPage.clicarBotaoLogin();
    }

    public void realizarLogout(){
        headerComponent.irParaMenu();
        sideBarComponent.realizarLogout();
    }

    public LoginPage getLoginPage() {
        return loginPage;
    }

    public InventoryPage getInventoryPage() {
        return inventoryPage;
    }
}
