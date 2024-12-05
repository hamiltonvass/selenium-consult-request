package Pages;

import Config.FileConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ConsultRequest {

    private WebDriver driver;
    private WebDriverWait wait;

    private final By pathInputSelect = By.xpath("//span[text()='Seleccione un valor']");
    private final By pathInputTextIdRequest = By.xpath("//input[@placeholder='Buscar por ID Solicitud']");
    private final By pathDateFrom = By.xpath("/html/body/div[1]/div[1]/main/div/div/div[1]/div/div/div/div[1]/div/div[2]/div/div/div/div/div/div[2]/div/div[3]/div[1]/div/div[2]/div/div[2]/div/div[2]/div/div/input");
    private final By pathDateTo = By.xpath("/html/body/div[1]/div[1]/main/div/div/div[1]/div/div/div/div[1]/div/div[2]/div/div/div/div/div/div[2]/div/div[3]/div[2]/div/div[2]/div/div[2]/div/div[2]/div/div/input");
    private final By clickConsultRequest = By.xpath("//span[text()='Consultar']");

    public ConsultRequest(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, FileConfig.num);
    }

    public void inputSelect (String typeEntry) {
        WebElement nameElement = wait.until(ExpectedConditions.visibilityOfElementLocated(pathInputSelect));
        String id = nameElement.getAttribute("id");
        nameElement.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='" + typeEntry + "']"))).click();
    }

    public void inputTextIDRequest(String text) {
        WebElement nameElement = wait.until(ExpectedConditions.visibilityOfElementLocated(pathInputTextIdRequest));
        nameElement.sendKeys(text);
    }

    public void inputDateFrom(String date) {
        WebElement nameElement = wait.until(ExpectedConditions.visibilityOfElementLocated(pathDateFrom));
        int length = nameElement.getAttribute("value").length();
        for (int i = 0; i < length; i++) {
            nameElement.sendKeys(Keys.ARROW_LEFT);
            nameElement.sendKeys(Keys.DELETE);
        }
        nameElement.sendKeys(date);
    }

    public void inputDateTo(String date) {
        WebElement nameElement = wait.until(ExpectedConditions.visibilityOfElementLocated(pathDateTo));
        int length = nameElement.getAttribute("value").length();
        for (int i = 0; i < length; i++) {
            nameElement.sendKeys(Keys.ARROW_LEFT);
            nameElement.sendKeys(Keys.DELETE);
        }
        nameElement.sendKeys(date);
    }

    public void clickConsultRequest() {
        WebElement nameElement = wait.until(ExpectedConditions.visibilityOfElementLocated(clickConsultRequest));
        nameElement.click();
    }

    public void consultIdRequest(String idRequest) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(@class, 'LinkedItem---standalone_richtext_link') and text()='"+idRequest+"']"))).click();
    }

}
