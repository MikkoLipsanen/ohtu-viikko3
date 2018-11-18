package ohtu;

import java.util.Random;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class Tester {

    public static void main(String[] args) {
        WebDriver driver = new HtmlUnitDriver();
        Random r = new Random();

        driver.get("http://localhost:4567");
        
        System.out.println(driver.getPageSource()); 
        
        sleep(2);
        
        WebElement element = driver.findElement(By.linkText("login"));
        element.click();
        
        System.out.println(driver.getPageSource());

        sleep(2);

        element = driver.findElement(By.name("username"));
        element.sendKeys("pekka");
        element = driver.findElement(By.name("password"));
        element.sendKeys("akkel");
        element = driver.findElement(By.name("login"));
        
        
        sleep(2);
        element.submit();
        
        System.out.println(driver.getPageSource());
        
        sleep(3);
        
        element = driver.findElement(By.name("username"));
        element.sendKeys("kalle");
        element = driver.findElement(By.name("password"));
        element.sendKeys("akkep");
        element = driver.findElement(By.name("login"));
        
        sleep(4);
        element.submit();
        
        element = driver.findElement(By.linkText("back to home"));
        element.click();
        
        System.out.println(driver.getPageSource());
        
        sleep(5);
        
        element = driver.findElement(By.linkText("register new user"));
        element.click();
        
        System.out.println(driver.getPageSource());
        
        sleep(6);
        
        element = driver.findElement(By.name("username"));
        element.sendKeys("arto"+r.nextInt(100000));
        element = driver.findElement(By.name("password"));
        element.sendKeys("akkep");
        element = driver.findElement(By.name("passwordConfirmation"));
        element.sendKeys("akkep");
        
        element = driver.findElement(By.name("signup"));
        
        sleep(7);
        element.submit();
        
        System.out.println(driver.getPageSource());
        
        element = driver.findElement(By.linkText("continue to application mainpage"));
        
        sleep(8);
        
        element.click();
        
        System.out.println(driver.getPageSource());
        
        element = driver.findElement(By.linkText("logout"));
        
        sleep(8);
        
        element.click();
        
        System.out.println(driver.getPageSource());
        
        driver.quit();
    }
    
    private static void sleep(int n){
        try{
            Thread.sleep(n*1000);
        } catch(Exception e){}
    }
}
