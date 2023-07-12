import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class bookstore {
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
    public void searchingElements() {
        driver.navigate().to("http://qajava.skillbox.ru/");
        driver.findElement(By.linkText("Обратная связь"));
        driver.findElement(By.linkText("Предзаказы"));
        //не знаю какой лучше выбрать вариант, первый не нравиться, но второй я нагуглил и не понимю его работы.
        driver.findElements(By.linkText("В корзину"));
        driver.findElement(By.cssSelector("button.book-add"));
        var kar = driver.findElement(By.id("cart_count")).getText();
        System.out.println(kar);
        driver.findElement(By.linkText("Книги"));
        driver.findElement(By.cssSelector("input[placeholder='Поиск по магазину...']"));
        var bookInfoElements  = driver.findElements(By.cssSelector("div.book-info"));
        if (bookInfoElements.size() == 15) {
            System.out.println("Количество элементов равно 15");
        } else {
            System.out.println("Количество элементов не равно 15");
        }



    }
}
