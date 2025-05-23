/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ma.biblio;

/**
 *
 * @author Hanine
 */


public class Utilisateur {
    private int id;
    private String nom;
    private String prenom;
    private String numAdherent;

    public Utilisateur(int id, String nom, String prenom, String numAdherent) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.numAdherent = numAdherent;
    }

    public Utilisateur(String nom, String prenom, String numAdherent) {
        this(0, nom, prenom, numAdherent);
    }

    // Getters et Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public String getPrenom() { return prenom; }
    public void setPrenom(String prenom) { this.prenom = prenom; }

    public String getNumAdherent() { return numAdherent; }
    public void setNumAdherent(String numAdherent) { this.numAdherent = numAdherent; }
}

    

