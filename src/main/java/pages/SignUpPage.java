package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static java.lang.String.format;

public class SignUpPage {



    private By emailField = By.xpath("//input[@id='email']");
    private By confirmEmail = By.xpath("//input[@id='confirm']");
    private By passwordField = By.xpath("//input[@id='password']");
    private By nameField = By.xpath("//input[@id='displayname']");
    private By dayOfBirthField = By.xpath("//input[@id='day']");
    private By monthDropDown = By.xpath("//select[@id='month']");
    private String monthDropDownOption = "//select[@id='month']/option[text()='%s']";
    private By yearOfBirthField = By.xpath("//input[@id='year']");
    private String sexRadioButton = "//div[@class='GenderSelect__FlexRow-v1a8zn-0 fRpOnE']//label//span[text()='%s']";
    private By shareCheckBox = By.xpath("//div[8]//label[1]//span[1]");
    private By signUpButton = By.xpath("//button[text()='Зарегистрироваться']");
    // Для полей: Емейл, имя, пароль. Менять предпоследний див с номерами 1-3
    private By errorMessage1 = By.xpath("//body/div[@id='__next']/main/div[@class='signuppage__Signup-sof6g5-0 YsCoj']/form/div[4]/div[2]");
    // Для трех полей даты рождения. Менять последний див с номерами 1-3
    private By errorMessage2 = By.xpath("//body[1]/div[1]/main[1]/div[2]/form[1]/div[5]/div[3]/div[3]");
    //Для ошибки в гендере
    private By errorMessage3 = By.xpath("//div[6]//div[3]");
    //Для ошибки в принятии условий
    private By errorMessage4 = By.xpath("/html[1]/body[1]/div[1]/main[1]/div[2]/form[1]/div[9]/div[1]");
    // Для ошибки в подтверждении, что пользователь не робот
    private By errorMessage5 = By.xpath("/html[1]/body[1]/div[1]/main[1]/div[2]/form[1]/div[10]/div[2]");
    private String errorMessageText = "//div[contains(text(),'%s')]";

    public SignUpPage open(){
        Selenide.open("/");
        return this;
    }

    public SignUpPage typeEmail(String email){
        $(emailField).setValue(email);
        return this;
    }

    public SignUpPage typeConfirmEmail(String email){
        $(confirmEmail).setValue(email);
        return this;
    }

    public SignUpPage typePassword(String password){
        $(passwordField).setValue(password);
        return this;
    }

    public SignUpPage typeName(String name){
        $(nameField).setValue(name);
        return this;
    }

    public SignUpPage typeDay(String day){
        $(dayOfBirthField).setValue(day);
        return this;
    }

    public SignUpPage setMonth(String month){
        $(monthDropDown).selectOption(month);
//                click();
//        new WebDriverWait(driver,5).until(visibilityOfElementLocated(By.xpath(format(monthDropDownOption, month)))).click();
        return this;
    }

    public SignUpPage typeYear(String year){
        $(yearOfBirthField).setValue(year);
        return this;
    }

    public SignUpPage setSex(String value){
        $(sexRadioButton).selectRadio(value);
        return this;
    }

    public SignUpPage setShare(boolean value){
        $(shareCheckBox).click();
        return this;
    }

    public void clickSignUpButton(){
        $(signUpButton).click();
    }

    public ElementsCollection getErrors1(){
        return $$(errorMessage1);
    }

    public ElementsCollection getErrors2(){
        return $$(errorMessage2);
    }

    public ElementsCollection getErrors3(){
        return $$(errorMessage3);
    }

    public ElementsCollection getErrors4(){
        return $$(errorMessage4);
    }

    public ElementsCollection getErrors5(){
        return $$(errorMessage5);
    }

    public SelenideElement getError(String message){
        return $(By.xpath(format(errorMessageText, message)));
    }

}
