package tasks;

import models.UnitData;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import org.openqa.selenium.Keys;
import userinterfaces.CreateUnitPage;

public class CreateUnit implements Task {
    private UnitData unitData;
    public CreateUnit(UnitData unitData) {
        this.unitData = unitData;
    }
    public static CreateUnit ofBusiness(UnitData unitData) {
        return Tasks.instrumented(CreateUnit.class, unitData);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(CreateUnitPage.ORGANIZATION),
                Click.on(CreateUnitPage.UNIT_BUSINESS),
                Click.on(CreateUnitPage.NEW_UNIT_BUSINESS),
                Enter.theValue(unitData.getName_unit()).into(CreateUnitPage.INPUT_NAME_UNITBUSINESS),
                Click.on(CreateUnitPage.PARENT_UNIT),
                Enter.theValue(unitData.getParents_unit()).into(CreateUnitPage.INPUT_PARENT_UNIT).thenHit(Keys.DOWN)
                        .thenHit(Keys.ENTER),
                Click.on(CreateUnitPage.BUTTON_SAVE));
    }
}
