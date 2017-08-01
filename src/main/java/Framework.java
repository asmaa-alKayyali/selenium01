import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class Framework {
    private WebDriver driver;

    @BeforeSuite
    public void setUp() {
        ChromeDriverManager.getInstance().setup();
        driver = new ChromeDriver();
    }

    @AfterSuite
    public void tearDown(){
        driver.quit();
    }

    public void goTo(String url) {
        driver.get(url);
    }

    /**
     * TODO describe me please =P
     * @param by
     * @param id
     * @param value
     */
    public void fillElement(String by, String id, String value) {
        WebElement element = findElement(by, id);
        element.sendKeys(value);
    }

    public void click(String by, String id) {
        findElement(by, id).click();
    }

    public String getText(String by, String id){
        return findElement(by, id).getText();
    }

    public boolean isExists (String msg){
        return driver.getPageSource().contains(msg);
    }

    private WebElement findElement(String by, String id) {
        if (by.equalsIgnoreCase("name"))
            return driver.findElement(By.name(id));
        else if (by.equalsIgnoreCase("id"))
            return driver.findElement(By.id(id));
        else if (by.equalsIgnoreCase("cssSelector"))
            return driver.findElement(By.cssSelector(id));

        return null;
        // TODO add all cases...
    }
}
