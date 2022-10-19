package questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import userinterfaces.LoginPage;

public class Answer implements Question<Boolean> {
    private String response;
    public Answer(String response) {
        this.response = response;
    }
    public static Answer toThe(String response) {
        return new Answer(response);
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        boolean result;
        String namePage = Text.of(LoginPage.NAME_PAGE).answeredBy(actor);
        if (response.equals(namePage)){
            result = true;
        }else {
            result = false;
        }
        return result;
    }
}
