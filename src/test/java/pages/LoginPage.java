package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.WaitUtils;
import java.time.Duration;

public class LoginPage {

    private WebDriver driver;
    private WaitUtils wait;

    private By inputUsuario = By.id("user-name");
    private By inputSenha = By.id("password");
    private By botaoLogin = By.id("login-button");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WaitUtils(driver);
    }

    public void preencherUsuario(String usuario) {
        wait.waitForVisibility(inputUsuario).sendKeys(usuario);
    }

    public void preencherSenha(String senha) {
        wait.waitForVisibility(inputSenha).sendKeys(senha);
    }

    public void clicarBotaoLogin() {
        wait.waitForVisibility(botaoLogin).click();
    }
}