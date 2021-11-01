package org.example.lesson3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class AddContactToContactsList {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://passport.yandex.by/auth");
        login(driver);
        Thread.sleep(2000);
        driver.get("https://mail.yandex.by");

        driver.findElement(By.xpath("//span[.='Ещё' and @class='PSHeaderService-Text']")).click();
        driver.findElement(By.xpath("//span[.='Контакты']")).click();
        driver.findElement(By.xpath("//span[.='Добавить контакт']")).click();

        driver.findElement(By.xpath("//input[@name='first_name']")).sendKeys("User");
        driver.findElement(By.xpath("//input[@name='middle_name']")).sendKeys("middle");
        driver.findElement(By.xpath("//input[@name='last_name']")).sendKeys("Test");
        driver.findElement(By.xpath("//button/span[.='Добавить в контакты']")).click();

        Thread.sleep(3000);
        driver.quit();
    }

    static void login(WebDriver driver){
        WebElement elemnt = driver.findElement(By.xpath("//input[contains(@id,'passp-field-login')]"));
        elemnt.sendKeys("testGeekBrains2021");
        driver.findElement(By.id("passp:sign-in")).click();
        driver.findElement(By.xpath("//input[contains(@id,'passp-field-passwd')]")).sendKeys("GeekBrains");
        driver.findElement(By.id("passp:sign-in")).click();
    }
}
