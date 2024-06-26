import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindByCssSelectorTest {

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

    private By emailSelector = By.cssSelector(".form-input.input-data");
    private By password = By.cssSelector(".form-input.password");
    private By enter = By.cssSelector("button#submit.form-submit");
    private By messageLocator = By.cssSelector(".form-error-password-email");
    @Test
    public void  funnySocks(){
        driver.navigate().to("https://qajava.skillbox.ru/module04/homework/auth/changed.html");
        driver.findElement(emailSelector).sendKeys("@");
        driver.findElement(password).sendKeys("123");
        driver.findElement(enter).click();
        Assert.assertTrue("Некорректный email или пароль", driver.findElement(messageLocator).isDisplayed());

    }




}

