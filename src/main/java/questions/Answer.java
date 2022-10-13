package questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import userinterfaces.LoginPage;

public class Answer implements Question<Boolean> {
    private String page;
    public Answer(String page) {
        this.page = page;
    }
    public static Answer toThe(String page) {
        return new Answer(page);
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        boolean result;
        String namePage = Text.of(LoginPage.NAME_PAGE).asString().answeredBy(actor);
        if(page.equalsIgnoreCase(namePage)){
            result = true;
        } else {
            result = false;
        }
        return result;
    }
}
