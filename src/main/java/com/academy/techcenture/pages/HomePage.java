package com.academy.techcenture.pages;

import com.academy.techcenture.config.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import static org.junit.Assert.*;
import java.util.List;
import java.util.Map;

public class HomePage extends BasePage{

    public HomePage(WebDriver driver) {
        super(driver);
    }

    //web elements
    @FindBy(xpath = "//a[@class='login']")
    protected WebElement signInLink;

    @FindBy(linkText = "Contact us")
    protected WebElement contactUsLink;

    @FindBy(className = "logout")
    protected WebElement signOutLink;

    @FindBy(id = "search_query_top")
    protected WebElement searchInputBox;

    @FindBy(xpath = "//button[contains(@class,'button-search')]")
    protected WebElement searchBtn;

    @FindBy(xpath = "//div[@id='block_top_menu']/ul/li/a")
    protected List<WebElement> topMenuTabs;

    @FindBy(xpath = "//ul[contains(@class,'submenu-container')]/li/ul/li/a")
    protected List<WebElement> womenProducts;

    @FindBy(xpath = "(//ul[contains(@class,'submenu-container')])[2]/li/a")
    protected List<WebElement> typesOfDresses;

    @FindBy(xpath = "//div[@class='ac_results']//li[1]")
    protected WebElement dropdownFirstItem;

    @FindBy(xpath = "//img[contains(@class,'logo')]")
    private WebElement logo;

    public void clickSingInLink() {
        assertTrue("Sign in link was not displayed", signInLink.isEnabled());
        actions.click(signInLink).perform();
   //     signInLink.click();
        wait.until(ExpectedConditions.titleIs("Login - My Store"));
    }

    public void clickContactUsLink(){
        assertTrue("Contact us link is not displayed",contactUsLink.isDisplayed() );
        contactUsLink.click();
        System.out.println("clicking contact us link");
    }

    public void signOut(){
        if (signOutLink.isDisplayed()){
            signOutLink.click();
            wait.until(ExpectedConditions.invisibilityOf(signOutLink));
        }
    }

    public void searchProduct(String product) {
        searchInputBox.sendKeys(product);
        wait.until(ExpectedConditions.visibilityOf(dropdownFirstItem));
        dropdownFirstItem.click();
    }

    public void navigateToHomePage(){
        driver.get(ConfigReader.getProperty("URL"));
        assertEquals("Titles do not match","My Store",driver.getTitle());
        assertTrue("Logo is not displayed",logo.isDisplayed());
    }

}
