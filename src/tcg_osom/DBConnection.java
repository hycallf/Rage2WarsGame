/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tcg_osom;

import java.sql.*;

/**
 *
 * @author KuroNeko
 */
public interface DBConnection {
    
    String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    String DB_URL = "jdbc:mysql://localhost/tcg_osom";
    String USER = "root";
    String PASS = "";
    
    
}
