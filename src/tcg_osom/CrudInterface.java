/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tcg_osom;

import java.sql.*;
import java.util.*;
/**
 *
 * @author KuroNeko
 */
public interface CrudInterface {
    void add(Account acc)
            throws SQLException;
    void update(Account acc)
            throws SQLException;
    
}
