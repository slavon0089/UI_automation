package org.example.lesson3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class SetupBrowserExamples {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--no-sandbox")
                .addArguments("--disable-notifications")
                .addArguments("user-agent=Googlebot/2.1 (+http://www.goohle.com/bot.html)");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.get("https://google.com");
        Thread.sleep(5000);

        ((JavascriptExecutor)driver).executeScript("window.open()"); //открыть новую вкладку
        Thread.sleep(5000);
        List<String> tabs = new ArrayList<>(driver.getWindowHandles()); //получение списка вкладок
        driver.switchTo().window(tabs.get(0));      //переключение на первую вкладку
        Thread.sleep(5000);
        
        driver.quit();  //не забываем закрыть браузер в конце
    }
}
