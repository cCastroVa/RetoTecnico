package stepdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import models.LoginNewUserData;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actors.OnStage;
import questions.Answer;
import tasks.LoginNewUser;
import tasks.OpenUp;

public class StepDefinitionsNewUser {
    @Given("the user is on the login page")
    public void theUserIsOnTheLoginPage() {
        OnStage.theActorCalled("user").wasAbleTo(OpenUp.thePage());
    }
    @When("he login on the main page")
    public void heLoginOnTheMainPage(DataTable dataNewUser) {
        OnStage.theActorInTheSpotlight().attemptsTo(LoginNewUser.onThePage(LoginNewUserData.setData(dataNewUser).get(0)));
    }
    @Then("he should see the {string} page")
    public void heShouldSeeTheDashboardPage(String response) {
        OnStage.theActorInTheSpotlight().should(GivenWhenThen.seeThat(Answer.toThe(response)));
    }
}
