package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import main.dbcnx;
import daoimp.ProfesseurDAOImpl;
import daoimp.CourseDAOImpl;
import models.Professeur;
import models.Course;

public class Formulairegeneral extends JFrame {
    
    private int semestreID; // To store the semestre just created

    public Formulairegeneral(int semestreID) {
        this.semestreID = semestreID;
        setTitle("Ajouter Professeur et Cours");
        setSize(500, 400);
        setLayout(new GridLayout(0, 2, 10, 10));
        setLocationRelativeTo(null);

        JTextField nomProfField = new JTextField();
        JTextField prenomProfField = new JTextField();
        JTextField statusProfField = new JTextField();
        JTextField emailProfField = new JTextField(); // Email field for Professeur
        JTextField nomCoursField = new JTextField();
        JTextField volumeHoraireField = new JTextField();
        JTextField heuresParSemaineField = new JTextField(); // This is the new field


        addComponentsToLayout(nomProfField, prenomProfField, statusProfField, emailProfField, nomCoursField, volumeHoraireField,heuresParSemaineField);

        JButton saveButton = new JButton("Enregistrer");
        JButton saveAndAddAnotherButton = new JButton("Enregistrer et Ajouter un autre");
        add(saveButton);
        add(saveAndAddAnotherButton);

        saveButton.addActionListener(e -> saveData(nomProfField, prenomProfField, statusProfField, emailProfField, nomCoursField, volumeHoraireField, heuresParSemaineField,true));
        saveAndAddAnotherButton.addActionListener(e -> saveData(nomProfField, prenomProfField, statusProfField, emailProfField, nomCoursField, volumeHoraireField,heuresParSemaineField, false));

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    private void addComponentsToLayout(JTextField... fields) {
        String[] labels = {"Nom Professeur:", "Prénom Professeur:", "Statut Professeur:", "Email Professeur:", "Nom Cours:", "Volume Horaire:", "Heures Par Semaine:"}; // Added label
        for (int i = 0; i < fields.length; i++) {
            add(new JLabel(labels[i]));
            if (i < fields.length) {
                add(fields[i]);
            }
        }
    }


    private void saveData(JTextField nomProfField, JTextField prenomProfField, JTextField statusProfField, JTextField emailProfField, JTextField nomCoursField, JTextField volumeHoraireField, JTextField heuresParSemaineField, boolean closeAfterSaving) {
        try {
            Connection con = dbcnx.getConnection();
            Professeur professeur = new Professeur(semestreID, nomProfField.getText(), prenomProfField.getText(), emailProfField.getText(), semestreID, statusProfField.getText());
            ProfesseurDAOImpl profDao = new ProfesseurDAOImpl(con);
            int professeurID = profDao.addProfesseurAndGetId(professeur);

            Course course = new Course();
            course.setNomCours(nomCoursField.getText());
            course.setProfesseurID(professeurID);
            course.setSemestreID(this.semestreID);
            course.setVolumeHoraireTotal(Integer.parseInt(volumeHoraireField.getText()));
            course.setHeuresParSemaine(Integer.parseInt(heuresParSemaineField.getText()));
            CourseDAOImpl coursDao = new CourseDAOImpl(con);
            coursDao.addCourse(course);

            JOptionPane.showMessageDialog(this, "Professeur et Cours ajoutés avec succès.");

            if (closeAfterSaving) {
                dispose();
            } else {
                resetFormFields(nomProfField, prenomProfField, statusProfField, emailProfField, nomCoursField, volumeHoraireField,heuresParSemaineField);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Erreur lors de l'enregistrement: " + ex.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }

    private void resetFormFields(JTextField... fields) {
        for (JTextField field : fields) {
            field.setText("");
        }
    }
}
