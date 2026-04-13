package tests;

import flows.LoginFlow;
import models.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import tests.base.BaseTest;
import utils.JsonDataReader;

public class LoginTest extends BaseTest {
    @Test
    @DisplayName("Login com usuário válido")
    public void shouldDoLoginSuccessfully(){
        User validUser = JsonDataReader.getUser("usuarioValido");
        LoginFlow loginFlow = new LoginFlow(driver);
        loginFlow.realizarLogin(validUser.getUser(), validUser.getPass());
    }

    @Test
    @DisplayName("Login com usuário bloqueado")
    public void shouldFailLoginWithBlockedUser(){
        User blockerUser = JsonDataReader.getUser("usuarioBloqueado");
        LoginFlow loginFlow = new LoginFlow(driver);
        loginFlow.realizarLogin(blockerUser.getUser(), blockerUser.getPass());
    }
}