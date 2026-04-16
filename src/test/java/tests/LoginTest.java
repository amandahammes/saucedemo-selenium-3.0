package tests;

import flows.LoginFlow;
import models.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import tests.base.BaseTest;
import utils.JsonDataReader;
import validations.Validations;

public class LoginTest extends BaseTest {

    private LoginFlow loginFlow;
    private Validations validations;

    @BeforeEach
    void initFlow(){
        loginFlow = new LoginFlow(driver);
        validations = new Validations(loginFlow.getLoginPage(), loginFlow.getInventoryPage());
    }

    private User user(String userType) {
        return JsonDataReader.getUser(userType);
    }

    @Test
    @DisplayName("Login com usuário válido")
    public void shouldDoLoginSuccessfully(){
        User validUser = user("usuarioValido");
        loginFlow.realizarLogin(validUser.getUser(), validUser.getPass());
        validations.validarLoginComSucesso();
    }

    @Test
    @DisplayName("Login com usuário bloqueado")
    public void shouldFailLoginWithBlockedUser(){
        User blockerUser = user("usuarioBloqueado");
        loginFlow.realizarLogin(blockerUser.getUser(), blockerUser.getPass());
        validations.validarMensagemErroLogin();
    }

    @Test
    @DisplayName("Login sem senha")
    public void shouldFailLoginWithoutPassword(){
        User userWithoutPass = user("usuarioSemSenha");
        loginFlow.realizarLogin(userWithoutPass.getUser(), userWithoutPass.getPass());
        validations.validarMensagemErroLogin();
    }

    @Test
    @DisplayName("Login usuário inválido")
    public void shouldFailLoginWithInvalidUser(){
        User invalidUser = user("usuarioErrado");
        loginFlow.realizarLogin(invalidUser.getUser(), invalidUser.getPass());
        validations.validarMensagemErroLogin();
    }

    @Test
    @DisplayName("Realizar logout de usuário logado")
    public void shouldLogoutSuccessfully(){
        User validUser = user("usuarioValido");
        loginFlow.realizarLogin(validUser.getUser(), validUser.getPass());
        loginFlow.realizarLogout();
        validations.validarPaginaLogin();
    }
}