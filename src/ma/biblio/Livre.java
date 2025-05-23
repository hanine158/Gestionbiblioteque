/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ma.biblio;

/**
 *
 * @author Hanine
 */
  
public class Livre {
    private int id;
    private String titre;
    private String auteur;
    private String isbn;
    private int annee;
    private int nbExemplaires;

    public Livre(int id, String titre, String auteur, String isbn, int annee, int nbExemplaires) {
        this.id = id;
        this.titre = titre;
        this.auteur = auteur;
        this.isbn = isbn;
        this.annee = annee;
        this.nbExemplaires = nbExemplaires;
    }

    public Livre(String titre, String auteur, String isbn, int annee, int nbExemplaires) {
        this.titre = titre;
        this.auteur = auteur;
        this.isbn = isbn;
        this.annee = annee;
        this.nbExemplaires = nbExemplaires;
    }

    public Livre() {
        // constructeur par défaut vide si besoin
    }

    public int getId() { return id; }
    public String getTitre() { return titre; }
    public String getAuteur() { return auteur; }
    public String getIsbn() { return isbn; }
    public int getAnnee() { return annee; }
    public int getNbExemplaires() { return nbExemplaires; }

    public void setId(int id) { this.id = id; }
    public void setTitre(String titre) { this.titre = titre; }
    public void setAuteur(String auteur) { this.auteur = auteur; }
    public void setIsbn(String isbn) { this.isbn = isbn; }
    public void setAnnee(int annee) { this.annee = annee; }
    public void setNbExemplaires(int nbExemplaires) { this.nbExemplaires = nbExemplaires; }

    // Corrigé ici :
    public int getExemplaires() {
        return nbExemplaires;
    }

    public void setExemplaires(int nbExemplaires) {
        this.nbExemplaires = nbExemplaires;
    }
}




    

