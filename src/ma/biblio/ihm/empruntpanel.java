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
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import ma.biblio.Emprunt;
import ma.biblio.Livre;
import ma.biblio.Utilisateur;
import ma.biblio.beans.*;
import ma.biblio.dao.*;

public class empruntpanel extends JPanel {
    private JTable table;
    private DefaultTableModel model;

    public empruntpanel() {
        setLayout(new BorderLayout(10, 10));
        setBackground(new Color(240, 250, 255)); // Fond général doux

        // ==== Formulaire ====
        JPanel form = new JPanel(new GridBagLayout());
        form.setBackground(new Color(225, 240, 255)); // Fond du formulaire
        form.setBorder(new TitledBorder("📖 Nouvel emprunt"));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JComboBox<Livre> livres = new JComboBox<>();
        JComboBox<Utilisateur> utilisateurs = new JComboBox<>();

        for (Livre l : LivreDAO.getAllLivres()) livres.addItem(l);
        for (Utilisateur u : UtilisateurDAO.getAllUtilisateurs()) utilisateurs.addItem(u);

        JButton btnEmprunter = new JButton("📥 Enregistrer");
        btnEmprunter.setBackground(new Color(60, 140, 180));
        btnEmprunter.setForeground(Color.WHITE);
        btnEmprunter.setFocusPainted(false);

        gbc.gridx = 0; gbc.gridy = 0; form.add(new JLabel("Livre :"), gbc);
        gbc.gridx = 1; form.add(livres, gbc);

        gbc.gridx = 0; gbc.gridy = 1; form.add(new JLabel("Utilisateur :"), gbc);
        gbc.gridx = 1; form.add(utilisateurs, gbc);

        gbc.gridx = 1; gbc.gridy = 2; form.add(btnEmprunter, gbc);

        add(form, BorderLayout.NORTH);

        // ==== Tableau des emprunts ====
        JPanel tableauPanel = new JPanel(new BorderLayout());
        tableauPanel.setBackground(Color.WHITE);
        tableauPanel.setBorder(new TitledBorder("📋 Emprunts en cours"));

        model = new DefaultTableModel(new Object[]{"ID", "Livre", "Utilisateur", "Date", "Retour"}, 0) {
            public boolean isCellEditable(int row, int column) {
                return column == 4; // seule la colonne bouton est éditable
            }
        };

        table = new JTable(model);
        table.setRowHeight(24);
        table.getTableHeader().setFont(new Font("SansSerif", Font.BOLD, 14));
        table.getTableHeader().setBackground(new Color(200, 220, 240));
        table.getColumn("Retour").setCellRenderer(new ButtonRenderer());
        table.getColumn("Retour").setCellEditor(new ButtonEditor(new JCheckBox()));

        tableauPanel.add(new JScrollPane(table), BorderLayout.CENTER);
        add(tableauPanel, BorderLayout.CENTER);

        // Action bouton emprunter
        btnEmprunter.addActionListener(e -> {
            Livre l = (Livre) livres.getSelectedItem();
            Utilisateur u = (Utilisateur) utilisateurs.getSelectedItem();
            if (l != null && u != null) {
                Emprunt emp = new Emprunt(l.getId(), u.getId(), Date.valueOf(LocalDate.now()));
                EmpruntDAO.enregistrerEmprunt(emp);
                JOptionPane.showMessageDialog(this, "✅ Emprunt enregistré !");
                chargerEmprunts();
            }
        });

        // Chargement des emprunts au lancement
        chargerEmprunts();
    }

    private void chargerEmprunts() {
        model.setRowCount(0);
        for (Emprunt e : EmpruntDAO.getEmpruntsEnCours()) {
            model.addRow(new Object[]{
                e.getId(), e.getIdLivre(), e.getIdUtilisateur(), e.getDateEmprunt(), "📤 Retour"
            });
        }
    }

    // ==== Rendu bouton ====
    class ButtonRenderer extends JButton implements javax.swing.table.TableCellRenderer {
        public ButtonRenderer() {
            setForeground(Color.WHITE);
            setBackground(new Color(255, 120, 80));
            setFocusPainted(false);
        }

        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
                                                       boolean hasFocus, int row, int column) {
            setText(value == null ? "📤 Retour" : value.toString());
            return this;
        }
    }

    // ==== Éditeur bouton ====
    class ButtonEditor extends DefaultCellEditor {
        protected JButton button = new JButton();
        private int selectedRow;

        public ButtonEditor(JCheckBox checkBox) {
            super(checkBox);
            button.setForeground(Color.WHITE);
            button.setBackground(new Color(255, 120, 80));
            button.setFocusPainted(false);

            button.addActionListener(e -> {
                int id = (int) table.getValueAt(selectedRow, 0);
                EmpruntDAO.marquerRetour(id);
                JOptionPane.showMessageDialog(button, "📤 Livre retourné.");
                chargerEmprunts();
            });
        }

        public Component getTableCellEditorComponent(JTable table, Object value,
                                                     boolean isSelected, int row, int column) {
            selectedRow = row;
            button.setText(value == null ? "📤 Retour" : value.toString());
            return button;
        }

        public Object getCellEditorValue() {
            return "📤 Retour";
        }
    }
}
