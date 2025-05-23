/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ma.biblio.connexion;

/**
 *
 * @author Hanine
 */








import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connexion {

   private static final String URL  =
    "jdbc:mysql://localhost:3306/bibliotheque?serverTimezone=UTC&useSSL=false";
private static final String USER = "biblio_user";
private static final String PASS = "monSecret123";


    private Connexion() { }   // Empêche l’instanciation

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASS);
    }
}





    

