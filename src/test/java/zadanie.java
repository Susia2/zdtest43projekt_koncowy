import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class zadanie {


    WebDriver driver;

    @Before //warunki poczatkowe testow
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver\\chromedriver.exe");
        //ustawiamy property ze wskazaniem na chromedriver, ktorego uzyjemy w testach
        driver = new ChromeDriver(); //otworzy nam przegladarke
        System.out.println("wykonuje sie tutaj! przed metoda testowa");
    }


    @Test
    public void firstTest() {
        driver.get("https://dev.to"); //przejdz na strone dev
        WebElement weekBtn = driver.findElement(By.cssSelector("#articles-list > header > nav > a:nth-child(2)")); //znajdz element week
        weekBtn.click();
    }
}
