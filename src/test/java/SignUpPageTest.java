import org.junit.*;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.$;

import pages.SignUpPage;

public class SignUpPageTest {

    SignUpPage page;

    @BeforeClass
    public static void setUp(){
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\Dell\\IdeaProjects\\TestProject\\driver\\chromedriver.exe");
        baseUrl = "https://www.spotify.com/by-ru/signup/";
        System.setProperty("selenide.browser", "Chrome");
        //        driver.manage().window().maximize();
    }

    @Test
    public void typeInvalidYear(){
        page = new SignUpPage();
        page.open()
                .setMonth("Январь")
                .typeDay("11")
                .typeYear("15")
                .setShare(true);
        page.getError("Укажите действительный год.").shouldBe(visible);
        page.getError("Укажите действительный день месяца.").shouldNotBe(visible);
    }

    @Test
    public void typeInvalidEmail(){
        page = new SignUpPage();
        page.open()
                .typeEmail("test@mail.test")
                .typeConfirmEmail("sdgsdg@sdf.ru")
                .typeName("Zheka")
                .clickSignUpButton();
        page.getError("Адреса электронной почты не совпадают.").shouldBe(visible);
    }

    @Test
    public void signUpWithoutPassword(){
        page = new SignUpPage();
        page.open()
                 .typeEmail("sdfsdf@sdf.ri")
                .typeConfirmEmail("sdfsdf@sdf.ri")
                .typeName("Zhkea")
                .clickSignUpButton();
        page.getError("Введите пароль.").shouldBe(visible);
    }

}
