import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();

        try {
            String filePath = Paths.get("program.html").toAbsolutePath().toUri().toString();
            driver.get(filePath);

            driver.findElement(By.id("increment-button")).click();

            String result = driver.findElement(By.id("output")).getText();

            if (result.equals("1")) {
                System.out.println("TEST PASSED: Increment button works!");
            } else {
                System.out.println("TEST FAILED: Expected 1 but got " + result);
                throw new AssertionError("Counter value is incorrect");
            }
        } finally {
            driver.quit();
        }
    }
}
