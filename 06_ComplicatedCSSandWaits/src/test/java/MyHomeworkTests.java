import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertTrue;

public class MyHomeworkTests {
    private WebDriver driver;
    private WebDriverWait wait5;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        wait5 = new WebDriverWait(driver, 5);
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void searchingElementsTest1()  {

        //Составьте такой CSS-локатор, по которому бы находились все элементы
        var a = By.cssSelector(".header p");
        var b = By.cssSelector("div[type='text'][name='mainBlock'] a");
        var c = By.cssSelector("div.text > a");
    }

    @Test
    public void searchingElementsFrontTaxiTest2() {
        driver.navigate().to("https://lm.skillbox.cc/qa_tester/module04/practice1/");//переходим на главную страницу сайта

        //Найдите тег input, у которого нет атрибута id.
        var firstTaxi = By.cssSelector("input:not([id])"); // поле ввода времени
        //Найдите все теги p, + выполняются 2 условия: class начинается с form; class НЕ заканчивается на error.
        var secondTaxi = By.cssSelector("p[class^='form']:not([class$='error'])"); // 3 элемента
        //Найдите <div class="form-inner">, у него найдите первый по счёту элемент такого типа: <p class="form-row">.
        var thirdTaxi = By.cssSelector("div.form-inner p.form-row:first-child"); // поле с датой

        driver.findElement(firstTaxi);
        driver.findElement(secondTaxi);
        driver.findElement(thirdTaxi);
    }

    @Test
    public void dailyPlannerTest3() {
        // 1. Перейдите на страницу.
        driver.navigate().to("http://qa.skillbox.ru/module15/bignotes/#/statistic");

        // 2. Кликните на заметку из списка заметок по центру экрана.
        var noteCenter = By.cssSelector(".articlePreview__link");
        driver.findElement(noteCenter).click();

        // 3. Дождитесь появления справа от заголовка выбранной записи в разделе «Все записи».
        var entryRight1 = By.cssSelector(".articlePreview.pageArticle__articlePreview:nth-of-type(1)");
        wait5.until(ExpectedConditions.presenceOfElementLocated(entryRight1));

        // считываем текст заголовка и записи с центра
        var actualTitleCenter = By.cssSelector("div.baseInput.pageArticle__baseInput input.baseInput__field");
        var actualNoteCenter = By.cssSelector("div.baseTextarea__inner textarea.baseTextarea__text");
        var textTitleCenter = driver.findElement(actualTitleCenter).getAttribute("value");
        var textNoteCenter = driver.findElement(actualNoteCenter).getAttribute("value");

        // считываем текст заголовка и записи справа
        var actualTitleRight = By.cssSelector("p.articlePreview__title");
        var actualNoteRight = By.cssSelector("p.articlePreview__text");
        var textTitleRight = driver.findElement(actualTitleRight).getText();
        var textNoteRight = driver.findElement(actualNoteRight).getText();


        // 4. Проверьте, что у первой записи текст и заголовок равен только что выбранной записи.
        Assert.assertEquals(textTitleRight,textTitleCenter);
        System.out.println("Заголовки: " + textTitleRight + " = " + textTitleCenter);
        Assert.assertEquals(textNoteCenter, textNoteRight);
        System.out.println("Записи: " + textNoteCenter + " = " + textNoteRight);

        // 5. Кликните по кнопке с иконкой корзины, расположенной в центральной белой части страницы.
        var trashCenter = By.cssSelector(".pageArticle__contentHeader > div > button:nth-child(2) > svg");
        driver.findElement(trashCenter).click();

        // 6. В разделе «Все записи» выберите самую верхнюю запись (первую).
        driver.findElement(entryRight1).click();

        // 7. Кликните по кнопке с иконкой корзины, расположенной в центральной белой части страницы.
        driver.findElement(trashCenter).click();

        // 8. Дождитесь исчезновения записи в разделе «Все записи».
        wait5.until(ExpectedConditions.presenceOfElementLocated(entryRight1));

        // 9. Проверьте, что справа в списке «Все записи» не видно записей.
        boolean noNotesVisible = driver.findElements(By.cssSelector("articlePreview__link")).isEmpty();
        assertTrue(noNotesVisible);

    }


}
