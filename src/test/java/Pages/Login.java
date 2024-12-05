package Pages;


import Config.FileConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Login {

    private WebDriver driver;
    private WebDriverWait wait;

    private By name = By.cssSelector("input#un");
    private By password = By.cssSelector("input#pw");
    private By login = By.xpath("//input[@value='Entrar']");


    // Constructor que acepta un WebDriver
    public Login(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, FileConfig.num);
    }

    public void inputName(String name) {
        WebElement nameElement = wait.until(ExpectedConditions.visibilityOfElementLocated(this.name));
        nameElement.sendKeys(name);
    }

    public void inputPassword(String password) {
        WebElement passwordElement = wait.until(ExpectedConditions.visibilityOfElementLocated(this.password));
        passwordElement.sendKeys(password);
    }

    public void clickLogin() {
        WebElement loginButton = wait.until(ExpectedConditions.visibilityOfElementLocated(login));
        loginButton.click();
    }


}
