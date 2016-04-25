package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Олег on 03.03.2016.
 */
public class PassengerPage extends SitePage {
    public PassengerPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "prefix-0")
    public WebElement prefix;

    @FindBy(id = "last_name-0")
    public WebElement lastName;

    @FindBy(id = "first_name-0")
    public WebElement firstName;

    @FindBy(id = "dob-0_0")
    public WebElement day;

    @FindBy(id = "dob-0_1")
    public WebElement month;

    @FindBy(xpath = "//*[@id=\"dob-0_1\"]/option[6]")
    public WebElement monthValue;

    @FindBy(id = "dob-0_2")
    public WebElement year;

    @FindBy(css = "#dob-0_2 > option:nth-child(17)")
    public WebElement yearValue;

    @FindBy(id = "gender-0-MALE")
    public WebElement gender;

    @FindBy(css = "#dob-0_0 > option:nth-child(6)")
    public WebElement dayValue;

    @FindBy(id = "doc_number-0")
    public WebElement doc;

    @FindBy(id = "phone0-1-areaCode-raw")
    public WebElement phone1;

    @FindBy(id = "phone0-1-number-raw")
    public WebElement phone2;

    @FindBy(id = "contactInfo-email-1")
    public WebElement email1;

    @FindBy(id = "email_retype-1")
    public WebElement email2;

    @FindBy(id = "subs_do_sub")
    public WebElement okCheck;

    @FindBy(id = "btn-search")
    public WebElement contButton;

    //public RulesPage chooseFlight() {


      //  return openRulesPage();
//    }

    public RulesPage openRulesPage() {
        contButton.click();
        return new RulesPage(driver);
    }

    public RulesPage passengerInfo(String lastNameData, String firstNameData, String idNumber, String phone1Data, String phone2Data, String email) {
        lastName.sendKeys(lastNameData);
        firstName.sendKeys(firstNameData);
        day.click();
        dayValue.click();
        month.click();
        monthValue.click();
        year.click();
        yearValue.click();
        gender.click();
        doc.sendKeys(idNumber);
        phone1.sendKeys(phone1Data);
        phone2.sendKeys(phone2Data);
        email1.sendKeys(email);
        email2.sendKeys(email);
        okCheck.click();
        return openRulesPage();
    }


}
