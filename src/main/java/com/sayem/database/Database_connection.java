package com.sayem.database;
// import sql package
import java.sql.*;

//http://docsrv.sco.com/JDK_guide/jdbc/getstart/callablestatement.doc.html
public class Database_connection {


    public static void main(String[] args) throws SQLException {

        Connection conn = null;
        String url = "jdbc:mysql://localhost:3306/";
        String dbName = "test";
        String driver = "com.mysql.jdbc.Driver";
        String userName = "root";
        String password = "root";

        try{
            Class.forName(driver).newInstance();// create object of Driver
            conn = DriverManager.getConnection(url+dbName,userName,password);
            // connection will be established

            // *******************Statement******************
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from users");

            //  rs.next(); // 1st row
            //  System.out.println(rs.getString(2));
            //  rs.next(); // 2nd row
            //  System.out.println(rs.getString(1));
            while(rs.next()){
                System.out.println(rs.getString(1) + "-- "+rs.getString(2)+" -- "+rs.getString(3));
            }

            System.out.println("*********************************");
            // *****************PREPARED STATEMENT**************
            PreparedStatement pstmt = conn.prepareStatement("select * from users where name = ? and sex=?");
            pstmt.setString(1, "B");
            pstmt.setString(2, "F");
            ResultSet rs1 = pstmt.executeQuery();

            while(rs1.next()){
                System.out.println(rs1.getString(1) + "-- "+rs1.getString(2)+" -- "+rs1.getString(3));
            }


            //***************Callable Statement************************
            //CallableStatement cstmt = conn.prepareCall("{call getTestData(?,?,?,?)}");
            //cstmt.registerOutParameter(1, java.sql.Types.DECIMAL, 3);
            //cstmt.setString(2, "xxxxx");


            //cstmt.executeUpdate();
            // double d =cstmt.getDouble(1);

//
            //********************Add row Insert************************
            pstmt = conn.prepareStatement("insert into users values (?,?,?)");
            pstmt.setString(1, "Tom");
            pstmt.setString(2, "London");
            pstmt.setString(3, "M");

            int i=pstmt.executeUpdate();
            if(i==1){
                System.out.println("inserted the record");
            }


        }catch(Exception e){
            e.printStackTrace();
        }finally{
            conn.close();
        }
    }

}
