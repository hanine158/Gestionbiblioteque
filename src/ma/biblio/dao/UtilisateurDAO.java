/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ma.biblio.dao;

/**
 *
 * @author Hanine
 */


import ma.biblio.Utilisateur;
import ma.biblio.connexion.Connexion;
import java.sql.*;
import java.util.*;

public class UtilisateurDAO {

    public static void ajouterUtilisateur(Utilisateur u) {
        try {
            Connection con = Connexion.getConnection();
            String sql = "INSERT INTO utilisateur(nom, prenom, num_adherent) VALUES (?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, u.getNom());
            ps.setString(2, u.getPrenom());
            ps.setString(3, u.getNumAdherent());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static List<Utilisateur> getAllUtilisateurs() {
        List<Utilisateur> liste = new ArrayList<>();
        try {
            Connection con = Connexion.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM utilisateur");

            while (rs.next()) {
                Utilisateur u = new Utilisateur(
                    rs.getInt("id"),
                    rs.getString("nom"),
                    rs.getString("prenom"),
                    rs.getString("num_adherent")
                );
                liste.add(u);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return liste;
    }
}

    
