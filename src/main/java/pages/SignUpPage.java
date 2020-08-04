package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static java.lang.String.format;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class SignUpPage {
    WebDriver driver;
    
    public SignUpPage(WebDriver driver){
        this.driver = driver;
    }



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
    
    public SignUpPage typeEmail(String email){
        driver.findElement(emailField).sendKeys(email);
        return this;
    }

    public SignUpPage typeConfirmEmail(String email){
        driver.findElement(confirmEmail).sendKeys(email);
        return this;
    }

    public SignUpPage typePassword(String password){
        driver.findElement(passwordField).sendKeys(password);
        return this;
    }

    public SignUpPage typeName(String name){
        driver.findElement(nameField).sendKeys(name);
        return this;
    }

    public SignUpPage typeDay(String day){
        driver.findElement(dayOfBirthField).sendKeys(day);
        return this;
    }

    public SignUpPage setMonth(String month){
        driver.findElement(monthDropDown).click();
        new WebDriverWait(driver,5).until(visibilityOfElementLocated(By.xpath(format(monthDropDownOption, month)))).click();
        return this;
    }

    public SignUpPage typeYear(String year){
        driver.findElement(yearOfBirthField).sendKeys(year);
        return this;
    }

    public SignUpPage setSex(String value){
       driver.findElement(By.xpath(format(sexRadioButton, value))).click();
       return this;
    }

    public SignUpPage setShare(boolean value){
        WebElement checkbox = driver.findElement(shareCheckBox);
        if (!checkbox.isSelected() == value){
            checkbox.click();
        }
        return this;
    }

    public void clickSignUpButton(){
        driver.findElement(signUpButton).click();
    }

    public List<WebElement> getErrors1(){
        return driver.findElements(errorMessage1);
    }

    public List<WebElement> getErrors2(){
        return driver.findElements(errorMessage2);
    }

    public List<WebElement> getErrors3(){
        return driver.findElements(errorMessage3);
    }

    public List<WebElement> getErrors4(){
        return driver.findElements(errorMessage4);
    }

    public List<WebElement> getErrors5(){
        return driver.findElements(errorMessage5);
    }
    public boolean isErrorVisible(String message){
        return driver.findElements(By.xpath(format(errorMessageText, message))).size() > 0
                && driver.findElements(By.xpath(format(errorMessageText, message))).get(0).isDisplayed();
    }


}
