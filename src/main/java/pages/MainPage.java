package pages;

import org.apache.xerces.impl.xpath.XPath;
import org.junit.After;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;


/**
 * Created by Олег on 29.02.2016.
 */
public class MainPage extends SitePage {

    public MainPage(WebDriver driver) {
        super(driver);//конструктор класса
    }

    @FindBy(id = "ttOW")                             //описание страницы через PageFactory
    public WebElement tudaButton;

    @FindBy(id = "ttOri0")
    public WebElement otkudaButton;

    @FindBy(id = "ttDest0")
    public WebElement kudaButton;

    @FindBy(css = ".cityWidgetMenuFooter")
    private WebElement dropdownList;

    @FindBy(className = "calendarButton")
    public WebElement callButton;            //Каллендарь

    @FindBy(xpath = "//*[@id=\"date_picker_ttLeaveDate0\"]/div/div[2]/div/a/span")
    public WebElement nextMonth;

    @FindBy(xpath = "//*[@id=\"date_picker_ttLeaveDate0\"]/div/div[1]/table/tbody/tr[1]/td[5]/a")
    public WebElement date;

    @FindBy(id = "ttConfirm")
    public WebElement checkboxOznak;

    @FindBy(id = "ttSubmitBtn")
    public WebElement searchButton;

    @FindBy(id = "ttLeaveDate0")
    public WebElement callPole;

    public SearchPage search(String fromCity, String toCity, String date) {
        tudaButton.click();

        otkudaButton.sendKeys(fromCity);
        wait.until(ExpectedConditions.elementToBeClickable(dropdownList));
        dropdownList.click();

        kudaButton.sendKeys(toCity);
        wait.until(ExpectedConditions.elementToBeClickable(dropdownList));
        dropdownList.click();

        callPole.sendKeys(date);

        checkboxOznak.click();
        return openSearchPage();
    }

    public SearchPage openSearchPage() {
        searchButton.click();
        return new SearchPage(driver);
    }
}
