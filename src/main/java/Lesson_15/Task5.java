package Lesson_15;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class Task5 {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // 1. Открываем страницу логина
        driver.get("https://qa-course-01.andersenlab.com/login");

        // 2. Вводим логин и пароль
        driver.findElement(By.id("email")).sendKeys("mba6104@mail.com");
        driver.findElement(By.id("password")).sendKeys("ваш_пароль");
        driver.findElement(By.id("login-button")).click();

        // 3. Нажимаем на аватарку
        WebElement avatar = driver.findElement(By.id("avatar"));
        avatar.click();

        // 4. Нажимаем на кнопку "Upload"
        WebElement uploadButton = driver.findElement(By.id("upload"));
        uploadButton.click();

        // 5. Выбираем файл (замени путь на свой)
        WebElement fileInput = driver.findElement(By.id("file-input"));
        fileInput.sendKeys("C:\\Users\\Имя_пользователя\\Pictures\\dog.jpg");

        // 6. Нажимаем кнопку "Open" (если она есть)
        WebElement openButton = driver.findElement(By.id("open"));
        openButton.click();

        // 7. Проверяем появление сообщения "Your photo has been updated"
        WebElement successMessage = driver.findElement(By.id("success-message"));
        if (successMessage.getText().equals("Your photo has been updated")) {
            System.out.println("✅ Фото успешно загружено!");
        } else {
            System.out.println("❌ Ошибка загрузки фото.");
        }

        // Закрываем браузер
        driver.quit();
    }
}

