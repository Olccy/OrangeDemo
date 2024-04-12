package Pages;

import org.apache.commons.logging.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.testng.Assert.assertEquals;

public class LoginPage {
    WebDriver driver;
    Utility.ElementHelper elementHelper;
    WebDriverWait wait;

    public LoginPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver,10);
        this.elementHelper = new Utility.ElementHelper(driver);

    }

    By LoginTitle = By.cssSelector(".oxd-text--h5");
    By LoginButton = By.cssSelector(".oxd-button");
    By requiredMessageUserName = By.cssSelector(".oxd-form > div:nth-of-type(1) .oxd-text");
    By requiredMessagePassword = By.cssSelector(".oxd-form > div:nth-of-type(2) .oxd-text");
    By usernameField = By.cssSelector("[name='username']");
    By passwordField = By.cssSelector("[name='password']");
    By invalidMessage = By.cssSelector(".oxd-alert-content-text");
    By dashboardText = By.cssSelector(".oxd-text--h6");

    public void verifyUserOnLoginPage() {
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        WebElement title = driver.findElement(LoginTitle);
        String titleText = title.getText();
        assertEquals(titleText,"Login");
    }

    public void clickLoginButton() {
        driver.findElement(LoginButton).click();
    }

    public void checkRequiredMessage() {
        elementHelper.checkVisible(requiredMessageUserName);
        elementHelper.checkVisible(requiredMessagePassword);

    }

    public void writeUserNameAndPassword() {
        driver.findElement(usernameField).click();
        elementHelper.sendKey(usernameField,"selenium");
        driver.findElement(passwordField).click();
        elementHelper.sendKey(passwordField,"77777");
    }

    public void checkInvalidCredentialsMessage() {
        WebElement errorMessage = driver.findElement(invalidMessage);
        String errorMessageText = errorMessage.getText();
        assertEquals(errorMessageText,"Invalid credentials");

    }

    public void writeInvalidUsernamAndPassword() {
        driver.findElement(usernameField).click();
        elementHelper.sendKey(usernameField,"Admin");
        driver.findElement(passwordField).click();
        elementHelper.sendKey(passwordField,"admin123");
    }

    public void checkDashboard() {
        WebElement checkDashboardText = driver.findElement(dashboardText);
        String successfulMessageText = checkDashboardText.getText();
        assertEquals(successfulMessageText,"Dashboard");

    }
}
