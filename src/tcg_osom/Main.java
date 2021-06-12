/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tcg_osom;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.UnsupportedLookAndFeelException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

/**
 *
 * @author KuroNeko
 */
public class Main {
    public static void main(String[] args) throws UnsupportedLookAndFeelException {
        File data = new File(System.getProperty("user.dir") + "/session.xml");
        if (data.exists()) {
            
            try {
                DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
                DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
                Document doc = (Document) dBuilder.parse(data);
                String id = doc.getElementsByTagName("account_id").item(0).getTextContent();
                String username = doc.getElementsByTagName("username").item(0).getTextContent();
                String password = doc.getElementsByTagName("password").item(0).getTextContent();
                String nickname = doc.getElementsByTagName("nickname").item(0).getTextContent();
                String email = doc.getElementsByTagName("email").item(0).getTextContent();
                
                tcg_osom.Database.setUserId(id);
                tcg_osom.Database.setUsername(username);
                tcg_osom.Database.setPassword(password);
                tcg_osom.Database.setNickname(nickname);
                tcg_osom.Database.setEmail(email);
                
                for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                    if ("GTK+".equals(info.getName())) {
                        try {
                            javax.swing.UIManager.setLookAndFeel(info.getClassName());
                            break;
                        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
                Menu menu = new Menu();
                menu.setVisible(true);
            } catch (IOException | ParserConfigurationException | SAXException e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }else {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("GTK+".equals(info.getName())) {
                    try {
                        javax.swing.UIManager.setLookAndFeel(info.getClassName());
                        break;
                    } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                        Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
            Login login = new Login();
            login.setVisible(true);
        }                      
    }

    void setVisible(boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
