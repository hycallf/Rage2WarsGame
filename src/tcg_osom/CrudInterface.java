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
    void levelUp(int level, String account_id) throws SQLException;
    void setGold(int gold, String account_id) throws SQLException;
    void setExp(int exp, String account_id) throws SQLException;
    void setGems(int gems, String account_id) throws SQLException;
}
