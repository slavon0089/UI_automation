package org.example.lesson3;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CooliesExample {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();

        WebDriver webDriver = new ChromeDriver();

        webDriver.get("https://diary.ru");

        Cookie cookie = new Cookie("_identity_", "69a9f1729d3546ed6f61f06414243412233347124e3398d34f5a36ae8920a2f5a%3A2%3A%7Bi%3A0%3Bs%3A10%3A%22_identity_%22%3Bi%3A1%3Bs%3A52%3A%22%5B3559051%2C%22MrXu2a-lilFU5PaOJI8xXdPNeViAvlVD%22%2C2592000%5D%22%3B%7D");
        webDriver.manage().addCookie(cookie);
        webDriver.navigate().refresh();
        Thread.sleep(5000);

    }
}
