package com.student.manage.Factory;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
    private static Connection con;
    static{
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "system");
        }
        catch(Exception e){

        }
    }
    public  static Connection getConnection(){
        return con;
    }
    public static void close(){
        try{
            con.close();
        }
        catch(Exception e){
        }
    }
}
