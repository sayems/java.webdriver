package org.sayem.webdriver.deprecated.cookies;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class StoreCookieInfo {

    public static void main(String... args) {
        WebDriver driver = new FirefoxDriver();
        driver.get("http://www.facebook.com");
        driver.findElement(By.name("email")).sendKeys("<<ur mailID>>");
        driver.findElement(By.name("pass")).sendKeys("<<ur password>>");
        driver.findElement(By.name("persistent")).click();
        driver.findElement(By.name("pass")).submit();

        File f = new File("browser.data");
        try {
            f.delete();
            f.createNewFile();
            FileWriter fos = new FileWriter(f);
            BufferedWriter bos = new BufferedWriter(fos);

            for (Cookie ck : driver.manage().getCookies()) {
                bos.write((ck.getName() + ";" + ck.getValue() + ";" + ck.getDomain()
                        + ";" + ck.getPath() + ";" + ck.getExpiry() + ";" + ck.isSecure()));
                bos.newLine();
            }
            bos.flush();
            bos.close();
            fos.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
}