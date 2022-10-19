package tasks;

import models.LoginNewUserData;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import userinterfaces.LoginPage;

public class LoginNewUser implements Task {
    private LoginNewUserData loginNewUserData;

    public LoginNewUser(LoginNewUserData loginNewUserData) {
        this.loginNewUserData = loginNewUserData;
    }
    public static LoginNewUser onThePage(LoginNewUserData loginNewUserData) {
        return Tasks.instrumented(LoginNewUser.class, loginNewUserData);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Enter.theValue(loginNewUserData.getUser()).into(LoginPage.INPUT_USERNAME),
                Enter.theValue(loginNewUserData.getPassword()).into(LoginPage.INPUT_PASSWORD),
                Click.on(LoginPage.BUTTON_LOGIN));
    }
}
