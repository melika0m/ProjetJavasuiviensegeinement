package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import main.dbcnx;
import daoimp.SemestreDAOImpl;
import models.Semestre;
import dao.SemestreDAO;

public class SemestreForm extends JFrame {
    public SemestreForm() {
        setTitle("Create New Semestre");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(3, 2, 10, 10)); // Adjusted grid layout

        JLabel nomSemestreLabel = new JLabel("Nom Semestre:");
        JTextField nomSemestreField = new JTextField();
        JLabel nombreDeSemainesLabel = new JLabel("Nombre De Semaines:");
        JTextField nombreDeSemainesField = new JTextField();
        JButton saveButton = new JButton("Save");

        add(nomSemestreLabel);
        add(nomSemestreField);
        add(nombreDeSemainesLabel);
        add(nombreDeSemainesField);
        add(new JLabel("")); // Placeholder for alignment
        add(saveButton);

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SemestreDAOImpl dao = new SemestreDAOImpl(dbcnx.getConnection());

                try {
                    String nomSemestre = nomSemestreField.getText();
                    int nombreDeSemaines = Integer.parseInt(nombreDeSemainesField.getText());
                    Semestre semestre = new Semestre();
                    semestre.setNomSemestre(nomSemestre);
                    semestre.setNombreDeSemaines(nombreDeSemaines);
                    int semestreID = dao.addSemestreAndGetID(semestre); // This method now aligns with DAO
                    
                    JOptionPane.showMessageDialog(SemestreForm.this, "Semestre saved successfully.");

                    // Assuming Formulairegeneral does not require anneeUniversitaire
                    EventQueue.invokeLater(() -> {
                        // If Formulairegeneral needs adjustment due to removal of anneeUniversitaire, update its constructor accordingly
                        Formulairegeneral professorAndCourseForm = new Formulairegeneral(semestreID);
                        professorAndCourseForm.setVisible(true);
                    });

                    SemestreForm.this.dispose();
                } catch (NumberFormatException nfe) {
                    JOptionPane.showMessageDialog(SemestreForm.this, "Please enter a valid number for Nombre De Semaines.");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(SemestreForm.this, "Error: " + ex.getMessage());
                }
            }
        });

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
}
