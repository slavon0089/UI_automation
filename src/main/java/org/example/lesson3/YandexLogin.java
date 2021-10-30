package org.example.lesson3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class YandexLogin {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://passport.yandex.by/auth");

        driver.findElement(By.xpath("//input[contains(@id,'passp-field-login')]")).sendKeys("testGeekBrains2021");
        driver.findElement(By.id("passp:sign-in")).click();

        driver.findElement(By.xpath("//input[contains(@id,'passp-field-passwd')]")).sendKeys("GeekBrains");
        driver.findElement(By.id("passp:sign-in")).click();

        Thread.sleep(3000);

        driver.quit();
    }
}
