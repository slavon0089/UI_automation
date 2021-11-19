package org.example.lesson6;


import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BaseView {

    @FindBy(xpath = "//input[contains(@id,'passp-field-login')]")
    public WebElement inputLogin;

    @FindBy(xpath = "//input[contains(@id,'passp-field-passwd')]")
    public WebElement inputPassword;

    @FindBy(id = "passp:sign-in")
    public WebElement buttonLogin;

    @FindBy(id = "passp:sign-in")
    public WebElement buttonPassword;

    @Step ("Заполняем поле логин")
    public LoginPage fillLogin(String login) {
        inputLogin.sendKeys(login);
        return this;
    }

    @Step ("Заполняем поле пароль")
    public LoginPage fillPassword(String password) throws InterruptedException {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[contains(@id,'passp-field-passwd')]")));
        inputPassword.sendKeys(password);
        return this;
    }

    @Step ("Клик на кнопку входа")
    public LoginPage submitLogin() {
        buttonLogin.click();
        return this;
    }


    public LoginPage submitPassword() throws InterruptedException {
        buttonPassword.click();
        Thread.sleep(500);  //Без него пока не придумал способа с задержкой
        return this;
    }

    public LoginPage(WebDriver driver) {
        super(driver);
    }
}