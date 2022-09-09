package test.metro.loc;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SeleniumMetroTest {
    // создай поля для драйвера и страницы
    private ... driver;
    private ... metroPage;

    // создай константы для тестовых данных
    private static final ... CITY_SAINTP = "Санкт-Петербург";
    ... ... STATION_SPORTIVNAYA = "Спортивная";

    // все предварительные действия вынеси в Before
    @Before
    public void setUp() {
        // открой браузер Chrome
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
        driver = ...;
        // перейди на страницу тестового приложения
        driver.get(...);
        // создай объект класса страницы стенда
        metroPage = new MetroHomePage(driver);
        // дождись загрузки страницы
        metroPage.waitForLoadHomePage();
    }

    // проверь, как работает выбор города
    @Test
    public void checkChooseCityDropdown() {
        // выбери Санкт-Петербург в списке городов
       ...
        // проверь, что станция метро «Спортивная» видна через 8 секунд
       ...
    }

    // добавь метод с аннотацией After для закрытия браузера
    ...
    public void tearDown() {
        // закрой браузер
       ...
    }

}