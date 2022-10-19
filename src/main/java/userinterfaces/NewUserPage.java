package userinterfaces;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class NewUserPage extends PageObject {
    public static final Target BUTTON_ADMIN = Target.the("Click on the administration button")
            .located(By.xpath("//a[@title='Administration']"));
    public static final Target BUTTON_USER = Target.the("Click on the option user management")
            .located(By.xpath("//span[contains(text(),'User')]"));
    public static final Target BUTTON_NEW_USER = Target.the("Click on the option of new user")
            .located(By.xpath("//span[contains(text(),'New User')]"));
    public static final Target INPUT_USER_NAME = Target.the("Where we write the new user name")
            .located(By.name("Username"));
    public static final Target INPUT_DISPLAY_NAME = Target.the("Where we write the display name of user")
            .located(By.name("DisplayName"));
    public static final Target INPUT_EMAIL = Target.the("Where we write the user email")
            .located(By.name("Email"));
    public static final Target INPUT_ROL = Target.the("Where we write the user rol")
            .located(By.id("s2id_autogen2"));
    public static final Target INPUT_PHONE_NUMBER = Target.the("Where we write the user phone number")
            .located(By.name("MobilePhoneNumber"));
    public static final Target INPUT_PASSWORD = Target.the("Where we write the user password")
            .located(By.name("Password"));
    public static final Target INPUT_CONFIRM_PASSWORD = Target.the("Where we write the confirm password")
            .located(By.name("PasswordConfirm"));
    public static final Target BUTTON_SAVE = Target.the("Click on the save button")
            .located(By.className("save-and-close-button"));
    @FindBy(className = "s-EditLink")
    public List<WebElement> userCreated;
    public WebElement getUserNameCreated(String userName) {
        for (WebElement userCreated : userCreated) {
            if (userCreated.getText().equals(userName)) {
                return userCreated;
            }
        }
        return null;
    }
}
