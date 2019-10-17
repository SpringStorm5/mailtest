package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.MailPage;
import pages.WebDriverSingleton;
@Test
public class SendMailTest {

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
        System.out.println("Заходим на сайт mail.ru");
        webDriver.get(baseURL);
    }

    public void sentmailtest() throws InterruptedException {
        webDriver = WebDriverSingleton.getInstance();
        loginPage = new LoginPage(webDriver);
        System.out.println("Вводим логин и пароль");
        loginPage.enterLoginAndPass(login, password);
        System.out.println("Нажимаем кнопку Войти");
        loginPage.clickEnterButton();
        mailPage = new MailPage(webDriver);
        System.out.println("Заполняем  адрес:" + " " +  adress  + " " + "тема:" + " " + subject + " " + "текст пісьма" + " " +  text + " " + "и отправляем с проверкой");
        mailPage.sendMessage(adress,subject,text);
        webDriver.quit();
    }

}
