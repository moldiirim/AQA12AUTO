package lesson17.actions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
public class DragAndDropTest {
    public static void main(String[] args) {
        // Указываем путь к драйверу Chrome (если необходимо)
        System.setProperty("webdriver.chrome.driver", "путь_к_chromedriver");

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        // Открываем страницу
        driver.get("https://qa-course-01.andersenlab.com/dragndrop");

        // Находим элементы для перетаскивания
        WebElement writeTestCases = driver.findElement(By.xpath("//div[text()='Write test cases']"));
        WebElement testingRequirements = driver.findElement(By.xpath("//div[text()='Testing requirements']"));
        WebElement writeAutomationScripts = driver.findElement(By.xpath("//div[text()='Write automation scripts']"));
        WebElement frameworkSetup = driver.findElement(By.xpath("//div[text()='Framework set up']"));

        // Находим цели для перетаскивания
        WebElement manualWork = driver.findElement(By.xpath("//div[contains(@class, 'manual-work')]"));
        WebElement automationWork = driver.findElement(By.xpath("//div[contains(@class, 'automation-work')]"));

        // Создаем объект Actions для Drag & Drop
        Actions actions = new Actions(driver);

        // Перетаскиваем элементы
        actions.clickAndHold(writeTestCases).moveToElement(manualWork).release().build().perform();
        actions.clickAndHold(testingRequirements).moveToElement(manualWork).release().build().perform();
        actions.clickAndHold(writeAutomationScripts).moveToElement(automationWork).release().build().perform();
        actions.clickAndHold(frameworkSetup).moveToElement(automationWork).release().build().perform();

        // Проверяем, что появилось сообщение "Congratulations! Let's test for the best!"
        WebElement successMessage = driver.findElement(By.xpath("//*[contains(text(), \"Congratulations! Let's test for the best!\")]"));
        if (successMessage.isDisplayed()) {
            System.out.println("Тест пройден! Сообщение появилось.");
        } else {
            System.out.println("Тест не пройден! Сообщение не найдено.");
        }

        // Закрываем браузер
        driver.quit();
    }
}
