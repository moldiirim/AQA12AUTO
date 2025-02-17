package lesson17.actions;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.time.Duration;

public class AlertAutomationTest {
    public static void main(String[] args) {
        // Указываем путь к драйверу Chrome (если нужно)
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");

        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            driver.get("https://qa-course-01.andersenlab.com/actions"); // Замените на реальный URL

            // --- Если кнопки находятся в iFrame, переключаемся ---
            driver.switchTo().frame("iframe_id_or_name"); // Замените на ID или NAME iFrame

            // --- Первый Alert ---
            WebElement firstButton = driver.findElement(By.id("alertButton1")); // Замените на реальный локатор
            firstButton.click();

            Alert firstAlert = wait.until(ExpectedConditions.alertIsPresent());
            String firstAlertText = firstAlert.getText();
            Assert.assertEquals(firstAlertText, "You have called alert!");
            firstAlert.accept(); // Нажимаем OK

            WebElement firstResult = driver.findElement(By.id("result1")); // Локатор для проверки
            Assert.assertEquals(firstResult.getText(), "Congratulations, you have successfully enrolled in the course!");

            // --- Второй Alert ---
            WebElement secondButton = driver.findElement(By.id("alertButton2")); // Замените на реальный локатор
            secondButton.click();

            Alert secondAlert = wait.until(ExpectedConditions.alertIsPresent());
            String secondAlertText = secondAlert.getText();
            Assert.assertEquals(secondAlertText, "Are you sure you want to apply the discount?");
            secondAlert.accept(); // Нажимаем OK

            WebElement secondResult = driver.findElement(By.id("result2"));
            Assert.assertEquals(secondResult.getText(), "You received a 10% discount on the second course.");

            // --- Третий Alert (с вводом текста) ---
            WebElement thirdButton = driver.findElement(By.id("alertButton3"));
            thirdButton.click();

            Alert thirdAlert = wait.until(ExpectedConditions.alertIsPresent());
            String thirdAlertText = thirdAlert.getText();
            Assert.assertEquals(thirdAlertText, "Here you may describe a reason why you are cancelling your registration (or leave this field empty).");

            thirdAlert.sendKeys("Test"); // Вводим текст
            thirdAlert.accept(); // Нажимаем OK

            WebElement thirdResult = driver.findElement(By.id("result3"));
            Assert.assertTrue(thirdResult.getText().contains("Test"));

            // --- Выход из iFrame (если использовался) ---
            driver.switchTo().defaultContent();

            System.out.println("Тест успешно завершен!");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}
