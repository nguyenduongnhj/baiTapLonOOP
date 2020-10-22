/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Connection;
import java.sql.DriverManager;
 


public class DBConnector {
    public static Connection getConnect() throws Exception{
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String connStr = "jdbc:sqlserver://localhost:1433;databaseName=QLSV;user=phamhieu;password=123456;";
        Connection conn = DriverManager.getConnection(connStr);
        return conn;
    }
}
