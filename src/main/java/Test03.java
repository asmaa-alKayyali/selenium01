import org.testng.Assert;
import org.testng.annotations.Test;

public class Test03 extends Framework {
    String username;
    String password;

    @Test(priority = 1)
    private void register() {
        goTo("http://demo.guru99.com/");
        String email = "example@example.com";
        fillElement("name", "emailid", email);
        click("name", "btnLogin");
        username = getText("cssSelector", "body > table > tbody > tr:nth-child(4) > td:nth-child(2)");
        Assert.assertTrue(isExists("Access details to demo site."), "the value does not exist");
    }

    @Test(priority = 2)
    private void login() {
        goTo("http://demo.guru99.com/V4/index.php");
        Assert.assertTrue(isExists("Steps To Generate Access"));
        fillElement("name", "uid", username);
        fillElement("name", "password", password);
        click("name", "btnLogin");
        Assert.assertTrue(isExists("Welcome To Manager's Page of Guru99 Bank"));
    }
}