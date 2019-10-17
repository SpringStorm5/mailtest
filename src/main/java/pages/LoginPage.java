package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage   {

    String baseURL = "https://mail.ru";

    private static final String CORRECT_LOGIN_AND_PASSWORD = ".//a[@id='PH_logoutLink']";
    private static final String NO_PASSWORD = ".//div[text()=\"Введите пароль\"]";

    private WebDriver driver;

    public LoginPage(WebDriver webdriver)
    {
       // super("login");
        PageFactory.initElements(webdriver, this);
        this.driver = webdriver;
     }


    @FindBy(id = "mailbox:submit")
    private  WebElement buttonpass;
//
    @FindBy(id = "mailbox:login")
    private WebElement loginField;

    @FindBy(id = "mailbox:password")
    private WebElement passwordField;

    @FindBy(xpath = "//*[@id='mailbox:submit']/input")
    private WebElement buttonEnter;

    @FindBy(xpath = CORRECT_LOGIN_AND_PASSWORD)
    private WebElement correctLink;

//



    public void enterLoginAndPass(String login, String password)
    {
           // driver.get(baseURL);
       //     driver.findElement(By.ById 'mailbox:login')
            loginField.clear();
            loginField.sendKeys(login);
            buttonEnter.click();
            WebDriverWait wait = new WebDriverWait(driver, 10);
            WebElement element = wait.until(
            ExpectedConditions.visibilityOfElementLocated(By.id("mailbox:password")));
            passwordField.clear();
            passwordField.sendKeys(password);
        driver.manage().window().maximize();
    }


    public void clickEnterButton()
    {
        buttonpass.click();
    }


   // Assert.assertTrue("Login test is failed!", loginPage.isLogLinkPresents(expectedXPath));








//

}

