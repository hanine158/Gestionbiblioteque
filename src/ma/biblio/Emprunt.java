/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ma.biblio;
import java.sql.Date;
/**
 *
 * @author Hanine
 */
public class Emprunt {
     private int id;
    private int idLivre;
    private int idUtilisateur;
    private Date dateEmprunt;
    private Date dateRetour;

    public Emprunt(int id, int idLivre, int idUtilisateur, Date dateEmprunt, Date dateRetour) {
        this.id = id;
        this.idLivre = idLivre;
        this.idUtilisateur = idUtilisateur;
        this.dateEmprunt = dateEmprunt;
        this.dateRetour = dateRetour;
    }

    public Emprunt(int idLivre, int idUtilisateur, Date dateEmprunt) {
        this(0, idLivre, idUtilisateur, dateEmprunt, null);
    }

    // Getters et Setters (à générer)
    public int getId() { return id; }
    public int getIdLivre() { return idLivre; }
    public int getIdUtilisateur() { return idUtilisateur; }
    public Date getDateEmprunt() { return dateEmprunt; }
    public Date getDateRetour() { return dateRetour; }

    public void setId(int id) { this.id = id; }
    public void setIdLivre(int idLivre) { this.idLivre = idLivre; }
    public void setIdUtilisateur(int idUtilisateur) { this.idUtilisateur = idUtilisateur; }
    public void setDateEmprunt(Date dateEmprunt) { this.dateEmprunt = dateEmprunt; }
    public void setDateRetour(Date dateRetour) { this.dateRetour = dateRetour; }
}

    

