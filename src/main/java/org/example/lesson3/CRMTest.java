package org.example.lesson3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import javax.swing.*;
import java.util.concurrent.TimeUnit;

public class CRMTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://crm.geekbrains.space/user/login");
        login(driver);

        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath("//ul[@class='nav nav-multilevel main-menu']/li/a/span[.=\"Расходы\"]"))).build().perform();
        driver.findElement(By.xpath("//span[.='Заявки на расходы']")).click();

        driver.findElement(By.xpath("//a[.='Создать заявку на расход']")).click();

        driver.findElement(By.name("crm_expense_request[description]")).sendKeys("tesst");

        Select selectBusinessUnit =new Select(driver.findElement(By.name("crm_expense_request[businessUnit]")));
        selectBusinessUnit.selectByVisibleText("Research & Development");

        Select expenditureSelect = new Select(driver.findElement(By.name("crm_expense_request[expenditure]")));
        expenditureSelect.selectByVisibleText("01101 - ОС: вычислительная техника инфраструктуры");

        driver.findElement(By.xpath("//input[contains(@id,'datePlan') and @placeholder='Укажите дату']")).click();
        driver.findElement((By.xpath("//a[.='21']"))).click();

        driver.findElement(By.xpath("//input[contains(@id,'crm_expense_request_sumPlan')]")).sendKeys("100");

        driver.findElement(By.xpath("//button[contains(., 'Сохранить и закрыть')]")).click();

        Thread.sleep(3000);
        driver.quit();
    }

    static void login(WebDriver driver){
        WebElement elemnt = driver.findElement(By.id("prependedInput"));
        elemnt.sendKeys("Applanatest1");
        driver.findElement(By.id("prependedInput2")).sendKeys("Student2020!");
        driver.findElement(By.id("_submit")).click();
    }
}
