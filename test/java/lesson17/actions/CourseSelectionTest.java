package lesson17.actions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CourseSelectionTest {
    private WebDriver driver;

    @BeforeEach
    void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    void testCourseSelection() {
        // Открываем страницу
        driver.get("https://qa-course-01.andersenlab.com/"); // Укажите реальный URL

        // Нажимаем кнопку "AQA Practice"
        driver.findElement(By.id("aqa-practice-button")).click(); // Укажите правильный id

        // Нажимаем "Select"
        driver.findElement(By.id("select-button")).click(); // Укажите правильный id

        // Выбираем Country -> USA
        Select countrySelect = new Select(driver.findElement(By.id("country-dropdown")));
        countrySelect.selectByVisibleText("USA");

        // Выбираем Language -> English
        Select languageSelect = new Select(driver.findElement(By.id("language-dropdown")));
        languageSelect.selectByVisibleText("English");

        // Выбираем Type -> Testing
        Select typeSelect = new Select(driver.findElement(By.id("type-dropdown")));
        typeSelect.selectByVisibleText("Testing");

        // Генерируем даты
        LocalDate today = LocalDate.now();
        LocalDate startDate = today.plusDays((8 - today.getDayOfWeek().getValue()) % 7);
        LocalDate lastDate = startDate.plusWeeks(2);

        // Форматируем даты
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d MMMM yyyy");
        String formattedStartDate = startDate.format(formatter);
        String formattedLastDate = lastDate.format(formatter);

        // Вводим Start date
        WebElement startDateInput = driver.findElement(By.id("start-date"));
        startDateInput.clear();
        startDateInput.sendKeys(formattedStartDate);

        // Вводим Last date
        WebElement lastDateInput = driver.findElement(By.id("last-date"));
        lastDateInput.clear();
        lastDateInput.sendKeys(formattedLastDate);

        // Выбираем курсы AQA Java и AQA Python
        driver.findElement(By.id("course-aqa-java")).click();
        driver.findElement(By.id("course-aqa-python")).click();

        // Нажимаем кнопку "Search"
        driver.findElement(By.id("search-button")).click();

        // Проверяем наличие сообщения об отсутствии курсов
        WebElement message = driver.findElement(By.id("no-courses-message"));
        assertTrue(message.getText().contains("Unfortunately, we did not find any courses matching your chosen criteria."));
    }

    @AfterEach
    void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}