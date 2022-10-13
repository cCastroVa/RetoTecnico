package stepdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import models.AnswerData;
import models.DataRequired;
import models.LoginData;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import questions.AnswerCreation;
import tasks.CreateUnit;
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
    public void heLoginOnThePage(DataTable data) {
        OnStage.theActorInTheSpotlight().attemptsTo(Login.onThePage(LoginData.setData(data).get(0)));
    }
    @When("he create a Business Unit")
    public void heCreateABusinessUnit(DataTable dataBusinessUnit) {
        OnStage.theActorInTheSpotlight().attemptsTo(CreateUnit.ofBusiness(DataRequired.setData(dataBusinessUnit).get(0)));
    }
    @Then("he should see the Business Unit created in the page")
    public void heShouldSeeTheBusinessUnitCreatedInThePage(DataTable dataUnitCreated) {
        OnStage.theActorInTheSpotlight().should(GivenWhenThen.seeThat(AnswerCreation.toThe(AnswerData.setData(dataUnitCreated).get(0))));
    }
}
