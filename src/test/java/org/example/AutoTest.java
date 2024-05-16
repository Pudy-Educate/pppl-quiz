package org.example;

import dev.failsafe.internal.util.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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


    @Test
    public void testLogin() throws InterruptedException {
        System.setProperty("webdriver.gecko.driver", "D:\\KULIAH\\Sem4\\Pengujian\\KUIS\\kuis1\\drivers\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.saucedemo.com/");
        WebElement uname = driver.findElement(By.id("user-name"));
        WebElement pass = driver.findElement(By.id("password"));
        WebElement btn = driver.findElement(By.id("login-button"));
        uname.sendKeys("standard_user");
        pass.sendKeys("secret_sauce");
        btn.submit();

        String expectedUrl = "https://www.saucedemo.com/inventory.html";
        String actualUrl = driver.getCurrentUrl();
        WebElement text = driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/span"));
        text.isDisplayed();
        Assertions.assertEquals(actualUrl, expectedUrl,"Test success");

        driver.quit();
    }
}
