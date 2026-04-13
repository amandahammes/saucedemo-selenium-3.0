package tests;

import flows.LoginFlow;
import models.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import tests.base.BaseTest;
import utils.JsonDataReader;

public class LoginTest extends BaseTest {

    private LoginFlow loginFlow;

    @BeforeEach
    void initFlow(){
        loginFlow = new LoginFlow(driver);
    }

    private User user(String userType) {
        return JsonDataReader.getUser(userType);
    }

    @Test
    @DisplayName("Login com usuário válido")
    public void shouldDoLoginSuccessfully(){
        User validUser = user("usuarioValido");
        loginFlow.realizarLogin(validUser.getUser(), validUser.getPass());
    }

    @Test
    @DisplayName("Login com usuário bloqueado")
    public void shouldFailLoginWithBlockedUser(){
        User blockerUser = user("usuarioBloqueado");
        loginFlow.realizarLogin(blockerUser.getUser(), blockerUser.getPass());
    }

    @Test
    @DisplayName("Login sem senha")
    public void shouldFailLoginWithoutPassword(){
        User userWithoutPass = user("usuarioSemSenha");
        loginFlow.realizarLogin(userWithoutPass.getUser(), userWithoutPass.getPass());
    }

    @Test
    @DisplayName("Login usuário inválido")
    public void shouldFailLoginWithInvalidUser(){
        User invalidUser = user("usuarioErrado");
        loginFlow.realizarLogin(invalidUser.getUser(), invalidUser.getPass());
    }
}