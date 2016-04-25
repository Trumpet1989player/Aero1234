package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.SitePage;

/**
 * Created by Олег on 08.03.2016.
 */
public class RulesPage extends SitePage {
    public RulesPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "confirm")
    public WebElement confirmCheckbox;

    @FindBy(id = "btn-search")
    public WebElement contButton;

}
