package userinterfaces;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;

public class CreateUnitPage extends PageObject {
    public static final Target ORGANIZATION = Target.the("Click on the option of Organization")
            .located(By.xpath("//*[text()='Organization']"));
    public static final Target UNIT_BUSINESS = Target.the("Click on the option of Business Unit")
            .located(By.xpath("//*[text()='Business Units']"));
    public static final Target NEW_UNIT_BUSINESS = Target.the("Click on the option of New Business Unit")
            .located(By.xpath("//span[contains(text(),'New Business')]"));
    public static final Target INPUT_NAME_UNITBUSINESS = Target.the("Where do we write the name of New Business Unit")
            .located(By.name("Name"));
    public static final Target PARENT_UNIT = Target.the("Click on the parent unit")
            .located(By.id("select2-chosen-1"));
    public static final Target INPUT_PARENT_UNIT = Target.the("Where do we write the name of the parent unit")
            .located(By.id("s2id_autogen1_search"));
    public static final Target BUTTON_SAVE = Target.the("Click on the button for save the unit busisness")
            .located(By.xpath("//span[contains(text(),'Save')]"));
    @FindBy(className = "s-Pro-Organization-BusinessUnitLink")
    public List<WebElement> unitCreated;
    public WebElement getUnitNameCreated(String unitName) {
        for (WebElement unitCreated : unitCreated) {
            if (unitCreated.getText().equals(unitName)) {
                return unitCreated;
            }
        }
        return null;
    }

}