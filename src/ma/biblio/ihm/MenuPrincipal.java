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
import java.awt.*;

public class MenuPrincipal extends JFrame {

    public MenuPrincipal() {
        setTitle("Gestion de la Bibliothèque");
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Initialiser le menu
        initMenu();

        // Page d’accueil avec design
        JPanel accueil = new JPanel();
        accueil.setBackground(new Color(230, 240, 255)); // Bleu clair
        accueil.setLayout(new BorderLayout());

        JLabel titre = new JLabel("Bienvenue à la Bibliothèque", SwingConstants.CENTER);
        titre.setFont(new Font("Serif", Font.BOLD, 28));
        titre.setForeground(new Color(33, 68, 115)); // Bleu foncé

        JLabel sousTitre = new JLabel("Gestion des livres, utilisateurs et emprunts", SwingConstants.CENTER);
        sousTitre.setFont(new Font("SansSerif", Font.PLAIN, 18));
        sousTitre.setForeground(new Color(70, 70, 70));

        JPanel centerPanel = new JPanel(new GridLayout(2, 1));
        centerPanel.setOpaque(false);
        centerPanel.add(titre);
        centerPanel.add(sousTitre);

        accueil.add(centerPanel, BorderLayout.CENTER);
        setContentPane(accueil);

        setVisible(true);
    }

    private void initMenu() {
          JMenuBar menuBar = new JMenuBar();
    menuBar.setBackground(new Color(45, 85, 135));  // Bleu foncé
    menuBar.setBorderPainted(false);

    JMenu menu = new JMenu("Menu");
    menu.setForeground(Color.WHITE);  // Texte blanc
    menu.setFont(new Font("SansSerif", Font.BOLD, 16));

    JMenuItem livres = new JMenuItem("📚 Livres");
    JMenuItem utilisateurs = new JMenuItem("👤 Utilisateurs");
    JMenuItem emprunts = new JMenuItem("📖 Emprunts");

    // Style des items
    JMenuItem[] items = {livres, utilisateurs, emprunts};
    for (JMenuItem item : items) {
        item.setFont(new Font("SansSerif", Font.PLAIN, 14));
        item.setBackground(new Color(245, 245, 245));  // Gris clair
        item.setForeground(new Color(33, 68, 115));    // Texte bleu
         menuBar.setPreferredSize(new Dimension(800, 40));  // hauteur personnalisée
    }
   

       
        livres.addActionListener(e -> {
            setContentPane(new livrepanel());
            revalidate();
        });

        utilisateurs.addActionListener(e -> {
            setContentPane(new utilisateurpanel());
            revalidate();
        });

        emprunts.addActionListener(e -> {
            setContentPane(new empruntpanel());
            revalidate();
        });

        menu.add(livres);
        menu.add(utilisateurs);
        menu.add(emprunts);
        menuBar.add(menu);
        setJMenuBar(menuBar);
    }

    public static void main(String[] args) {
        new MenuPrincipal();
    }
}

    

