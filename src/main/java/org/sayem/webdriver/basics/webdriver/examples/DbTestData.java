package org.sayem.webdriver.basics.webdriver.examples;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

@RunWith(value = Parameterized.class)
public class DbTestData {

    private static WebDriver driver;
    private static StringBuffer verificationErrors = new StringBuffer();

    private String height;
    private String weight;
    private String bmi;
    private String bmiCategory;

    public DbTestData(String height, String weight, String bmi, String bmiCategory) {
        this.height = height;
        this.weight = weight;
        this.bmi = bmi;
        this.bmiCategory = bmiCategory;
    }

    @Parameters
    public static Collection testData() throws Exception {
        return getTestData("C:\\BmiTesting.mdb", "SELECT Height, Weight, Bmi, Category FROM TestData");
    }

    public static Collection<String[]> getTestData(String mdbFile, String sqlQuery) throws Exception {
        ArrayList<String[]> records = new ArrayList<String[]>();

        Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
        String myDB = "jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ=" + mdbFile;
        Connection conn = DriverManager.getConnection(myDB, "", "");

        Statement stmt = null;
        ResultSet rs = null;

        stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_UPDATABLE);

        rs = stmt.executeQuery(sqlQuery);
        ResultSetMetaData rsMetaData = rs.getMetaData();

        int cols = rsMetaData.getColumnCount();

        while (rs.next()) {

            String fields[] = new String[cols];
            int col = 0;
            for (int colIdx = 1; colIdx <= cols; colIdx++) {
                fields[col] = rs.getString(colIdx);
                col++;
            }
            records.add(fields);
        }

        rs.close();
        stmt.close();
        conn.close();

        return records;
    }

    @BeforeClass
    public static void setUp() throws Exception {
        // Create a new instance of the Firefox driver
        driver = new FirefoxDriver();
        driver.get("http://dl.dropbox.com/u/55228056/bmicalculator.html");
    }

    @AfterClass
    public static void tearDown() throws Exception {
        //Close the browser
        driver.quit();

        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {

            fail(verificationErrorString);
        }
    }

    @Test
    public void testBMICalculator() {
        try {
            WebElement heightField = driver.findElement(By.name("heightCMS"));
            heightField.clear();
            heightField.sendKeys(this.height);

            WebElement weightField = driver.findElement(By.name("weightKg"));
            weightField.clear();
            weightField.sendKeys(this.weight);

            WebElement calculateButton = driver.findElement(By.id("Calculate"));
            calculateButton.click();

            WebElement bmiLabel = driver.findElement(By.name("bmi"));
            assertEquals(this.bmi, bmiLabel.getAttribute("value"));

            WebElement bmiCategoryLabel = driver.findElement(By.name("bmi_category"));
            assertEquals(this.bmiCategory, bmiCategoryLabel.getAttribute("value"));

        } catch (Error e) {
            //Capture and append Exceptions/Errors
            verificationErrors.append(e.toString());
        }
    }
}