import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MyHomeworkTests {
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
    public void searchingElementsFrontPageBookstore1() {
        driver.navigate().to("https://qajava.skillbox.ru/index.html");//переходим на главную страницу сайта

        //для элемента <a href="" test-info="about-us">О магазине</a>. поиск  по атрибуту test-info, равному about-us.
        var firstLocatorB1 = By.cssSelector("[test-info='about-us']");
        //для всех элементов с тегом a и с атрибутом href с пустым значением, то есть равным «».
        var secondLocatorB1 = By.cssSelector("a[href='']");
        //СП. для всех элементов с тегом option и с атрибутом selected. Осуществите поиск только по атрибуту selected.
        var thirdLocatorB1 = By.cssSelector("option[selected]");
        //для элемента <div class="book-price">. Осуществите поиск одновременно по тегу и классу, равному book-price.
        var fourthLocatorB1 = By.cssSelector("div.book-price");
        //для всех элементов с тегом button и с атрибутом class, начинающимся на book.
        var fifthLocatorB1 = By.cssSelector("button[class^='book']");
        //для всех элементов, у которых атрибут class заканчивается на main.
        var sixthLocatorB1 = By.cssSelector("[class$='main']");
        //для всех элементов с тегом a и с атрибутом class, содержащим в себе слово menu.
        var seventhLocatorB1 = By.cssSelector("a[class*='menu']");

        driver.findElement(firstLocatorB1);
        driver.findElement(secondLocatorB1);
        driver.findElement(By.cssSelector("a[href='search.html']")).click(); //переходим на страницу поиска
        driver.findElement(thirdLocatorB1);
        driver.findElement(By.cssSelector("a[href='index.html']")).click(); //переходим обратно на главную страницу
        driver.findElement(fourthLocatorB1);
        driver.findElement(fifthLocatorB1);
        driver.findElement(sixthLocatorB1);
        driver.findElement(seventhLocatorB1);
    }

    @Test
    public void searchingElementsFrontPageBookstore2() {
        driver.navigate().to("https://qajava.skillbox.ru/index.html");//переходим на сайт

        //найдите все теги div, которые являются дочерними элементами первого уровня у элемента <footer id="footer">.
        var firstLocatorB2 = By.cssSelector("#footer > div");
        //найдите любой тег, который расположен сразу после <li id="genres">.
        var secondLocatorB2 = By.cssSelector("#genres + *");
        //СП. найдите любые теги, которые расположены после <div class="filter-container">.
        var thirdLocatorB2 = By.cssSelector(".filter-container ~ *");

        driver.findElement(firstLocatorB2);
        driver.findElement(secondLocatorB2);
        driver.findElement(By.cssSelector("a[href='search.html']")).click(); //переходим на страницу поиска
        driver.findElement(thirdLocatorB2);
    }

    @Test
    public void searchingElementsFunnySock() {
        driver.navigate().to("https://qajava.skillbox.ru/module05/auth/index.html/");//переходим на сайт

        //Первый  h1,на 1 уровне влож.в-ри <section class="important-section-block" for="main-header-page">.по 1 child.
        var firstLocatorFS = By.cssSelector("section.important-section-block[for='main-header-page'] > h1:first-child");
        //Последний p, наход. сразу на первом уровне вл-сти внутри <form class="form" id="login-form">. поиск по child.
        var secondLocatorFS = By.cssSelector("form#login-form > p:last-child");
        //Любой тег, который является третьим дочерним элементом первого уровня тега <body>. Используйте поиск по child.
        var thirdLocatorFS = By.cssSelector("body > *:nth-child(3)");
        //Все элементы <a>, которые явл. первым элементом своего родителя <div class="footer__menuList">. поиск по type.
        var fourthLocatorFS = By.cssSelector("div.footer__menuList > a:first-of-type");
        //найдите элемент с тегом <a>, который является первым дочерним элементом данного типа у своего родителя
        // <div class="footer__menuList">, при этом <div class="footer__menuList"> является первым дочерним элементом
        // у своего родителя <div class="footer__menu">. Составленный поиск должен вернуть ровно один найденный элемент.
        var fifthLocatorFS = By.cssSelector("div.footer__menu > div.footer__menuList:first-child > a:nth-of-type(1)");

        driver.findElement(firstLocatorFS);
        driver.findElement(secondLocatorFS);
        driver.findElement(thirdLocatorFS);
        driver.findElement(fourthLocatorFS);
        driver.findElement(fifthLocatorFS);
    }
}
