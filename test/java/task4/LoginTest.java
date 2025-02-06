package task4;


import org.junit.jupiter.api.Test;
import org.testng.annotations.Parameters;
import org.testng.annotations.DataProvider;

public class LoginTest {
@DataProvider(name = "userData")
    public Object[] []getUsers () {
    return new Object[][]{
            {"ayau.bagytzhan@mail.ru, Ayaulym123"},
            {"arsqlax@mail.ru, Arsekon98"},
            {"marlenba@mail.ru, Nazym123"}
    };
    }
    @Test
    @Parameters({"username", "password"})
    public void loginTest(String username, String password) {
        System.out.println("Login with: " + username + " / " + password);
    }
}
