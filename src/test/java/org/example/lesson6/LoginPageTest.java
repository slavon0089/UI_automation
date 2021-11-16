package org.example.lesson6;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;


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
    void loginTest() throws InterruptedException {
        new LoginPage(driver)
                .fillLogin("testGeekBrains2021")
                .submitLogin()
                .fillPassword("GeekBrains")
                .submitPassword();
    }

    @Test
    void IncorrectLoginTest () throws InterruptedException {
        new LoginPage(driver)
                .fillLogin(")*()&&**][]")
                .submitLogin();

        Assertions.assertTrue(driver.findElement(By.xpath("//div[contains(@id, 'field:input-login:hint')]")).isDisplayed());
    }

    @Test
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
        driver.quit();
    }
}
