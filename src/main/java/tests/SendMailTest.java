package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import org.apache.log4j.Logger;
import pages.LoginPage;
import pages.MailPage;
import pages.WebDriverSingleton;
@Test
public class SendMailTest {

    final static Logger logger = Logger.getLogger(SendMailTest.class);

    private WebDriver webDriver;
    private LoginPage loginPage;
    private MailPage mailPage;

    String baseURL = "https://mail.ru";

    String login = "elhanatest@mail.ru";
    String password = "6279508Rino5";
    String adress = "springstorm666@gmail.com";
    String subject = "test theme";
    String text = "body test text";

    public void loadMainPage()
    {
        webDriver = WebDriverSingleton.getInstance();
        loginPage = new LoginPage(webDriver);
        logger.info("Заходим на сайт mail.ru");
        webDriver.get(baseURL);
    }

    public void sentmailtest() throws InterruptedException {
        webDriver = WebDriverSingleton.getInstance();
        loginPage = new LoginPage(webDriver);
        logger.info("Вводим логин и пароль");
        loginPage.enterLoginAndPass(login, password);
        logger.info("Нажимаем кнопку Войти");
        loginPage.clickEnterButton();
        mailPage = new MailPage(webDriver);
        logger.info("Заполняем  адрес:" + " " +  adress  + " " + "тема:" + " " + subject + " " + "текст пісьма" + " " +  text + " " + "и отправляем с проверкой");
        mailPage.sendMessage(adress,subject,text);
        webDriver.quit();
    }

}
