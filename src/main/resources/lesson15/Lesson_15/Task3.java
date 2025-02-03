package Lesson_15;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task3 {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.w3schools.com/");

        // Найдем два элемента
        WebElement element1 = driver.findElement(By.id("navbtn_tutorials"));
        WebElement element2 = driver.findElement(By.id("navbtn_exercises"));

        compareElements(element1, element2);

        driver.quit();
    }

    public static void compareElements(WebElement el1, WebElement el2) {
        int y1 = el1.getLocation().getY();
        int y2 = el2.getLocation().getY();
        int x1 = el1.getLocation().getX();
        int x2 = el2.getLocation().getX();
        int area1 = el1.getSize().getHeight() * el1.getSize().getWidth();
        int area2 = el2.getSize().getHeight() * el2.getSize().getWidth();

        System.out.println("Элемент 1 выше? " + (y1 < y2));
        System.out.println("Элемент 1 левее? " + (x1 < x2));
        System.out.println("Элемент 1 больше? " + (area1 > area2));
    }
}
