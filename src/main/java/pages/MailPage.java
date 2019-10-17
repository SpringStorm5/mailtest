package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class MailPage  {

    String address = "springstorm666@gmail.com";
    String subject = "test message";
    String text = "это тестовое сообщение написанное автоматическим скриптом";

    @FindBy (xpath = "(//*[@class='compose-button__txt'])")
    WebElement button_write_message;

    @FindBy (xpath = "//*[@class=\"container--H9L5q size_s--3_M-_\"]")
    WebElement input_addressees;

    @FindBy (xpath = ".//input[@name=\"Subject\"]")
    WebElement input_subject;

    @FindBy(xpath = "//*[(@role=\"textbox\")]")
    WebElement msg_text_frame;

    @FindBy (xpath = "//body[@id='tinymce']")
    WebElement msg_text;

    @FindBy (xpath = "//*[@title=\"Отправить\"]")
    WebElement button_send_message;

    @FindBy (css = "a.layer__link")
    WebElement message_sent;

    private Actions action;
    private WebDriver driver;
    private WebDriverWait wait;

    public MailPage(WebDriver webdriver)
    {
        PageFactory.initElements(webdriver, this);
        this.driver = webdriver;
        wait = new WebDriverWait(driver, 20);
        action = new Actions(driver);
        //logger.debug(super.getType() + " page is created");
    }

    public void sendMessage(String address, String subject, String text) throws InterruptedException {

             WebDriverWait wait = new WebDriverWait(driver, 10);
             WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.className("compose-button__txt")));
             button_write_message.click();


            Thread.sleep(1000);
            input_addressees.clear();
            input_addressees.sendKeys(address);

            input_subject.clear();
            input_subject.sendKeys(subject);

            msg_text_frame.sendKeys(text);
            button_send_message.click();

            WebElement msg_sent = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a.layer__link")));
            boolean check = message_sent.isDisplayed();
            System.out.println("Письмо успешно отправлено" + " " +  check);
            Assert.assertTrue(check);
        }

    }


