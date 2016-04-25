package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by boroa on 11.03.2016.
 */
public class MainMenu extends SiteBlock {

    public MainMenu(WebDriver driver) {
        super(driver);
    }

    @FindBy(className = "menu-btn")
    public WebElement news;


}


