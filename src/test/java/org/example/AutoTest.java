package org.example;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AutoTest {
        @Test
        public void openMozillaFirefox() throws InterruptedException {
            System.setProperty("webdriver.gecko.driver", "D:\\KULIAH\\Sem4\\Pengujian\\KUIS\\kuis1\\drivers\\geckodriver.exe");
            WebDriver driver = new FirefoxDriver();
            driver.get("https://sv.ugm.ac.id");
            Thread.sleep(10000);
            driver.quit();
        }
}
