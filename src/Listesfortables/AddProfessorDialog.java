package Listesfortables;

import javax.swing.*;
import daoimp.ProfesseurDAOImpl;
import models.Professeur;
import models.Department; // Make sure to import your Department model class
import dao.DepartmentDAO; // Import your DepartmentDAO interface
import daoimp.DepartmentDAOImpl; // Import your DepartmentDAOImpl class
import java.awt.*;
import java.util.List;

public class AddProfessorDialog extends JDialog {
    private JTextField nomField, prenomField, emailField, statusField;
    private JComboBox<Department> departementComboBox;
    private JButton saveButton, cancelButton;
    private DepartmentDAO departmentDao; // Assuming you have a DAO for departments

    public AddProfessorDialog(JFrame parent, ProfesseurDAOImpl profDao) {
        super(parent, "Add New Professor", true);
        this.departmentDao = departmentDao; // Initialize your department DAO

        setSize(350, 400);
        setLayout(new GridLayout(6, 2, 10, 10)); // Adjust layout as needed

        nomField = new JTextField();
        prenomField = new JTextField();
        emailField = new JTextField();
        departementComboBox = new JComboBox<>();
        statusField = new JTextField();

        saveButton = new JButton("Save");
        cancelButton = new JButton("Cancel");

        populateDepartments(); // Populate the JComboBox with departments

        add(new JLabel("Nom:"));
        add(nomField);
        add(new JLabel("Prenom:"));
        add(prenomField);
        add(new JLabel("Email:"));
        add(emailField);
        add(new JLabel("Department:"));
        add(departementComboBox);
        add(new JLabel("Status:"));
        add(statusField);

        add(saveButton);
        add(cancelButton);

        setupActions(profDao);

        setLocationRelativeTo(parent);
    }

    private void populateDepartments() {
        try {
            List<Department> departments = departmentDao.getAllDepartments();
            for (Department dept : departments) {
                departementComboBox.addItem(dept);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Failed to load departments: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void setupActions(ProfesseurDAOImpl profDao) {
        saveButton.addActionListener(e -> {
            try {
                Department selectedDepartment = (Department) departementComboBox.getSelectedItem();
                int departmentId = selectedDepartment != null ? selectedDepartment.getDepartmentID() : -1;
                Professeur newProf = new Professeur(
                        0, // Assuming ID is auto-generated
                        nomField.getText(),
                        prenomField.getText(),
                        emailField.getText(),
                        departmentId, // Use the selected department ID
                        statusField.getText()
                );
                profDao.addProfesseur(newProf);
                JOptionPane.showMessageDialog(this, "Professor added successfully!");
                dispose();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Failed to add professor: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        cancelButton.addActionListener(e -> dispose());
    }
}
