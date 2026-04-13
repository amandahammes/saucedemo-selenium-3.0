package flows;

import org.openqa.selenium.WebDriver;
import pages.LoginPage;

public class LoginFlow {
    private LoginPage loginPage;

    public LoginFlow (WebDriver driver){
        this.loginPage = new LoginPage(driver);
    }

    public void realizarLogin(String usuario, String senha){
        loginPage.preencherUsuario(usuario);
        loginPage.preencherSenha(senha);
        loginPage.clicarBotaoLogin();
    }
}
