import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.*;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import steps.SignUpSteps;

@RunWith(SerenityRunner.class)
public class WhenSignUp {
    @Steps
    SignUpSteps steps;

    @Managed
    WebDriver driver;


    @Test
    public void typeInvalidYear(){
        steps.open_signup_page();
        steps.set_month("Январь");
        steps.set_day("15");
        steps.set_year("15");
        steps.set_share(true);
        steps.should_see_error("Укажите действительный год.");
        steps.should_not_see_error("Укажите действительный день месяца.");
    }

    @Test
    public void typeInvalidEmail(){
        steps.open_signup_page();
        steps.type_email("test@mail.test");
        steps.type_confirmation_email("sdgsdg@sdf.ru");
        steps.type_name("Zheka");
        steps.click_singUp();
        steps.should_see_error("Адреса электронной почты не совпадают.");
    }

    @Test
    public void signUpWithoutPassword(){
        steps.open_signup_page();
        steps.type_email("test@mail.test");
        steps.type_confirmation_email("test@mail.test");
        steps.type_name("Zheka");
        steps.click_singUp();
        steps.should_see_error("Введите пароль.");
    }


}
