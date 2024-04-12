package StepDefinitions;

import Pages.LoginPage;
import Utility.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogPageStepDefinitions {
    private static final Logger log = LoggerFactory.getLogger(LogPageStepDefinitions.class);
    WebDriver driver = DriverFactory.getDriver() ;
    LoginPage loginPage = new LoginPage(driver);


    @Given("User on login page")
    public void userOnLoginPage() {
        loginPage.verifyUserOnLoginPage();
    }

    @When("Click login button")
    public void clickLoginButton() {
        loginPage.clickLoginButton();
    }

    @Then("Check Required  message about Username and Password")
    public void checkRequiredMessageAboutUsernameAndPassword() {
        loginPage.checkRequiredMessage();
    }

    @When("Text Username and Password")
    public void textUsernameAndPassword() {
        loginPage.writeUserNameAndPassword();
    }

    @Then("Check Invalid Credentials message")
    public void checkInvalidCredentialsMessage() {
        loginPage.checkInvalidCredentialsMessage();
    }

    @When("Text Valid Username and Valid Password")
    public void textValidUsernameAndValidPassword() {
        loginPage.writeInvalidUsernamAndPassword();
    }

    @Then("Check Successful login")
    public void checkSuccessfulLogin() {
        loginPage.checkDashboard();
    }
}
