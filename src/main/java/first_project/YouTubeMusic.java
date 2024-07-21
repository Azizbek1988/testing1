package first_project;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class YouTubeMusic {

    public static void main(String[] args) throws Exception {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.google.com");
        WebElement search = driver.findElement(By.xpath("//*[@title='Search']"));
        search.sendKeys("youtube"+ Keys.ENTER);

        driver.findElement(By.cssSelector("*[class='LC20lb MBeuO DKV0Md']")).click();
        WebElement searchMusic = driver.findElement(By.xpath("//*[@name='search_query']"));
        searchMusic.click();
        searchMusic.sendKeys("Eminem Lose yourself"+Keys.ENTER);
        WebElement chooseMusic = driver.findElement(By.xpath("(//*[@class='yt-core-image yt-core-image--fill-parent-height yt-core-image--fill-parent-width yt-core-image--content-mode-scale-aspect-fill yt-core-image--loaded'])[1]"));
        chooseMusic.click();
        WebElement expectedTitle = driver.findElement(By.xpath("  //a[contains(@title, 'Eminem - Lose Yourself [HD]')]"));
        System.out.println(expectedTitle.getText());

        String expected = "Eminem - Lose Yourself [HD]";
        String actual = expectedTitle.getText();

        if(expected.equals(actual)) {
            System.out.println("==========TEXT MATCHED===========");
        }else {
            System.out.println("==========TEXT DID NOT MATCH==========");
        }
        Thread.sleep(6000);
        driver.quit();

    }
}
