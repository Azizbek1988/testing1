package first_project;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.concurrent.TimeUnit;

public class dell {
    public static void main(String[] args) throws Exception {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://www.google.com");
        driver.findElement(By.xpath("//*[@title='Search']")).sendKeys("Dell" + Keys.ENTER);
        driver.findElement(By.xpath("(//*[@class='l'])[4]")).click();
        driver.navigate().to("https://www.dell.com/en-us/shop/dell-computer-laptops/scr/laptops");

        WebElement modelName1 = driver.findElement(By.xpath("//*[*='XPS 13 Laptop']"));
        String firstLapTop = modelName1.getText();
        System.out.print("First Laptop: " + firstLapTop);

        WebElement modelPrice1 = driver.findElement(By.xpath("(//*[*='$1,299.99'])[1]"));
        String firstPrice = modelPrice1.getText();
        firstPrice = modelPrice1.getText().substring(13).replace(',', '.');
        try {
            double price1 = DecimalFormat.getNumberInstance().parse(firstPrice).doubleValue();
            System.out.println("Laptop's Price: $" + price1);
            double ourMoney = 1.400;
            if (price1 <= ourMoney) {
                double result1 = (float) (ourMoney - price1);
                String convertingDoubleToString = Double.toString(result1);
                String finalResult = convertingDoubleToString.substring(2, 5);
                System.out.println("You have left $ " + finalResult + " money!");
            } else {
                System.out.println("You do not have enough money for Laptop!!!");
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        driver.quit();
    }
}