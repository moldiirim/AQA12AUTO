package Lesson_15;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.ArrayList;
import java.util.List;

public class Task2 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();

        // Список страниц
        String[] urls = {
                "http://www.automationpractice.pl/index.php",
                "https://zoo.waw.pl/",
                "https://www.w3schools.com/",
                "https://www.clickspeedtester.com/click-counter/",
                "https://andersenlab.com/"
        };

        // Открываем страницы в новых вкладках
        List<String> tabs = new ArrayList<>();
        for (String url : urls) {
            driver.switchTo().newWindow(org.openqa.selenium.WindowType.TAB);
            driver.get(url);
            tabs.add(driver.getWindowHandle());
        }

        // Переключение между вкладками
        for (String tab : tabs) {
            driver.switchTo().window(tab);
            System.out.println("Название страницы: " + driver.getTitle());
            System.out.println("Ссылка: " + driver.getCurrentUrl());

            // Закрываем страницу, если в названии есть "Zoo"
            if (driver.getTitle().toLowerCase().contains("zoo")) {
                driver.close();
            }
        }

        driver.quit();
    }
}

