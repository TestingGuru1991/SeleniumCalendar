import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test {
    public static void main(String[] args) {
        System.setProperty("webdriver.driver.chrome", "C:\\Program Files\\Web Drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //go to web site
        driver.get("https://www.path2usa.com/travel-companions");

        driver.findElement(By.id("travel_date")).click();

        while(!driver.findElement(By.cssSelector("[class='datepicker-days'] [class='datepicker-switch']")).getText().contains("August 2020")) {
            driver.findElement(By.cssSelector("[class='datepicker-days'] th[class='next']")).click();
        }

        int count = driver.findElements(By.className("day")).size();

        for(int i=0; i<count; i++) {
            String text = driver.findElements(By.className("day")).get(i).getText();
            if(text.equals("23")) {
                driver.findElements(By.className("day")).get(i).click();
                break;
            }
        }
        driver.close();
    }
}
