package StepDefinitions;

import Pages.LoginPage;
import Pages.MainPage;
import Utility.DriverFactory;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.it.Ma;
import org.openqa.selenium.WebDriver;

public class MainPageStepDefinitions {
    WebDriver driver = DriverFactory.getDriver() ;
    MainPage mainPage = new MainPage(driver);
    @When("Click to my info")
    public void clickToMyInfo() {
        mainPage.clickToMyInfo();
    }

    @When("Change Name & Surname")
    public void changeNameSurname() {
        mainPage.changeNameAndSurname();
    }

    @When("Click to save button")
    public void clickToSaveButton() {
        mainPage.clickToSaveButton();
    }

    @Then("Check New name and surname")
    public void checkNewNameAndSurname() {
        mainPage.checkNewInfo();
    }
}
