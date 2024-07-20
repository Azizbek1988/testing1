package first_project;

import org.openqa.selenium.*;

import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;


public class lambor {
    public static void main(String[] args) throws Exception {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.google.com/");
        WebElement searchbox = driver.findElement(By.xpath("//*[@title='Search']"));
        searchbox.sendKeys("Lamborghini" + Keys.ENTER);
        driver.findElement(By.xpath("//*[@class='LC20lb MBeuO DKV0Md']")).click();
        Thread.sleep(4000);
        driver.findElement(By.xpath("//*[@id='onetrust-accept-btn-handler']")).click();

        JavascriptExecutor js = (JavascriptExecutor) driver;

        Thread.sleep(6000);
        JavascriptExecutor ja = (JavascriptExecutor) driver;
        for (int i = 0; i <= 4700; i += 3) {
            ja.executeScript("window.scrollTo(0," + i + ")");
        }
        Thread.sleep(5000);
        String titleName = driver.getTitle();
        if (titleName.equals("Automobili Lamborghini - Official Website | Lamborghini.com")) {
            System.out.println("==========TEST PASSED==========");
        }else {
            System.out.println("==========TEST FAILED==========");
        }
        Thread.sleep(4000);
        driver.quit();
    }
}
