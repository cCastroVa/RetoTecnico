package tasks;

import models.DataRequired;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import org.openqa.selenium.Keys;
import userinterfaces.CreateUnitPage;

public class CreateUnit implements Task {
    private DataRequired dataRequired;
    public CreateUnit(DataRequired dataRequired) {
        this.dataRequired = dataRequired;
    }
    public static CreateUnit ofBusiness(DataRequired dataRequired) {
        return Tasks.instrumented(CreateUnit.class, dataRequired);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(CreateUnitPage.ORGANIZATION),
                Click.on(CreateUnitPage.UNIT_BUSINESS),
                Click.on(CreateUnitPage.NEW_UNIT_BUSINESS),
                Enter.theValue(dataRequired.getName_unit()).into(CreateUnitPage.INPUT_NAME_UNITBUSINESS),
                Click.on(CreateUnitPage.PARENT_UNIT),
                Enter.theValue(dataRequired.getParents_unit()).into(CreateUnitPage.INPUT_PARENT_UNIT).thenHit(Keys.DOWN)
                        .thenHit(Keys.ENTER),
                Click.on(CreateUnitPage.BUTTON_SAVE));
    }
}
