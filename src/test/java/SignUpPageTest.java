import org.junit.*;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Configuration.driverManagerEnabled;
import static com.codeborne.selenide.Selenide.$;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.SignUpPage;

import java.util.concurrent.TimeUnit;

public class SignUpPageTest {
    static WebDriver driver;
    SignUpPage page;

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Dell\\IdeaProjects\\TestProject\\driver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://www.spotify.com/by-ru/signup/");

    }

    @Test
    public void typeInvalidYear(){
        page = new SignUpPage(driver);
        page.setMonth("Январь")
                .typeDay("11")
                .typeYear("15")
                .setShare(true);
        Assert.assertTrue(page.isErrorVisible("Укажите действительный год."));
        Assert.assertFalse(page.isErrorVisible("Укажите действительный день месяца."));
    }

    @Test
    public void typeInvalidEmail(){
        page = new SignUpPage(driver);
        page.typeEmail("test@mail.test")
                .typeConfirmEmail("sdgsdg@sdf.ru")
                .typeName("Zheka")
                .clickSignUpButton();
        Assert.assertTrue(page.isErrorVisible("Адреса электронной почты не совпадают."));
    }

    @Test
    public void signUpWithoutPassword(){
        page = new SignUpPage(driver);
        page.typeEmail("sdfsdf@sdf.ri")
                .typeConfirmEmail("sdfsdf@sdf.ri")
                .typeName("Zhkea")
                .clickSignUpButton();
        Assert.assertTrue(page.isErrorVisible("Введите пароль."));
    }
    @After
    public void tearDown(){
        driver.quit();
    }

}
