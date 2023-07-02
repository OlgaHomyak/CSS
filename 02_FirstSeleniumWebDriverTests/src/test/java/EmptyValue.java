import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class EmptyValue {
    @Test
    public void hiVa(){
        System.setProperty("webdriver.chrome.driver","drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://lm.skillbox.cc/qa_tester/module01/");
        driver.findElement(By.className("button")).click();
        var actualReult = driver.findElement(By.className("start-screen__res")).getText();
        var expectedResult = "Привет, !";
        Assert.assertEquals(expectedResult, actualReult);
        driver.quit();
    }
}
