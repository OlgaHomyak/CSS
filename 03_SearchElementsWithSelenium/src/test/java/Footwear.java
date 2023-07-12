import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Footwear {
    private WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void form() {

        driver.navigate().to("https://lm.skillbox.cc/qa_tester/module03/practice1/");

        var titlelement = driver.findElement(By.className("title"));
        var subtitleElement = driver.findElement(By.className("subtitle"));
        var inputElement = driver.findElement(By.className("input-field"));
        var sizeElement = driver.findElement(By.id("size"));
        var checkButtonElement = driver.findElement(By.id("check-size-button"));
    }

    @Test
    public void borderСondition1() {

        driver.navigate().to("https://lm.skillbox.cc/qa_tester/module03/practice1/");

        driver.findElement(By.id("size")).sendKeys("33");
        driver.findElement(By.id("check-size-button")).click();
        var actualReult1 = driver.findElement(By.id("size-error")).getText();
        var expectedResult1 = "В нашем магазине нет обуви вашего размера";
        Assert.assertEquals(expectedResult1, actualReult1);

    }
    @Test
    public void borderСondition2() {

        driver.navigate().to("https://lm.skillbox.cc/qa_tester/module03/practice1/");

        driver.findElement(By.id("size")).sendKeys("34");
        driver.findElement(By.id("check-size-button")).click();
        var actualReult2 = driver.findElement(By.id("size-success")).getText();
        var expectedResult2 = "В нашем магазине есть обувь вашего размера";
        Assert.assertEquals(expectedResult2, actualReult2);
    }
    @Test
    public void borderСondition3() {

        driver.navigate().to("https://lm.skillbox.cc/qa_tester/module03/practice1/");

        driver.findElement(By.id("size")).sendKeys("44");
        driver.findElement(By.id("check-size-button")).click();
        var actualReult3 = driver.findElement(By.id("size-success")).getText();
        var expectedResult3 = "В нашем магазине есть обувь вашего размера";
        Assert.assertEquals(expectedResult3, actualReult3);
    }
    @Test
    public void borderСondition4() {

        driver.navigate().to("https://lm.skillbox.cc/qa_tester/module03/practice1/");

        driver.findElement(By.id("size")).sendKeys("45");
        driver.findElement(By.id("check-size-button")).click();
        var actualReult4 = driver.findElement(By.id("size-error")).getText();
        var expectedResult4 = "В нашем магазине нет обуви вашего размера";
        Assert.assertEquals(expectedResult4, actualReult4);
    }
    @Test
    public void negTest() {

        driver.navigate().to("https://lm.skillbox.cc/qa_tester/module03/practice1/");

        driver.findElement(By.id("size")).sendKeys("test");
        driver.findElement(By.id("check-size-button")).click();
        var actualReult4 = driver.findElement(By.id("size-error")).getText();
        var expectedResult4 = "Введите размер обуви!";
        Assert.assertEquals(expectedResult4, actualReult4);
    }
}








