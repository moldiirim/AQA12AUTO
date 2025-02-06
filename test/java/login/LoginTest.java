package login;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LoginTest {

    @Test
    @Parameters({"username", "password"})
    public void loginTest(String username, String password) {
        System.out.println("Login with: " + username + " / " + password);
    }
}
