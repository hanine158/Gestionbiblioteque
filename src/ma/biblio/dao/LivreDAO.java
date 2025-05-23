/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ma.biblio.dao;

/**
 *
 * @author Hanine
 */



import java.sql.*;
import java.util.*;
import ma.biblio.Livre;
import ma.biblio.connexion.Connexion;

public class LivreDAO {

    public static void ajouterLivre(Livre l) {
        try {
            Connection con = Connexion.getConnection();
            String sql = "INSERT INTO livre(titre, auteur, isbn, annee, nb_exemplaires) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, l.getTitre());
            ps.setString(2, l.getAuteur());
            ps.setString(3, l.getIsbn());
            ps.setInt(4, l.getAnnee());
            ps.setInt(5, l.getNbExemplaires());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static List<Livre> getAllLivres() {
        List<Livre> liste = new ArrayList<>();
        try {
            Connection con = Connexion.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM livre");
            while (rs.next()) {
                Livre l = new Livre(
                    rs.getInt("id"), rs.getString("titre"), rs.getString("auteur"),
                    rs.getString("isbn"), rs.getInt("annee"), rs.getInt("nb_exemplaires")
                );
                liste.add(l);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return liste;
    }
}



    

