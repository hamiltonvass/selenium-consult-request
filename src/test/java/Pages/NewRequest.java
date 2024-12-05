package Pages;

import Config.FileConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class NewRequest {

    private final By pathCreateReverses = By.xpath("//*[@id=\"XrayComponentSelectionManager\"]/div/div[2]/div[1]/div/div[2]/div");
    private final By pathReverseConcept = By.xpath("//span[text()='Concepto del reverso']");
    private final By pathNumberCounter = By.xpath("//label[text()='Numero de cuenta']");
    private final By pathButton = By.xpath("/html/body/div[1]/div[1]/main/div/div/div[1]/div/div/div/div/div[1]/div/div[4]/div/div[1]/div[2]/div/div[2]/div[2]/div/p/a");
    private final By pathInputIdTransaction = By.xpath("//label[contains(text(), 'ID Transacci')]");
    private final By pathButtonidTransaction = By.xpath("/html/body/div[1]/div[1]/main/div/div/div[1]/div/div/div/div/div[1]/div/div[7]/div/div/div/div/div/div[1]/div[2]/div[2]/div/div[2]/div[2]/div/p/a/span[1]");
    private final By pathDateNow = By.xpath("//label[contains(text(), 'Fecha Valor')]");
    private final By pathInputCounter = By.xpath("//label[contains(text(), 'Monto')]");
    private final By pathButtonCreateRequest = By.xpath("//span[text()= 'Crear Solicitud']");
    private final By pathSuccesTextMessage = By.xpath("/html/body/div[1]/div[1]/main/div/div/div[1]/div/div/div/div/div[1]/div/div[2]/div[2]/div[1]/div[2]/div[2]/div/p/span[3]/strong");
    private final By pathGoNavigation = By.xpath("/html/body/div[1]/div[1]/div[3]/div/div/div/div/nav[2]/div[1]/ul/li[1]");


    private WebDriver driver;
    private WebDriverWait wait;

    public NewRequest(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, FileConfig.num);
    }

    public void clickCreateReverses() {
        WebElement nameElement = wait.until(ExpectedConditions.visibilityOfElementLocated(pathCreateReverses));
        nameElement.click();
    }

    public void selectReverseConcept(String text){
        WebElement selectElement = wait.until(ExpectedConditions.visibilityOfElementLocated(pathReverseConcept));
        String id = selectElement.getAttribute("id");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("wrapper_"+ id))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='" + text + "']"))).click();
    }

    public void inputNumberCount(String number) throws InterruptedException {
        WebElement numberElement = wait.until(ExpectedConditions.visibilityOfElementLocated(pathNumberCounter));
        String id = numberElement.getAttribute("for");
        System.out.println("numero del id"+id);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(id))).sendKeys(number);
        Thread.sleep(2000);
        WebElement buttonElement = wait.until(ExpectedConditions.visibilityOfElementLocated(pathButton));
        buttonElement.click();
        By locator = By.xpath("//div[contains(@class, 'TagItem---tag') and contains(@class, 'TagItem---tag_bg_color_positive') and @title='ACTIVE']/span[text()='ACTIVE']");
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public void inpuntIdTransaction(String idTransaction) throws InterruptedException {
        WebElement idTransactionElement = wait.until(ExpectedConditions.visibilityOfElementLocated(pathInputIdTransaction));
        String id = idTransactionElement.getAttribute("for");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(id))).sendKeys(idTransaction);
        Thread.sleep(2000);
        WebElement elementButton = wait.until(ExpectedConditions.visibilityOfElementLocated(pathButtonidTransaction));
        elementButton.click();
    }

    public void clickButtonIdTransaction(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(pathButtonidTransaction)).click();
    }

    public void inputDateNow(String date){
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(pathDateNow));
        String id = element.getAttribute("for");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(id))).sendKeys(date);
    }

    public void clickInputCounter(String counter){
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(pathInputCounter));
        String id = element.getAttribute("for");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(id))).sendKeys(counter);
    }

    public void  clickCreateRequest(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(pathButtonCreateRequest)).click();
    }

    public String getNumberCount() {
        String value = wait.until(ExpectedConditions.visibilityOfElementLocated(pathSuccesTextMessage)).getText();
        return FileConfig.extractNumber(value);
    }
    public void goNavigationNewRequest() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(pathGoNavigation)).click();
    }

}
