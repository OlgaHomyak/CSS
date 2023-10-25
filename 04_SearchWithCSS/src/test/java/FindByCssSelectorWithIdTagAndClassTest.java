import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindByCssSelectorWithIdTagAndClassTest {
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

    private By emailSelector = By.cssSelector("input#email.form-input.input-data");
    private By password = By.cssSelector("input#password.form-input.password");
    private By enter = By.cssSelector("button#submit.form-submit");
    private By messageLocator = By.cssSelector("pre#error.form-error-password-email");
    @Test
    public void  funnySocks(){
        driver.navigate().to("https://qajava.skillbox.ru/module04/homework/auth/changed.html");
        driver.findElement(emailSelector).sendKeys("@");
        driver.findElement(password).sendKeys("123");
        driver.findElement(enter).click();
        Assert.assertTrue("Некорректный email или пароль", driver.findElement(messageLocator).isDisplayed());

    }




}