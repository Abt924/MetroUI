package test.metro.loc;

import metro.loc.MetroHomePage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SeleniumMetroTest {
    // создай поля для драйвера и страницы
    private WebDriver driver;
    private MetroHomePage metroPage;

    // создай константы для тестовых данных
    private static final String CITY_SAINTP = "Санкт-Петербург";
    private static final String STATION_SPORTIVNAYA = "Спортивная";

    // все предварительные действия вынеси в Before
    @Before
    public void setUp() {
        // открой браузер Chrome
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
        String chrome_driver_binary = "D:\\Distrib\\Chrome\\Driver\\chromedriver.exe";
        driver = new ChromeDriver( options);
        // перейди на страницу тестового приложения
        driver.get("https://qa-metro.stand-2.praktikum-services.ru/");
        // создай объект класса страницы стенда
        metroPage = new MetroHomePage(driver);
        // дождись загрузки страницы
        metroPage.waitForLoadHomePage();
    }

    // проверь, как работает выбор города
    @Test
    public void checkChooseCityDropdown() {
        // выбери Санкт-Петербург в списке городов
       metroPage.chooseCity(CITY_SAINTP);
        // проверь, что станция метро «Спортивная» видна через 8 секунд
       metroPage.waitForStationVisibility(STATION_SPORTIVNAYA);
       assert (true);
    }

    // добавь метод с аннотацией After для закрытия браузера
    @After
    public void tearDown() {
        // закрой браузер
       driver.quit();
    }

}