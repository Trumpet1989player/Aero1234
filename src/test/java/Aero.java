import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.*;

import java.util.concurrent.TimeUnit;

/**
 * Created by Олег on 27.02.2016.
 */
public class Aero {

    static int counter;

    public  Aero() {
        counter = counter + 1;
    }

    WebDriver driver;

//    @BeforeClass
//    public static void before(){
//
//    }

    @Before
    public void setUp() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void page() throws InterruptedException {
//        Aero.before();
        //System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
        //WebDriver driver = new ChromeDriver();

        driver.get("http://www.aeroflot.ru/cms");
        driver.manage().window().maximize();
        MainPage mainPage = new MainPage(driver);
        MainMenu mainMenu = new MainMenu(driver);

        SearchPage searchPage = mainPage.search("Москва", "Омск", "01042016");
        PassengerPage passengerPage = searchPage.openPassengerPage();
        RulesPage rulesPage = passengerPage.passengerInfo("IVAN", "IVANOV", "12341234", "123", "1231212", "qwert@qwer.ru");

        //RulesPage rulesPage = passengerPage.openRulesPage();
        mainMenu = new MainMenu(driver);
        rulesPage.wait.until(ExpectedConditions.elementToBeClickable(rulesPage.confirmCheckbox));
        rulesPage.confirmCheckbox.click();
        rulesPage.contButton.click();
    }

    @Test
    public void page2() throws InterruptedException {
        //System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
        //WebDriver driver = new ChromeDriver();

        driver.get("http://www.aeroflot.ru/cms");
        driver.manage().window().maximize();
        MainPage mainPage = new MainPage(driver);

        SearchPage searchPage = mainPage.search("Москва", "Омск", "01042016");
        PassengerPage passengerPage = searchPage.openPassengerPage();
        RulesPage rulesPage = passengerPage.passengerInfo("IVAN", "IVANOV", "12341234", "123", "1231212", "qwert@qwer.ru");

        //RulesPage rulesPage = passengerPage.openRulesPage();

        rulesPage.wait.until(ExpectedConditions.elementToBeClickable(rulesPage.confirmCheckbox));
        rulesPage.confirmCheckbox.click();
        rulesPage.contButton.click();
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}