package tcg_osom;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
 
public class Database{
    private static Connection conn = null;
    private static String account_id;
    private static String username;
    private static String password;
    private static String email;
    private static String nickname;
    private int gold, exp, lvl, gems;

//    public Account(String username, String password, String email, String nickname) {
//        this.username = username;
//        this.password = password;
//        this.email = email;
//        this.nickname = nickname;
//    }

    public static String getUserId() {
        return account_id;
    }

    public static void setUserId(String userId) {
        Database.account_id = userId;
    }

    public static String getUsername() {
        return username;
    }

    public static void setUsername(String username) {
        Database.username = username;
    }

    public static String getPassword() {
        return password;
    }

    public static void setPassword(String password) {
        Database.password = password;
    }

    public static String getEmail() {
        return email;
    }

    public static void setEmail(String email) {
        Database.email = email;
    }

    public static String getNickname() {
        return nickname;
    }

    public static void setNickname(String nickname) {
        Database.nickname = nickname;
    }
    
     public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public int getLvl() {
        return lvl;
    }

    public void setLvl(int lvl) {
        this.lvl = lvl;
    }

    public int getGems() {
        return gems;
    }

    public void setGems(int gems) {
        this.gems = gems;
    }
    
    public static Connection config(){
        String url = "jdbc:mysql:// localhost:3306/tcg_osom";
        String user = "root";
        String pass = "";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn=DriverManager.getConnection(url, user, pass);
        } 
        catch (ClassNotFoundException  | SQLException e) {
            JOptionPane.showMessageDialog(null, "koneksi gagal "+e.getMessage());
        }
        
        return conn;
    }
    
    public static void createXML(String account_id,String username,String password,String nickname, String email){
        try {
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();


            Document doc = docBuilder.newDocument();
            Element rootElement = doc.createElement("session");
            doc.appendChild(rootElement);
            
            
            Element id_login = doc.createElement("account_id");
            rootElement.appendChild(id_login);
            id_login.setTextContent(account_id);
            
            Element user = doc.createElement("username");
            rootElement.appendChild(user);
            user.setTextContent(username);
            
            Element pass = doc.createElement("password");
            rootElement.appendChild(pass);
            pass.setTextContent(password);
            
            Element nick = doc.createElement("nickname");
            rootElement.appendChild(nick);
            nick.setTextContent(nickname);
            
            Element mail = doc.createElement("email");
            rootElement.appendChild(mail);
            mail.setTextContent(email);
            
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File(System.getProperty("user.dir") + "/session.xml"));
            transformer.transform(source, result);

   } catch (ParserConfigurationException | TransformerException e) {
  System.out.println(e);
   }
    }
}