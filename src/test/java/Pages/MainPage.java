package Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.testng.Assert.assertEquals;

public class MainPage {
    WebDriver driver;
    Utility.ElementHelper elementHelper;
    WebDriverWait wait;

    public MainPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver,10);
        this.elementHelper = new Utility.ElementHelper(driver);


    }

    By myInfo = By.cssSelector("[href='/web/index.php/pim/viewMyDetails'] > .oxd-text");
    By saveButton = By.cssSelector("#app > div.oxd-layout > div.oxd-layout-container > div.oxd-layout-context > div > div > div > div.orangehrm-edit-employee-content > div.orangehrm-horizontal-padding.orangehrm-vertical-padding > form > div.oxd-form-actions > button");
    By infoTitle = By.cssSelector(".oxd-userdropdown-name");

    public void clickToMyInfo() {
        driver.findElement(myInfo).click();

    }

    public void changeNameAndSurname() {
        WebElement Username = driver.findElement(By.cssSelector("#app > div.oxd-layout > div.oxd-layout-container > div.oxd-layout-context > div > div > div > div.orangehrm-edit-employee-content > div.orangehrm-horizontal-padding.orangehrm-vertical-padding > form > div:nth-child(1) > div > div > div > div.--name-grouped-field > div:nth-child(1) > div:nth-child(2) > input"));
        Username.sendKeys(Keys.CONTROL+"a");
        Username.sendKeys(Keys.DELETE);
        Username.sendKeys("Garavel");

        WebElement Surname = driver.findElement(By.cssSelector("#app > div.oxd-layout > div.oxd-layout-container > div.oxd-layout-context > div > div > div > div.orangehrm-edit-employee-content > div.orangehrm-horizontal-padding.orangehrm-vertical-padding > form > div:nth-child(1) > div > div > div > div.--name-grouped-field > div:nth-child(3) > div:nth-child(2) > input"));
        Surname.sendKeys(Keys.CONTROL+"a");
        Surname.sendKeys(Keys.DELETE);
        Surname.sendKeys("Tihulu");
    }

    public void clickToSaveButton(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,350)");
        driver.findElement(saveButton).click();

    }

    public void checkNewInfo() {
        driver.findElement(myInfo);
        WebElement newNameAndSurname = driver.findElement(infoTitle);
        String newNameAndSurnameText = newNameAndSurname.getText();
        assertEquals(newNameAndSurnameText,"Garavel Tihulu");

    }
}
