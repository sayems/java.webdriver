package com.sayem.database;

import com.thoughtworks.selenium.DefaultSelenium;
import com.thoughtworks.selenium.Selenium;
import junit.framework.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.*;


public class LoginTest {
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

        // get the title
        String actual_title=selenium.getTitle();

        // valueFound - True , title->Lead Listing --- Passed
        // valueFound - True, tile-> Login Page -- Failed

        // valueFound - False , title->Lead Listing --- Failed
        // valueFound - False, tile-> Login Page -- Passed
        System.out.println(valueFound);
        if(valueFound){
            Assert.assertEquals("Lead Listing", actual_title);
        }else{
            Assert.assertEquals("Login Page", actual_title);
        }

    }

    @After
    public void closeConn() throws SQLException{
        if(conn!=null && !conn.isClosed()){
            conn.close();
        }
    }



}
