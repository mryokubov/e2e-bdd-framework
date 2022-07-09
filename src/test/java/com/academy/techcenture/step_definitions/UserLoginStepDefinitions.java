package com.academy.techcenture.step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.*;
import java.time.Duration;
import java.util.List;

public class UserLoginStepDefinitions {

    private WebDriver driver;
    private Actions actions;
    private WebDriverWait wait;
    
    
    @Given("user is on the homepage")
    public void user_is_on_the_homepage() {

        //set up everything
        setUp();

        driver.get("http://automationpractice.com");
        String  actualTitle = driver.getTitle();
        assertEquals("Titles don't match", "My Store", actualTitle);

        WebElement logo = driver.findElement(By.xpath("//img[contains(@class,'logo')]"));
        assertTrue("Logo is not displayed",logo.isDisplayed());
    }

    @When("user clicks on sign in link")
    public void user_clicks_on_sign_in_link() {

        WebElement signInLink = driver.findElement(By.partialLinkText("Sign in"));
        assertTrue("Sign in link is not displayed", signInLink.isDisplayed());
        actions.click(signInLink).perform();

    }

    @When("user should be navigated to login screen")
    public void user_should_be_navigated_to_login_screen() {
        String loginTitle = driver.getTitle();
        assertEquals("Titles are not matching","Login - My Store", loginTitle);
        WebElement loginForm = driver.findElement(By.id("login_form"));
        assertTrue("Login form is not there", loginForm.isDisplayed());
    }

    @And("user enters {string} and {string} in the credential inputs")
    public void userEntersAndInTheCredentialInputs(String username, String password) {
        driver.findElement(By.id("email")).sendKeys(username);
        driver.findElement(By.id("passwd")).sendKeys(password);
    }

    @When("user clicks on login button")
    public void user_clicks_on_login_button() {
        WebElement loginBtn = driver.findElement(By.id("SubmitLogin"));
        assertTrue("Login btn is not enabled", loginBtn.isDisplayed());
        loginBtn.click();

    }

    @When("user should be navigated to account page")
    public void user_should_be_navigated_to_account_page() {

        String myAccountTitle = driver.getTitle();
        assertEquals("Title dont match","My account - My Store",myAccountTitle);
        WebElement header = driver.findElement(By.xpath("//h1[contains(@class,'page-heading')]"));
        assertTrue("My Account header is not displayed",header.isDisplayed());
        String[] expectedAccountOptions = {"Order history and details","My credit slips","My addresses","My personal information","My wishlists"};
        List<WebElement> accoutnOptions = driver.findElements(By.xpath("//ul[@class='myaccount-link-list']/li/a/span"));
        for (int i = 0; i < accoutnOptions.size(); i++) {
            assertEquals("account option does not match", expectedAccountOptions[i].toUpperCase(), accoutnOptions.get(i).getText().toUpperCase().trim());
        }
    }

    @Then("user should be able to see their name on top")
    public void user_should_be_able_to_see_their_name_on_top() {
        WebElement userName = driver.findElement(By.xpath("//a[@class='account']/span"));
        assertTrue(userName.isDisplayed());
        String userNameTxt = userName.getText();

        assertEquals("User name does not match", "Kevin Lee", userNameTxt);
    }

    @And("user clicks on sing out link")
    public void userClicksOnSingOutLink() {
        WebElement singOutLInk = driver.findElement(By.partialLinkText("Sign out"));
        assertTrue(singOutLInk.isDisplayed());
        actions.click(singOutLInk).perform();
    }

    private void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        actions = new Actions(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }



}
