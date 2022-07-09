package com.academy.techcenture.step_definitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class GoogleSearchStepDefinitions {

    private WebDriver driver;

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Given("user goes to google search page")
    public void user_goes_to_google_search_page() {

        driver.get("https://www.google.com");
        String  googleTitle = driver.getTitle();
        Assert.assertEquals("Titles don't match", "Google", googleTitle);

    }

    @When("user enters {string} in the search input box")
    public void user_enters_in_the_search_input_box(String searchKeyword) {
        driver.findElement(By.name("q")).sendKeys(searchKeyword);
    }

    @And("user presses enter key")
    public void user_presses_enter_key() {
        driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
    }

    @Then("user should see results for searched item")
    public void user_should_see_results_for_searched_item() {

        String pageSource = driver.getPageSource();
        Assert.assertTrue("page source does not contains the searched keyword", pageSource.toLowerCase().contains("unicorns"));

    }


    @When("clicks on about link on top right")
    public void clicksOnAboutLinkOnTopRight() {
        WebElement aboutLnk = driver.findElement(By.xpath("//a[text()='About']"));
        Assert.assertTrue("about link is not displayed", aboutLnk.isDisplayed());
        new Actions(driver).moveToElement(aboutLnk).click().perform();
    }

    @Then("user can see mission statement at the center")
    public void userCanSeeMissionStatementAtTheCenter() {
        WebElement missionStatement = driver.findElement(By.xpath("//h1[starts-with(@class,'modules-lib__mission-statement__headline')]"));
        Assert.assertTrue(missionStatement.isDisplayed());
        Assert.assertEquals("Mission statement does not match", missionStatement.getText().trim(), "Our mission is to organize the world’s information and make it universally accessible and useful.");

    }

    @After
    public void cleanUp(){
        if (driver != null){
            driver.quit();
        }
    }
}
