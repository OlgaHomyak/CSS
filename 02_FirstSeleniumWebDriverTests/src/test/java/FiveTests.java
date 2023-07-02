import org.junit.Assert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FiveTests {
    @Test
    @DisplayName("Все данные заполнены")
    public void hiVa(){
        System.setProperty("webdriver.chrome.driver","drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://lm.skillbox.cc/qa_tester/module02/homework1/");
        driver.findElement(By.name("name")).sendKeys("Вася");
        driver.findElement(By.name("email")).sendKeys("vasya@mail.com");
        driver.findElement(By.name("phone")).sendKeys("88002000600");
        driver.findElement(By.className("button")).click();
        var actualReult = driver.findElement(By.className("start-screen__res")).getText();
        var expectedResult = "Здравствуйте, Вася.\n" +
                "На вашу почту (vasya@mail.com) отправлено письмо.\n" +
                "Наш сотрудник свяжется с вами по телефону: 88002000600.";
        Assert.assertEquals(expectedResult, actualReult);
        driver.quit();
    }
    @Test
    @DisplayName("все данные пусты")
    public void zero(){
        System.setProperty("webdriver.chrome.driver","drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://lm.skillbox.cc/qa_tester/module02/homework1/");
        driver.findElement(By.className("button")).click();
        var actualReult = driver.findElement(By.className("start-screen__res")).getText();
        var expectedResult = "Здравствуйте, .\n" +
                "На вашу почту () отправлено письмо.\n" +
                "Наш сотрудник свяжется с вами по телефону: .";
        Assert.assertEquals(expectedResult, actualReult);
        driver.quit();
    }
    @Test
    @DisplayName("Пустое значение телефона при вводе букв")
    public void zeroPhone() {
        System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        try {
            driver.navigate().to("https://lm.skillbox.cc/qa_tester/module02/homework1/");
            driver.findElement(By.name("phone")).sendKeys("addadas");
            driver.findElement(By.className("button")).click();
            var actualResult = driver.findElement(By.className("start-screen__res")).getText();
            var expectedResult = "Здравствуйте, .\n" +
                    "На вашу почту () отправлено письмо.\n" +
                    "Наш сотрудник свяжется с вами по телефону: .";
            Assert.assertEquals(expectedResult, actualResult);
        } finally {
            driver.quit();
        }
    }

    @Test
    @DisplayName("Название полей")
    public void namePanel() {
        System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://lm.skillbox.cc/qa_tester/module02/homework1/");
        var actualResult1 = driver.findElement(By.name("name")).getAttribute("aria-label");
        var expectedResult1 = "ФИО";
        Assert.assertEquals(expectedResult1, actualResult1);
        var actualResult2 = driver.findElement(By.name("email")).getAttribute("aria-label");
        var expectedResult2 = "E-mail";
        Assert.assertEquals(expectedResult2, actualResult2);
        var actualResult3 = driver.findElement(By.name("phone")).getAttribute("aria-label");
        var expectedResult3 = "Телефон";
        Assert.assertEquals(expectedResult3, actualResult3);
        driver.quit();
    }
    @Test
    @DisplayName("Название формы")
    public void nameForm() {
        System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://lm.skillbox.cc/qa_tester/module02/homework1/");
        var actualResult = driver.findElement(By.className("start-screen__text")).getText();
        var expectedResult = "Введите свои данные";
        Assert.assertEquals(expectedResult, actualResult);
        driver.quit();

    }
}
