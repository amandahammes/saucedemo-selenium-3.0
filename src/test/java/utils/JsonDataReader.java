package utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import models.CheckoutInformation;
import models.User;

import java.io.InputStream;

public class JsonDataReader {

    private static final ObjectMapper mapper = new ObjectMapper();

    public static User getUser(String nomeUsuario){
        try{
            InputStream is = JsonDataReader.class
                    .getClassLoader()
                    .getResourceAsStream("testData/loginData.json");

            JsonNode root = mapper.readTree(is);
            JsonNode usuarioNode = root.get(nomeUsuario);

            return mapper.treeToValue(usuarioNode, User.class);

        }catch (Exception e){
            throw new RuntimeException("Erro ao ler usuario: " + nomeUsuario, e);
        }
    }

    public static CheckoutInformation getCheckoutInformation(String userInformation){
        try{
            InputStream is = JsonDataReader.class
                    .getClassLoader()
                    .getResourceAsStream("testData/checkoutData.json");

            JsonNode root = mapper.readTree(is);
            JsonNode informationCheckout = root.get(userInformation);

            return  mapper.treeToValue(informationCheckout, CheckoutInformation.class);

        }catch(Exception e){
            throw new RuntimeException("Erro ao ler informações de checkout: " + userInformation, e);
        }
    }
}