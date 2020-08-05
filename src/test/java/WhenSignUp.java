import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.*;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import steps.SignUpSteps;

import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

@RunWith(SerenityRunner.class)
public class WhenSignUp {
    @Steps
    SignUpSteps steps;

    @Managed
    WebDriver driver;

    @Before
    public void setUp(){
        String pathToGeckoDriver = Paths.get("C:\\Users\\Dell\\IdeaProjects\\TestProject\\driver\\chromedriver.exe").toAbsolutePath().toString();
        System.setProperty("webdriver.gecko.driver", pathToGeckoDriver);
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    }
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

//    @Test
//    public void typeInvalidEmail(){
//        steps.open_signup_page();
//        steps.type_email("test@mail.test");
//        steps.type_confirmation_email("sdgsdg@sdf.ru");
//        steps.type_name("Zheka");
//        steps.click_singUp();
//        steps.should_see_error("Адреса электронной почты не совпадают.");
//    }
//
//    @Test
//    public void signUpWithoutPassword(){
//        steps.open_signup_page();
//        steps.type_email("test@mail.test");
//        steps.type_confirmation_email("test@mail.test");
//        steps.type_name("Zheka");
//        steps.click_singUp();
//        steps.should_see_error("Введите пароль.");
//    }


}
