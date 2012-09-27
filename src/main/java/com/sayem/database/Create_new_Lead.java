package com.sayem.database;

import com.thoughtworks.selenium.DefaultSelenium;
import com.thoughtworks.selenium.Selenium;
import junit.framework.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.*;


public class Create_new_Lead {
    Selenium selenium=null;
    Connection conn=null;
    PreparedStatement pstmt=null;
    ResultSet rs=null;
    String url = "jdbc:mysql://localhost:3306/";
    String dbName = "lead";
    String driver = "com.mysql.jdbc.Driver";
    String userName = "root";
    String password = "root";

    @Before
    public void establishConn(){
        selenium = new DefaultSelenium("localhost",4444,
                "*firefox","http://localhost:8080/");
        selenium.start();
        selenium.windowMaximize();
        selenium.windowFocus();
        //selenium.setSpeed("2000");
        selenium.open("/leadapp/");
        // establish connection

        try{
            Class.forName(driver).newInstance();// create object of Driver
            conn = DriverManager.getConnection(url+dbName,userName,password);
        }catch(Exception e){

        }
    }

    @Test
    public void testLogin(){

        String username="user@javachap.com";
        String password="javachap";
        boolean valueFound=false;
        // Check the db
        try{
            pstmt=conn.prepareCall("select * from user where USR_EMAIL=? and USD_PASSWORD=?");
            pstmt.setString(1,username);
            pstmt.setString(2,password);
            rs=pstmt.executeQuery();
            valueFound = rs.next();
        }catch(Exception e){
            // report some error
        }


        // login into app
        selenium.type("//*[@id='container']/form/ul/li[1]/div/input", username);
        selenium.type("//*[@id='container']/form/ul/li[2]/div/input", password);
        selenium.click("//*[@id='container']/form/ul/li[3]/input");
        selenium.waitForPageToLoad("30000");
        selenium.click("//*[@id='container']/div/div/div/a");
        selenium.waitForPageToLoad("30000");
        // fill the form and submit

        String category="Software";
        String lead_title="Selling Computers";
        String description="xyz";
        String firstName="Harry";
        String lastName="Potter";
        String email="harry@gmail.com";
        String phone="87687612";
        String price="1233";

        selenium.select("//*[@id='Field7']", "label="+category);
        selenium.type("//*[@id='Field0']", lead_title);
        selenium.type("//*[@id='Field1']",description);
        selenium.type("//*[@id='Field4']", firstName);
        selenium.type("//*[@id='Field5']", lastName);
        selenium.type("//*[@id='Field6']", email);
        selenium.type("//*[@id='Field8']", phone);
        selenium.type("//*[@id='Field9']", price);
        selenium.click("//*[@id='saveForm']");
        selenium.waitForPageToLoad("30000");



        // fire the query
        try{
            pstmt=conn.prepareStatement("select * from lead where LD_TITLE=?");
            pstmt.setString(1, lead_title);
            rs=pstmt.executeQuery();
            // check whether record is inserted
            Assert.assertTrue("No record inserted", rs.next());

            // check the records
            Assert.assertEquals(description, rs.getString("LD_DESCRIPTION"));
            Assert.assertEquals(phone, rs.getString("LD_PHONE"));

            while(rs.next()){

            }
        }catch(Exception e){
            e.printStackTrace();
        }

    }

    @After
    public void closeConn() throws SQLException{
        if(conn!=null && !conn.isClosed()){
            conn.close();
        }
    }

}
