package Listesfortables;

import javax.swing.*;

import daoimp.ProfesseurDAOImpl;
import models.Professeur;

import java.awt.*;
import java.awt.event.*;

public class ProfessorUpdateDialog extends JDialog {
    private JTextField nomField, prenomField, emailField, departementField, statusField;
    private JButton saveButton, cancelButton;
    private int professeurID;

    public ProfessorUpdateDialog(JFrame parent, ProfesseurDAOImpl profDao, int professeurID) {
        super(parent, "Update Professor", true);
        setSize(300, 300);
        setLayout(new GridLayout(6, 2));

        try {
            Professeur prof = profDao.getProfesseur(professeurID);
            this.professeurID = professeurID;

            nomField = new JTextField(prof.getNom());
            prenomField = new JTextField(prof.getPrenom());
            emailField = new JTextField(prof.getEmail());
            departementField = new JTextField(String.valueOf(prof.getDepartementID()));
            statusField = new JTextField(prof.getstatus());

            saveButton = new JButton("Save");
            cancelButton = new JButton("Cancel");

            add(new JLabel("Nom:"));
            add(nomField);
            add(new JLabel("Prenom:"));
            add(prenomField);
            add(new JLabel("Email:"));
            add(emailField);
            add(new JLabel("Departement ID:"));
            add(departementField);
            add(new JLabel("Status:"));
            add(statusField);

            add(saveButton);
            add(cancelButton);

            saveButton.addActionListener(e -> {
                Professeur updatedProf = new Professeur(professeurID, nomField.getText(), prenomField.getText(), emailField.getText(), Integer.parseInt(departementField.getText()), statusField.getText());
                try {
                    profDao.updateProfesseur(updatedProf);
                    JOptionPane.showMessageDialog(this, "Professor updated successfully!");
                    dispose();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(this, "Update failed: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            });

            cancelButton.addActionListener(e -> dispose());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Failed to fetch professor details: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            dispose();
        }

        setLocationRelativeTo(parent);
    }
}
