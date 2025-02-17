package lesson18;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RegistrationTest {
    WebDriver driver;
    RegistrationPage registrationPage;

    @BeforeEach
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://qa-course-01.dinsdenlab.com/registration");
        registrationPage = new RegistrationPage(driver);
    }

    @AfterEach
    public void teardown() {
        driver.quit();
    }

    @Test
    public void testSuccessfulRegistration() {
        registrationPage.enterFirstName("Moldirim");
        registrationPage.enterLastName("Bagytzhan");
        registrationPage.enterDob("12/08/2001");
        registrationPage.enterEmail("mba6104@gmail.com");
        registrationPage.enterPassword("qwerty123");
        registrationPage.enterConfirmPassword("qwerty123");
        registrationPage.clickSubmit();

        assertEquals("Пользователь должен зарегистрироваться успешно", registrationPage.getResultMessage());
    }

    @Test
    public void testInvalidEmail() {
        registrationPage.enterFirstName("Moldirim");
        registrationPage.enterLastName("Bagytzhan");
        registrationPage.enterDob("12/08/2001");
        registrationPage.enterEmail("mba6104gmail.com"); // Некорректный email
        registrationPage.enterPassword("qwerty123");
        registrationPage.enterConfirmPassword("qwerty123");
        registrationPage.clickSubmit();

        assertEquals("Invalid email address", registrationPage.getResultMessage());
    }

    @Test
    public void testEmptyFields() {
        registrationPage.clickSubmit();
        assertEquals("First Name is required.", registrationPage.getResultMessage());
    }

    @Test
    public void testPasswordMismatch() {
        registrationPage.enterFirstName("Moldirim");
        registrationPage.enterLastName("Bagytzhan");
        registrationPage.enterDob("12/08/2001");
        registrationPage.enterEmail("mba6104@gmail.com");
        registrationPage.enterPassword("qwerty123");
        registrationPage.enterConfirmPassword("123qwerty");
        registrationPage.clickSubmit();

        assertEquals("Passwords must match", registrationPage.getResultMessage());
    }

    @Test
    public void testAlreadyRegisteredEmail() {
        registrationPage.enterFirstName("Moldirim");
        registrationPage.enterLastName("Bagytzhan");
        registrationPage.enterDob("12/08/2001");
        registrationPage.enterEmail("mba6104@gmail.com"); // Уже зарегистрированный email
        registrationPage.enterPassword("qwerty123");
        registrationPage.enterConfirmPassword("qwerty123");
        registrationPage.clickSubmit();

        assertEquals("Email already exists", registrationPage.getResultMessage());
    }

    @Test
    public void testShortPassword() {
        registrationPage.enterFirstName("Moldirim");
        registrationPage.enterLastName("Bagytzhan");
        registrationPage.enterDob("12/08/2001");
        registrationPage.enterEmail("mba6104@gmail.com");
        registrationPage.enterPassword("123");
        registrationPage.enterConfirmPassword("123");
        registrationPage.clickSubmit();

        assertEquals("Minimum 8 characters", registrationPage.getResultMessage());
    }

    @Test
    public void testMaxLengthValidation() {
        registrationPage.enterFirstName("MoldirimMoldirimMoldirimMoldirim");
        registrationPage.enterLastName("BagytzhanBagytzhanBagytzhanBagytzhan");
        registrationPage.enterDob("12/08/2001");
        registrationPage.enterEmail("mmba6104@gmail.com");
        registrationPage.enterPassword("qwerty123");
        registrationPage.enterConfirmPassword("qwerty123");
        registrationPage.clickSubmit();

        assertEquals("Maximum 20 characters", registrationPage.getResultMessage());
    }

    private class RegistrationPage {
        public RegistrationPage(WebDriver driver) {
        }

        public void enterFirstName(String moldirim) {
        }

        public void enterLastName(String bagytzhan) {
        }

        public void enterDob(String s) {
        }

        public void enterEmail(String mail) {
        }

        public void enterPassword(String qwerty123) {
        }

        public void enterConfirmPassword(String qwerty123) {
        }

        public void clickSubmit() {
        }

        public String getResultMessage() {
            return "";
        }
    }
    }
