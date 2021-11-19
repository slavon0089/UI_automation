package org.example.lesson6;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import io.qameta.allure.TmsLink;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Iterator;


public class LoginPageTest {
    EventFiringWebDriver driver;
    WebDriverWait webDriverWait;

    @BeforeAll
    static void registerDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setUpBrowser() {

        ChromeOptions options = new ChromeOptions();

        driver = new EventFiringWebDriver(new ChromeDriver(options));
        webDriverWait = new WebDriverWait(driver, 5);
        driver.get("https://passport.yandex.by/auth");
    }

    @Test
    @TmsLink("Аннотация для тестов логина")
    void loginTest() throws InterruptedException {
        new LoginPage(driver)
                .fillLogin("testGeekBrains2021")
                .submitLogin()
                .fillPassword("GeekBrains")
                .submitPassword();
    }

    @Test
    @TmsLink("Аннотация для тестов некорректного логина")
    void IncorrectLoginTest () throws InterruptedException {
        new LoginPage(driver)
                .fillLogin(")*()&&**][]")
                .submitLogin();

        Assertions.assertTrue(driver.findElement(By.xpath("//div[contains(@id, 'field:input-login:hint')]")).isDisplayed());
    }

    @Test
    @TmsLink("Аннотация для тестов некорректного пароля")
    @Description ("подробный дискрипшн для теста")
    void IncorrectPasswordTest() throws InterruptedException {
        new LoginPage(driver)
                .fillLogin("testGeekBrains2021")
                .submitLogin()
                .fillPassword("sergsergsrg")
                .submitPassword();
        Assertions.assertTrue(driver.findElement(By.xpath("//div[contains(@id, 'field:input-passwd:hint')]")).isDisplayed());
    }

    @AfterEach
    void tearDown() {
        LogEntries browserLogs = driver.manage().logs().get(LogType.BROWSER);

        Iterator<LogEntry> iterator = browserLogs.iterator();
        while (iterator.hasNext()) {
            Allure.addAttachment("Лог в консоли", iterator.next().getMessage());
        }

        driver.quit();
    }
}