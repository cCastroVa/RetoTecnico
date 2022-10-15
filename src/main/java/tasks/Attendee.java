package tasks;

import models.AttendeeListData;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.ui.Select;
import org.openqa.selenium.Keys;
import userinterfaces.AttendeeListPage;

public class Attendee implements Task {
    private AttendeeListData attendeeListData;
    public Attendee(AttendeeListData attendeeListData) {
        this.attendeeListData = attendeeListData;
    }

    public static Attendee List(AttendeeListData attendeeListData) {
        return Tasks.instrumented(Attendee.class, attendeeListData);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(AttendeeListPage.SELECT_CONTACT),
                Enter.theValue(attendeeListData.getAttendee_name()).into(AttendeeListPage.INPUT_CONTACT).thenHit(Keys.ENTER),
                Select.value(attendeeListData.getAttendee_type()).from(AttendeeListPage.SELECT_ATTENDEE_TYPE),
                Click.on(AttendeeListPage.SELECT_CONTACT),
                Enter.theValue(attendeeListData.getAttendee2_name()).into(AttendeeListPage.INPUT_CONTACT).thenHit(Keys.ENTER),
                Select.value(attendeeListData.getAttendee2_type()).from(AttendeeListPage.SELECT_ATTENDEE_TYPE),
                Click.on(AttendeeListPage.SELECT_CONTACT),
                Enter.theValue(attendeeListData.getAttendee3_name()).into(AttendeeListPage.INPUT_CONTACT).thenHit(Keys.ENTER),
                Select.value(attendeeListData.getAttendee3_type()).from(AttendeeListPage.SELECT_ATTENDEE_TYPE),
                Click.on(AttendeeListPage.BUTTON_SAVE));
    }
}