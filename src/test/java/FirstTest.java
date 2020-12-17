import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertTrue;

public class FirstTest {

    WebDriver driver;
    WebDriverWait wait;

    public void highlightElement(WebElement element){
        JavascriptExecutor js=(JavascriptExecutor)driver;
        js. executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);
    }

    @Before //warunki poczatkowe testow
    public void setup(){
        System.setProperty("webdriver.chrome.driver","C:\\chromedriver\\chromedriver.exe");
        //ustawiamy property ze wskazaniem na chromedriver, ktorego uzyjemy w testach
        driver = new ChromeDriver(); //otworzy nam przegladarke
        System.out.println("wykonuje sie tutaj! przed metoda testowa");
        wait = new WebDriverWait(driver, 10);
    }
    @Test
    public void firstTest(){
        driver.get("https://dev.to"); //przejdz na strone dev
        WebElement sideBarVideo = driver.findElement(By.xpath("/html/body/div[9]/div/div/div[1]/aside/nav[1]/div/a[3]")); //znajdz element week
        highlightElement(sideBarVideo);

    }
    @Test
    public void openFirstVideoPage(){
        driver.get("https://dev.to");
        WebElement sideBarVideo = driver.findElement(By.partialLinkText("Videos"));
        highlightElement(sideBarVideo);
        sideBarVideo.click();


        wait.until(ExpectedConditions.urlToBe("https://dev.to/videos"));

        WebElement firstVideo = driver.findElement(By.className("video-image"));
        highlightElement(firstVideo);
        firstVideo.click();

                WebElement recordWrapper = driver.findElement(By.className("jw-icon"));
       String classAtribute = recordWrapper.getAttribute("class");
       Boolean isPodcastsPlayed = classAtribute.contains("play");
        assertTrue(isPodcastsPlayed);
    }
    @Test
    public void highlightFirstVideo(){
            driver.get("https://dev.to/videos");
            WebElement firstVideo = driver.findElement(By.className("video-image"));
            highlightElement(firstVideo);
    }

    // wejdz na strone dev.to
    //kliknac w podcast
    //wybrac pierwszy podcast - pobiore nazwe pierwszego podcastu z listy
    //sprwadzic czy jestem na odpowiedniej stronie - czy tytul podcastu sie zgadza
    //sprawdzic czy moge nacisnac play

    @Test
    public void selectFirstPodcast(){
        driver.get("https://dev.to");
        WebElement podcasts = driver.findElement(By.partialLinkText("Podcasts"));
        podcasts.click();

        wait.until(ExpectedConditions.urlToBe("https://dev.to/pod"));

        WebElement firstPodcast = driver.findElement(By.cssSelector(".content > h3:first-child"));
        String podcastsTitleFromList = firstPodcast.getText();

        String firstPodcastsFromListLink = driver.findElement(By.cssSelector("#substories > a:first-child")).getAttribute("href");
        firstPodcast.click();
        wait.until(ExpectedConditions.urlToBe(firstPodcastsFromListLink));
        WebElement podcastsTitle = driver.findElement(By.cssSelector(".title > h1:nth-child(2)"));

        String podcastsTitleText = podcastsTitle.getText();
        assertTrue(podcastsTitleFromList.contains(podcastsTitleText));

        WebElement podcastsPlay = driver.findElement(By.id("record"));
        podcastsPlay.click();

        WebElement record = driver.findElement(By.className("record"));

        WebElement initializing = driver.findElement(By.className("status-message"));
        wait.until(ExpectedConditions.invisibilityOf(initializing));

        WebElement recordWrapper = driver.findElement(By.className("record-wrapper"));
        String classAtribute = recordWrapper.getAttribute("class");


        Boolean isPodcastsPlayed = classAtribute.contains("playing");
        assertTrue(isPodcastsPlayed);



    }

    @Test
    public void writeTextInSearchbar(){

        driver.get("https://dev.to");
       // WebElement searchBox = driver.findElement(By.id("search-input")).sendKeys("testing");
        //highlightElement(searchBox);
    }

    }
//    @After //czynnosci zamykajace testy
//    public void tearDown(){
//        driver.quit();
//        System.out.println("po kazdej metodzie testowej");
//    }
//
    

