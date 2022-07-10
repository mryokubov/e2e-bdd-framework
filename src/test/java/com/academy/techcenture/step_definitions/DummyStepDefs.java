package com.academy.techcenture.step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DummyStepDefs {

    @Given("user is in method one")
    public void user_is_in_method_one() {
        System.out.println("method one");
    }

    @When("user is in method two")
    public void user_is_in_method_two() {
        System.out.println("method two");
    }
    @When("user is in method three")
    public void user_is_in_method_three() {
        System.out.println("method three");
    }
    @Then("user is using {string} and {string}")
    public void user_is_using_and(String username, String password) {
        System.out.println("method four: " + username + " " + password);
    }


}
