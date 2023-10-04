package org.example.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.BaseTest;
import org.example.app.Calculator;
import org.junit.jupiter.api.Assertions;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class MathStepsDefinitions extends BaseTest {

    int a = 0;
    int b = 0;
    int total = 0;

    Calculator calculator = new Calculator();

    @Given("I am on the calculator page")
    public void givenUserInCalculatorPage() {
        String titleText = calculatorPage.getTitle();
        Assertions.assertEquals("Calculator", titleText);

        boolean isDisplayed = calculatorPage.historyBtnAppear();
        Assertions.assertTrue(isDisplayed);
    }

    @And("a is {int}")
    public void givenAIs(int value) {
        a = value;
        calculatorPage.tapFirstOperand();
    }

    @And("b is {int}")
    public void givenBIs(int value) {
        b = value;
        calculatorPage.tapPlusOperator();
        calculatorPage.tapSecondOperand();
    }

    @When("I add a and b")
    public void iAddAandB() {
        total = calculator.add(a,b);
        calculatorPage.tapEqual();
    }

    @Then("the total should be {int}")
    public void theTotalShouldBe(int expectedTotal) {
        assertThat(total).isEqualTo(expectedTotal);
        assertThat(total).isEqualTo(calculatorPage.getResult(expectedTotal));
    }
}
