package lesson18;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage {
    WebDriver driver;

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(name = "firstName") // Поле First Name
    WebElement firstNameInput;

    @FindBy(name = "lastName") // Поле Last Name
    WebElement lastNameInput;

    @FindBy(name = "dob") // Поле Date of Birth
    WebElement dobInput;

    @FindBy(name = "email") // Поле Email
    WebElement emailInput;

    @FindBy(name = "password") // Поле Password
    WebElement passwordInput;

    @FindBy(name = "confirmPassword") // Поле Confirm Password
    WebElement confirmPasswordInput;

    @FindBy(name = "submit") // Кнопка Submit
    WebElement submitButton;

    @FindBy(id = "resultMessage") // Поле результата
    WebElement resultMessage;

    // Методы для ввода данных
    public void enterFirstName(String firstName) {
        firstNameInput.sendKeys(firstName);
    }

    public void enterLastName(String lastName) {
        lastNameInput.sendKeys(lastName);
    }

    public void enterDob(String dob) {
        dobInput.sendKeys(dob);
    }

    public void enterEmail(String email) {
        emailInput.sendKeys(email);
    }

    public void enterPassword(String password) {
        passwordInput.sendKeys(password);
    }

    public void enterConfirmPassword(String confirmPassword) {
        confirmPasswordInput.sendKeys(confirmPassword);
    }

    public void clickSubmit() {
        submitButton.click();
    }

    public String getResultMessage() {
        return resultMessage.getText();
    }
}