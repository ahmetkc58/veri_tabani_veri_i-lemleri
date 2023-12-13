/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mysql1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Lenovo
 */
public class DpHelper {

    static String userName = "root";
    static String password = "Sivasli.58";
    static String dbUrl = "jdbc:mysql://localhost:3306/deneme";

    public Connection getConnection() throws SQLException {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // JDBC sürücüsünü yükle

        } catch (Exception e) {
            System.out.println("hata DpHelper " + e);
        }
        return DriverManager.getConnection(dbUrl, userName, password);

    }

    public void showErrorMessage(SQLException exception) {
        System.out.println("Error   :" + exception.getMessage());
        System.out.println("Error Code  :" + exception.getErrorCode());

    }

}
