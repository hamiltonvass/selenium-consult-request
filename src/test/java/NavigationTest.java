import Config.FileConfig;
import Pages.ConsultRequest;
import Pages.Login;
import Pages.NewRequest;
import Pages.NavigationUrl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class NavigationTest {

    private NavigationUrl navigationUrl;

     private WebDriver driver;

    @BeforeAll
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setupTest() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterEach
    void teardown() {
//        driver.quit();
    }

    @Test
    public void navigateToGoogle () {
        try {

            navigationUrl = new NavigationUrl(driver);
            navigationUrl.goNavigationNewRequest();
            navigationLogin("jfierro", "Jadrez0323/.");
            Thread.sleep(2000);
            String idTraceability = navigationNewRequest();
            Thread.sleep(2000);
            System.out.println("idTraceability: " + idTraceability);
            consultRequest(idTraceability);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void navigationLogin(String username, String password) {
        Login loginPage = new Login(driver);
        loginPage.inputName(username);
        loginPage.inputPassword(password);
        loginPage.clickLogin();
    }

    private String navigationNewRequest() {
        try {
            NewRequest newRequest = new NewRequest(driver);
            newRequest.clickCreateReverses();
            newRequest.selectReverseConcept("SALDO PROMEDIO");
            newRequest.inputNumberCount("03502398025130");
            newRequest.inpuntIdTransaction("35193");
            newRequest.clickButtonIdTransaction();
            newRequest.inputDateNow(FileConfig.getCurrentDate());
            newRequest.clickInputCounter("201");
            newRequest.clickCreateRequest();
            String idTraceability = newRequest.getNumberCount();
            newRequest.goNavigationNewRequest();
            return idTraceability;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }

    private void consultRequest(String idTraceability) {
        try {
            ConsultRequest consultRequest = new ConsultRequest(driver);
            consultRequest.inputSelect("Reverso");
            consultRequest.inputSelect("SALDO PROMEDIO");
            consultRequest.inputSelect("Pendiente Por Aprobar");
            consultRequest.inputTextIDRequest(idTraceability);
            consultRequest.inputDateFrom(FileConfig.getCurrentDate());
            consultRequest.inputDateTo(FileConfig.getCurrentDate());
            consultRequest.clickConsultRequest();
            consultRequest.consultIdRequest(idTraceability);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }










}
