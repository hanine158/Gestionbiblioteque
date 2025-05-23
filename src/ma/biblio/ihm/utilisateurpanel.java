/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ma.biblio.ihm;

/**
 *
 * @author Hanine
 */



import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;
import ma.biblio.Utilisateur;
import ma.biblio.dao.UtilisateurDAO;

public class utilisateurpanel extends JPanel {
    private JTable table;
    private DefaultTableModel model;

    public utilisateurpanel() {
        setLayout(new BorderLayout(10, 10));
        setBackground(new Color(240, 250, 255)); // Fond général bleu très clair

        // ===== Formulaire Haut =====
        JPanel form = new JPanel(new GridBagLayout());
        form.setBackground(new Color(225, 240, 255)); // Formulaire bleu pastel
        form.setBorder(new TitledBorder("👤 Ajouter un utilisateur"));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JTextField nom = new JTextField();
        JTextField prenom = new JTextField();
        JTextField numAdh = new JTextField();
        JButton ajouter = new JButton("➕ Ajouter");

        ajouter.setBackground(new Color(70, 130, 180)); // Bleu acier
        ajouter.setForeground(Color.WHITE);
        ajouter.setFocusPainted(false);

        gbc.gridx = 0; gbc.gridy = 0; form.add(new JLabel("Nom :"), gbc);
        gbc.gridx = 1; form.add(nom, gbc);

        gbc.gridx = 0; gbc.gridy = 1; form.add(new JLabel("Prénom :"), gbc);
        gbc.gridx = 1; form.add(prenom, gbc);

        gbc.gridx = 0; gbc.gridy = 2; form.add(new JLabel("N° Adhérent :"), gbc);
        gbc.gridx = 1; form.add(numAdh, gbc);

        gbc.gridx = 1; gbc.gridy = 3; form.add(ajouter, gbc);

        add(form, BorderLayout.NORTH);

        // ===== Tableau des utilisateurs =====
        JPanel tableauPanel = new JPanel(new BorderLayout());
        tableauPanel.setBackground(Color.WHITE);
        tableauPanel.setBorder(new TitledBorder("📋 Liste des utilisateurs"));

        model = new DefaultTableModel();
        model.setColumnIdentifiers(new String[]{"ID", "Nom", "Prénom", "N° Adhérent"});

        table = new JTable(model);
        table.setRowHeight(24);
        table.getTableHeader().setFont(new Font("SansSerif", Font.BOLD, 14));
        table.getTableHeader().setBackground(new Color(200, 220, 240));

        tableauPanel.add(new JScrollPane(table), BorderLayout.CENTER);
        add(tableauPanel, BorderLayout.CENTER);

        // Action bouton
        ajouter.addActionListener(e -> {
            Utilisateur u = new Utilisateur(nom.getText(), prenom.getText(), numAdh.getText());
            UtilisateurDAO.ajouterUtilisateur(u);
            JOptionPane.showMessageDialog(this, "👤 Utilisateur ajouté !");
            chargerUtilisateurs();
        });

        // Charger au démarrage
        chargerUtilisateurs();
    }

    private void chargerUtilisateurs() {
        model.setRowCount(0);
        List<Utilisateur> utilisateurs = UtilisateurDAO.getAllUtilisateurs();
        for (Utilisateur u : utilisateurs) {
            model.addRow(new Object[]{
                u.getId(), u.getNom(), u.getPrenom(), u.getNumAdherent()
            });
        }
    }
}
