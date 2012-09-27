package com.sayem.database;
import com.thoughtworks.selenium.DefaultSelenium;
import com.thoughtworks.selenium.Selenium;
import junit.framework.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.*;
import java.util.Arrays;
import java.util.List;


public class DropList_Test {
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
        selenium.setSpeed("2000");
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

        // check the droplist

        String actual[] = selenium.getSelectOptions("//*[@id='Field7']");
        List<String> actual_list=Arrays.asList(actual);
        //for(int i=0; i< actual.length;i++)
        //System.out.println(actual[i]);

        System.out.println("**************");
        // fire the query
        try{
            pstmt=conn.prepareStatement("select CT_NAME from category");
            rs=pstmt.executeQuery();

            while(rs.next()){
                //System.out.println(actual_list.contains(rs.getString("CT_NAME")));
                Assert.assertTrue("Value not present "+rs.getString("CT_NAME"), actual_list.contains(rs.getString("CT_NAME")));
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
