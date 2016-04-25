package pages;

import com.google.common.base.Function;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Олег on 29.02.2016.
 */
public class SitePage extends SiteBlock {

    public MainMenu mainMenu = new MainMenu(driver); //ссылка на мейн

    public SitePage(WebDriver driver) {
        super(driver);
        waitUntilPageIsLoaded();
    }

    public void waitUntilPageIsLoaded() {
        Boolean complete = wait.until(new Function<WebDriver, Boolean>() {

            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
            }
        });
    }

}
