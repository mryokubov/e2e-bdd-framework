package com.academy.techcenture.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import static org.junit.Assert.*;
import java.util.List;

public class UserAccountPage extends HomePage {

    public UserAccountPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(className = "logout")
    private WebElement signOutLink;

    @FindBy(xpath = "//a[@class='account']/a")
    private WebElement accountLink;

    @FindBy(xpath = "//h1[@class='page-heading']")
    private WebElement myAccntHeader;

    @FindBy(xpath = "//ul[@class='myaccount-link-list']/li/a/span")
    private List<WebElement> accountOptions;

    @FindBy(className = "info-account")
    private WebElement welcomeMsgTxt;

    @FindBy(xpath = "//a[@title='Home']")
    private WebElement homeBtn;


    private String[] accountOptionsExpected = {"order history and details",
            "my credit slips", "my addresses","my personal information","my wishlists"};


    public void verifyAccountOptions(){
        assertEquals(5, accountOptions.size());
        for (int i = 0; i < accountOptions.size(); i++) {
            assertEquals("account option does not match", accountOptionsExpected[i],accountOptions.get(i).getText().toUpperCase());
        }
    }

    public void navigateHome(){
        assertTrue(homeBtn.isDisplayed());
        homeBtn.click();
    }

    public void verifyUserIsOnAccountPage(){
        String loginTitle = driver.getTitle();
        assertEquals("Titles are not matching","My account - My Store", loginTitle);
        assertTrue("My Account header is not displayed",myAccntHeader.isDisplayed());
    }

    public void verifyUserName(String userName){
        assertTrue(accountLink.isDisplayed());
        String userNameTxt = accountLink.getText();
        assertEquals("User name does not match", userName, userNameTxt);
    }

}
