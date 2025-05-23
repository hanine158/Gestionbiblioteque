/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ma.biblio.ihm;

/**
 *
 * @author Hanine
 */






import ma.biblio.Livre;
import ma.biblio.dao.LivreDAO;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class livrepanel extends JPanel {
    private JTextField txtTitre, txtAuteur, txtIsbn, txtAnnee, txtExemplaires;
    private JTable tableLivres;
    private LivreDAO livreDAO;

    public livrepanel() {
        livreDAO = new LivreDAO();
        initUI();
        chargerLivres(); // Charger les livres au démarrage
    }

    private void initUI() {
        setLayout(new BorderLayout());

        // ---- Formulaire d'ajout ----
        JPanel formPanel = new JPanel(new GridLayout(6, 2, 5, 5));

        formPanel.add(new JLabel("Titre :"));
        txtTitre = new JTextField();
        formPanel.add(txtTitre);

        formPanel.add(new JLabel("Auteur :"));
        txtAuteur = new JTextField();
        formPanel.add(txtAuteur);

        formPanel.add(new JLabel("ISBN :"));
        txtIsbn = new JTextField();
        formPanel.add(txtIsbn);

        formPanel.add(new JLabel("Année :"));
        txtAnnee = new JTextField();
        formPanel.add(txtAnnee);

        formPanel.add(new JLabel("Exemplaires :"));
        txtExemplaires = new JTextField();
        formPanel.add(txtExemplaires);

        JButton btnAjouter = new JButton("Ajouter Livre");
        formPanel.add(btnAjouter);

        JButton btnActualiser = new JButton("Actualiser");
        formPanel.add(btnActualiser);

        add(formPanel, BorderLayout.NORTH);

        // ---- Table des livres ----
        tableLivres = new JTable();
        tableLivres.setModel(new DefaultTableModel(
            new Object[]{"ID", "Titre", "Auteur", "ISBN", "Année", "Exemplaires"}, 0
        ));
        add(new JScrollPane(tableLivres), BorderLayout.CENTER);

        // ---- Action sur bouton Ajouter ----
        btnAjouter.addActionListener(e -> {
            try {
                String titre = txtTitre.getText();
                String auteur = txtAuteur.getText();
                String isbn = txtIsbn.getText();
                int annee = Integer.parseInt(txtAnnee.getText());
                int exemplaires = Integer.parseInt(txtExemplaires.getText());

                Livre livre = new Livre(0, titre, auteur, isbn, annee, exemplaires);
                livreDAO.ajouterLivre(livre);
                JOptionPane.showMessageDialog(this, "Livre ajouté !");
                chargerLivres(); // recharge la table
            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "Erreur : " + ex.getMessage());
            }
        });

        // ---- Action sur bouton Actualiser ----
        btnActualiser.addActionListener(e -> chargerLivres());
    }

    public void chargerLivres() {
        try {
            List<Livre> livres = livreDAO.getAllLivres();
            DefaultTableModel model = (DefaultTableModel) tableLivres.getModel();
            model.setRowCount(0); // vider la table
            for (Livre l : livres) {
                model.addRow(new Object[]{
                    l.getId(), l.getTitre(), l.getAuteur(), l.getIsbn(),
                    l.getAnnee(), l.getExemplaires()
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Erreur de chargement : " + e.getMessage());
        }
    }
}
