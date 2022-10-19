package tasks;

import models.NewUserData;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import org.openqa.selenium.Keys;
import userinterfaces.NewUserPage;

public class CreateThe implements Task {
    private NewUserData newUserData;

    public CreateThe(NewUserData newUserData) {
        this.newUserData = newUserData;
    }

    public static CreateThe newUser(NewUserData newUserData) {
        return Tasks.instrumented(CreateThe.class, newUserData);
    }


    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(NewUserPage.BUTTON_ADMIN),
                Click.on(NewUserPage.BUTTON_USER),
                Click.on(NewUserPage.BUTTON_NEW_USER),
                Enter.theValue(newUserData.getUser_name()).into(NewUserPage.INPUT_USER_NAME),
                Enter.theValue(newUserData.getDisplay_name()).into(NewUserPage.INPUT_DISPLAY_NAME),
                Enter.theValue(newUserData.getEmail()).into(NewUserPage.INPUT_EMAIL),
                Enter.theValue(newUserData.getRoles()).into(NewUserPage.INPUT_ROL).thenHit(Keys.ENTER),
                Enter.theValue(newUserData.getMobile_phone_number()).into(NewUserPage.INPUT_PHONE_NUMBER),
                Enter.theValue(newUserData.getPassword()).into(NewUserPage.INPUT_PASSWORD),
                Enter.theValue(newUserData.getConfirm_password()).into(NewUserPage.INPUT_CONFIRM_PASSWORD),
                Click.on(NewUserPage.BUTTON_SAVE));
    }
}
