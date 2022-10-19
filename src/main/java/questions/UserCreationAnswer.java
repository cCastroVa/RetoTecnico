package questions;

import models.UserCreationData;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import userinterfaces.NewUserPage;

public class UserCreationAnswer implements Question<Boolean> {
    private UserCreationData userCreationData;
    private NewUserPage newUserPage;
    public UserCreationAnswer(UserCreationData userCreationData) {
        this.userCreationData = userCreationData;
    }
    public static UserCreationAnswer toThe(UserCreationData userCreationData) {
        return new UserCreationAnswer(userCreationData);
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        boolean result;
        String userCreated = newUserPage.getUserNameCreated(userCreationData.getUser_name()).getText();
        if (userCreationData.getUser_name().equals(userCreated)){
            result = true;
        } else {
            result = false;
        }
        return result;
    }
}
