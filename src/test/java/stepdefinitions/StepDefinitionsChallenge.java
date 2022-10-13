package stepdefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import questions.Answer;
import tasks.Login;
import tasks.OpenUp;

public class StepDefinitionsChallenge {
    @Before
    public void setStage(){
        OnStage.setTheStage(new OnlineCast());
    }
    @Given("he trainee is on the main page")
    public void heTraineeIsOnTheMainPage() {
        OnStage.theActorCalled("trainee").wasAbleTo(OpenUp.thePage());
    }
    @When("he login on the page")
    public void heLoginOnThePage() {
        OnStage.theActorInTheSpotlight().attemptsTo(Login.onThePage());
    }
    @Then("he should see the {string} page")
    public void heShouldSeeTheDashboardPage(String page) {
        OnStage.theActorInTheSpotlight().should(GivenWhenThen.seeThat(Answer.toThe(page)));
    }
}
