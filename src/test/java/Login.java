import core.BrowserFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginForm;
import pages.MainPage;

public class Login extends BrowserFactory {

    MainPage mainPage = new MainPage();


    @DataProvider(name = "emailsAndPassword")
    public Object[][] emailsProvider() {
        return new Object[][]{
                {"romandubovyi@gmail.com", "tktdfnjh1993"},
        };
    }

    @Test(dataProvider = "emailsAndPassword")
    public void login(String email, String password) {
        mainPage.open();
        mainPage.loginForm.login(email, password);
        mainPage.loginForm.isElementPresent(LoginForm.notificationIcon);
        Assert.assertTrue(mainPage.loginForm.isElementPresent(LoginForm.notificationIcon));
    }


    @DataProvider(name = "NameEmailsAndPassword")
    public Object[][] namesEmailsProvider() {
        return new Object[][]{
                {randomName(), randomEmail(), randomPass()},
                {randomName(), randomEmail(), randomPass()},
                {randomName(), randomEmail(), randomPass()},


        };
    }

    @Test(dataProvider = "NameEmailsAndPassword")
    public void registration(String name, String email, String password) {
        mainPage.openReg();

        mainPage.loginForm.registration(name, email, password);
        try {
            Assert.assertTrue(mainPage.loginForm.isElementPresent(LoginForm.headerNotification));
        } catch (Exception e) {
            System.out.println("Notification is absent");
        }
    }
}
