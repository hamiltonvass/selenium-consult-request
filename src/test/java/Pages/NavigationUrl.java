package Pages;

import org.openqa.selenium.WebDriver;

public class NavigationUrl {

    public static String newRequest = "https://qa-towerautomation.towerbank.com/suite/sites/accounting-entry-management/page/new-request";

    private WebDriver driver;

    public NavigationUrl(WebDriver driver) {
        this.driver = driver;
        driver.manage().window().maximize();
    }

    public void goNavigationNewRequest() {
        driver.get(newRequest);
    }

}
