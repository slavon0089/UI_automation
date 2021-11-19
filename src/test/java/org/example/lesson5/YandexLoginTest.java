package org.example.lesson5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class YandexLoginTest {
    WebDriver driver;
    WebDriverWait webDriverWait;

    @BeforeAll
    static void setupDriver() {
        WebDriverManager.chromedriver().setup();
    }
    @BeforeEach
    void initBrowser() {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");     //убрать UI
        driver = new EventFiringWebDriver(new ChromeDriver(options)) ;

       // driver = new ChromeDriver();
        webDriverWait = new WebDriverWait(driver, 5);
    }

    @Test
    void loginTest()  {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://passport.yandex.by/auth");

        driver.findElement(By.xpath("//input[contains(@id,'passp-field-login')]")).sendKeys("testGeekBrains2021");
        driver.findElement(By.id("passp:sign-in")).click();

        driver.findElement(By.xpath("//input[contains(@id,'passp-field-passwd')]")).sendKeys("GeekBrains");
        driver.findElement(By.id("passp:sign-in")).click();

        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[.='Аккаунт']")));

    }

    @Test
    void incorrectLoginTest(){
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://passport.yandex.by/auth");

        driver.findElement(By.id("passp:sign-in")).click();
        List<WebElement> message = driver.findElements( By.xpath("//div[contains(@id, 'field:input-login:hint')]"));

        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@id, 'field:input-login:hint')]")));

    }

    @Test
    void incorrectPasswordTest()  {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://passport.yandex.by/auth");

        driver.findElement(By.xpath("//input[contains(@id,'passp-field-login')]")).sendKeys("testGeekBrains2021");
        driver.findElement(By.id("passp:sign-in")).click();

        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[contains(@id,'passp-field-passwd')]")));
        driver.findElement(By.id("passp:sign-in")).click();
        List<WebElement> message = driver.findElements( By.xpath("//div[contains(@id, 'field:input-passwd:hint')]"));

        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@id, 'field:input-passwd:hint')]")));
    }

    @Test
    void addContactToContactList() throws InterruptedException {

            WebDriverManager.chromedriver().setup();
            WebDriver driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
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


    }
    static void login(WebDriver driver){
        WebElement elemnt = driver.findElement(By.xpath("//input[contains(@id,'passp-field-login')]"));
        elemnt.sendKeys("testGeekBrains2021");
        driver.findElement(By.id("passp:sign-in")).click();
        driver.findElement(By.xpath("//input[contains(@id,'passp-field-passwd')]")).sendKeys("GeekBrains");
        driver.findElement(By.id("passp:sign-in")).click();
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }

}
