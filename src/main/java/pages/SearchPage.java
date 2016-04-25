package pages;

import com.google.common.base.Function;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;


/**
 * Created by Олег on 29.02.2016.
 */
public class SearchPage extends SitePage {

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "outbounds_filter_id")
    public WebElement sortBy;

    @FindBy(id = "outbounds_filter_nonStop")
    public WebElement nonStopCheckBox;

    @FindBy(xpath = "//input[contains(@id,'flight_both_')]")
    public List<WebElement> radioButtons;

    @FindBy (id = "btn-search")
    public WebElement contBtn;

    public PassengerPage openPassengerPage() {
        new Select(sortBy).selectByVisibleText("Минимальная цена");
        nonStopCheckBox.click();
        waitUntilRadioButtonsAreDisplayed();
        radioButtons.get(0).click();
        wait.until(ExpectedConditions.elementToBeClickable(contBtn));
        contBtn.click();
        return new PassengerPage(driver);
    }

    public void waitUntilRadioButtonsAreDisplayed() {
            Boolean complete = wait.until(new Function<WebDriver, Boolean>() {

                public Boolean apply(WebDriver driver) {
                    return !radioButtons.isEmpty();
                }
            });
        }
}
