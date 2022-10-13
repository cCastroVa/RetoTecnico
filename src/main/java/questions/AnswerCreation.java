package questions;

import models.AnswerData;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import userinterfaces.CreateUnitPage;

public class AnswerCreation implements Question<Boolean> {
    private AnswerData answerData;
    private CreateUnitPage createUnitPage;
    public AnswerCreation(AnswerData answerData) {
        this.answerData = answerData;
    }

    public static AnswerCreation toThe(AnswerData answerData) {
        return new AnswerCreation(answerData);
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        boolean result;
        String unitCreated = createUnitPage.getUnitNameCreated(answerData.getName_unit()).getText();
        System.out.println(unitCreated);
        if (answerData.getName_unit().equals(unitCreated)){
            result = true;
        } else {
            result = false;
        }
        return result;
    }

}
