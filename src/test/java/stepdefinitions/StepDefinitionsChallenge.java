package stepdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import models.*;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import questions.AnswerCreation;
import tasks.*;

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
        OnStage.theActorInTheSpotlight().should(GivenWhenThen.seeThat(AnswerCreation.toThe(AnswerData
                .setData(dataUnitCreated).get(0))));
    }

    @Given("he trainee logged on the page")
    public void heTraineeLoggedOnThePage(DataTable data) {
        OnStage.theActorCalled("trainee").wasAbleTo(OpenUp.thePage(), Login.onThePage(LoginData.setData(data).get(0)));
    }
    @When("he program a new meeting")
    public void heProgramANewMeeting(DataTable meetingTable) {
        OnStage.theActorInTheSpotlight().attemptsTo(CreationMeeting.ofUnit(MeetingData.setData(meetingTable).get(0)));
    }
    @When("he program the attendee")
    public void heProgramTheAttendee(DataTable listAttendee) {
        OnStage.theActorInTheSpotlight().attemptsTo(Attendee.List(AttendeeListData.setData(listAttendee).get(0)));
    }
    @Then("he should see the new meeting created in the page")
    public void heShouldSeeTheNewMeetingCreatedInThePage(io.cucumber.datatable.DataTable dataTable) {
    }
}
