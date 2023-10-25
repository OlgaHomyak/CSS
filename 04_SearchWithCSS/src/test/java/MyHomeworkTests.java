import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MyHomeworkTests {

    /* В этом классе можете описать тесты для домашнего задания */

    private WebDriver driver;

    @Before
    public void setUp()
    {
        System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
        driver = new ChromeDriver();
    }
    @After
    public void tearDown()
    {
        driver.quit();
    }

    private By emailSelector = By.id("email");
    private By password = By.name("password");
    private By enter = By.tagName("button");
    private By messageLocator = By.className("form-error-password-email");
    @Test
    public void  funnySocks(){
        driver.navigate().to("https://qajava.skillbox.ru/module04/homework/auth/index.html");
        driver.findElement(emailSelector).sendKeys("@");
        driver.findElement(password).sendKeys("123");
        driver.findElement(enter).click();
        Assert.assertTrue("Некорректный email или пароль", driver.findElement(messageLocator).isDisplayed());

    }




}
