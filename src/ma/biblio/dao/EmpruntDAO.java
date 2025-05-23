/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ma.biblio.dao;

/**
 *
 * @author Hanine
 */


import ma.biblio.Emprunt;
import ma.biblio.connexion.Connexion;
import java.sql.*;
import java.util.*;

public class EmpruntDAO {

    public static void enregistrerEmprunt(Emprunt e) {
        try {
            Connection con = Connexion.getConnection();
            String sql = "INSERT INTO emprunt(id_livre, id_utilisateur, date_emprunt) VALUES (?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, e.getIdLivre());
            ps.setInt(2, e.getIdUtilisateur());
            ps.setDate(3, e.getDateEmprunt());
            ps.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static List<Emprunt> getEmpruntsEnCours() {
        List<Emprunt> liste = new ArrayList<>();
        try {
            Connection con = Connexion.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM emprunt WHERE date_retour IS NULL");

            while (rs.next()) {
                Emprunt e = new Emprunt(
                    rs.getInt("id"),
                    rs.getInt("id_livre"),
                    rs.getInt("id_utilisateur"),
                    rs.getDate("date_emprunt"),
                    rs.getDate("date_retour")
                );
                liste.add(e);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return liste;
    }

    public static void marquerRetour(int id) {
        try {
            Connection con = Connexion.getConnection();
            PreparedStatement ps = con.prepareStatement("UPDATE emprunt SET date_retour = CURDATE() WHERE id = ?");
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

    

