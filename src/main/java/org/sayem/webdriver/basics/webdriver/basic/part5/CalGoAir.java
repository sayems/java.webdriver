package org.sayem.webdriver.basics.webdriver.basic.part5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class CalGoAir {
    static WebDriver driver;

    public static void main(String[] args) throws ParseException {
        String d = "05/10/2013"; // xls dd/mm/yyyy
        String months[] = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};

        // extract month and date

        SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy");
        Date myDate = df.parse(d);
        Calendar cal = Calendar.getInstance();
        cal.setTime(myDate);

        int day = cal.get(Calendar.DAY_OF_MONTH);
        int month = cal.get(Calendar.MONTH);
        int year = cal.get(Calendar.YEAR);
        System.out.println(day);
        System.out.println(month);
        System.out.println(months[month]);
        System.out.println(year);


        String travelMonth = months[month] + ", " + year;

        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://goair.in/");
        driver.findElement(By.xpath("//*[@id='cal_trigger_outbound']")).click();

        selectMonth(travelMonth);
        selectDay(day);

    }

    // select the month from calendar
    public static void selectMonth(String monthtobeSelected) {
        String forwardArrow = "//div[@class='calendar']/table/thead/tr[2]/td[4]/div";
        String xpathMonthYearSection = "//div[@class='calendar']/table/thead/tr[1]/td[2]";

        while (!driver.findElement(By.xpath(xpathMonthYearSection)).getText().equals(monthtobeSelected)) {
            driver.findElement(By.xpath(forwardArrow)).click();
        }
    }

    // select day from the calendar - after month is selected
    public static void selectDay(int dayToBeSelected) {
        //    //div[@class='calendar']/table/tbody/tr[2]/td[8]
        String part1 = "//div[@class='calendar']/table/tbody/tr[";
        String part2 = "]/td[";
        String part3 = "]";


        for (int rNum = 1; rNum <= 6; rNum++) {
            for (int cNum = 2; cNum <= 8; cNum++) {
                String date = driver.findElement(By.xpath(part1 + rNum + part2 + cNum + part3)).getText();
                System.out.print(date + " ");
                if (!date.equals("")) {
                    int currentDay = Integer.parseInt(date);
                    if (currentDay == dayToBeSelected) {
                        driver.findElement(By.xpath(part1 + rNum + part2 + cNum + part3)).click();
                        return;
                    }
                }
            }
            System.out.println();// new line
        }
    }
}