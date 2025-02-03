package Lesson_15;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task4 {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://qa-course-01.andersenlab.com/login");

        // Ввод логина и пароля
        WebElement emailField = driver.findElement(By.id("email"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement submitButton = driver.findElement(By.id("login-button"));

        emailField.sendKeys("mba6104@gmail.com");
        passwordField.sendKeys("qwerty123");
        submitButton.click();

        System.out.println("Авторизация выполнена.");
        driver.quit();
    }
}
