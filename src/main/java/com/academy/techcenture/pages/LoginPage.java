package com.academy.techcenture.pages;

import com.academy.techcenture.config.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import static org.junit.Assert.*;

public class LoginPage extends HomePage{

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "email")
    private WebElement emailInput;

    @FindBy(id = "passwd")
    private WebElement passwdInput;

    @FindBy(id = "SubmitLogin")
    private WebElement loginBtn;

    @FindBy(xpath = "//h3[contains(text(),'Already registered?')]")
    private WebElement loginHeaderTxt;

    @FindBy(xpath = "//label[@for='email']")
    private WebElement emailLabel;

    @FindBy(xpath = "//label[@for='passwd']")
    private WebElement passwdLabel;

    @FindBy(xpath = "//a[contains(@title, 'Recover your forgotten')]")
    private WebElement forgotPswdLink;

    @FindBy(xpath = "//h3[contains(text(),'Create an account')]")
    private WebElement createAccountHeaderTxt;

    @FindBy(xpath = "//p[contains(text(),'Please enter your email address')]")
    private WebElement enterEmailTxt;

    @FindBy(xpath = "//label[@for='email_create']")
    private WebElement createAccountEmailLabel;

    @FindBy(id = "email_create")
    private WebElement createEmailInput;

    @FindBy(id = "SubmitCreate")
    private WebElement createAccountBtn;

    @FindBy(xpath = "//div[contains(@class,'alert-danger')]//li")
    private WebElement authFailerErrorMsg;

    @FindBy(id = "create_account_error")
    private WebElement invalidEmailErrorMsg;

    @FindBy(id = "login_form")
    private WebElement loginForm;


    public void enterUserName(){
        assertTrue( "Email label was not dipslayed", emailLabel.isDisplayed());
        emailInput.clear();
        emailInput.sendKeys(ConfigReader.getProperty("username"));
    }

    public void enterPassword(){
        assertTrue("Forgot passwd is not displayed",forgotPswdLink.isDisplayed());
        assertTrue( "Password label was not dipslayed", passwdLabel.isDisplayed());
        passwdInput.clear();
        passwdInput.sendKeys(ConfigReader.getProperty("password"));
    }

    public void clickOnLoginBtn(){
        assertEquals("sign in", loginBtn.getText().toLowerCase().trim());
        assertTrue( "Login Btn is not enabled",loginBtn.isEnabled());
        loginBtn.click();
    }




    public void enterRandomEmail(){
        String randomEmail = commonUtils.randomEmail();
        createEmailInput.sendKeys(randomEmail);
        assertTrue(createAccountBtn.isEnabled());
        createAccountBtn.click();
    }

    public void verifyUserIsOnLoginPage(){

        String loginTitle = driver.getTitle();
        assertEquals("Titles are not matching","Login - My Store", loginTitle);
        assertTrue("Login Header was not displayed", loginHeaderTxt.isDisplayed() );
        assertTrue("Login form is not there", loginForm.isDisplayed());
    }

}
