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
import questions.Answer;
import questions.AnswerCreation;
import questions.MeetingCreationAnswer;
import questions.UserCreationAnswer;
import tasks.*;

public class StepDefinitionsChallenge {
    @Before
    public void setStage(){
        OnStage.setTheStage(new OnlineCast());
    }
    @Given("the trainee is on the main page")
    public void theTraineeIsOnTheMainPage() {
        OnStage.theActorCalled("trainee").wasAbleTo(OpenUp.thePage());
    }
    @When("he login on the page")
    public void heLoginOnThePage(DataTable data) {
        OnStage.theActorInTheSpotlight().attemptsTo(Login.onThePage(LoginData.setData(data).get(0)));
    }
    @When("he create a Business Unit")
    public void heCreateABusinessUnit(DataTable dataBusinessUnit) {
        OnStage.theActorInTheSpotlight().attemptsTo(CreateUnit.ofBusiness(UnitData.setData(dataBusinessUnit).get(0)));
    }
    @Then("he should see the Business Unit created in the page")
    public void heShouldSeeTheBusinessUnitCreatedInThePage(DataTable dataUnitCreated) {
        OnStage.theActorInTheSpotlight().should(GivenWhenThen.seeThat(AnswerCreation.toThe(AnswerData
                .setData(dataUnitCreated).get(0))));
    }

    @Given("the trainee created a new business unit")
    public void theTraineeCreatedANewBusinessUnit() {
        OnStage.theActorCalled("trainee").wasAbleTo(OpenUp.thePage());
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
    public void heShouldSeeTheNewMeetingCreatedInThePage(DataTable table) {
        OnStage.theActorInTheSpotlight().should(GivenWhenThen.seeThat(MeetingCreationAnswer.toThe(CreatedMeetingAnswerData
                .setData(table).get(0))));
    }

    @Given("the trainee is on the home page")
    public void theTraineeIsOnTheHomePage() {
        OnStage.theActorCalled("trainee").wasAbleTo(OpenUp.thePage());
    }
    @When("he create a new user")
    public void heCreateANewUser(DataTable tableUser) {
        OnStage.theActorInTheSpotlight().attemptsTo(CreateThe.newUser(NewUserData.setData(tableUser).get(0)));
    }
    @Then("he should see the user created on the page")
    public void heShouldSeeTheUserCreatedOnThePage(DataTable tableResponse) {
        OnStage.theActorInTheSpotlight().should(GivenWhenThen.seeThat(UserCreationAnswer.toThe(UserCreationData
                .setData(tableResponse).get(0))));
    }

}
