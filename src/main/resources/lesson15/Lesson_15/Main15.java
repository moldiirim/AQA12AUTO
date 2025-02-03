package Lesson_15;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import javax.lang.model.util.Elements;

private static WebDriver setUpDriver() {
    System.setProperty("webdriver.chrome.driver", "/Users/azamatsayanov/Downloads/chromedriver-mac-arm64");
    ChromeOptions options = new ChromeOptions();
    options.addArguments("--disable-notifications");
    options.setBinary("/Users/azamatsayanov/chrome/mac_arm-132.0.6834.159/chrome-mac-arm64/Google Chrome for Testing.app/Contents/MacOS/Google Chrome for Testing");
}

public class Main15 {
        public static void main (String [] args) {
            WebDriverManager.chromedriver().setup();
            WebDriver driver = new ChromeDriver();
            Task1(driver);
            Task2(driver);
            Task3(driver);
            Task4(driver);
            Task5(driver);
        }
    }

