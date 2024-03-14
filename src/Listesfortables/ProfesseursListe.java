package Listesfortables;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import daoimp.ProfesseurDAOImpl;
import models.Professeur;
import ui.ProjectButter;
import main.dbcnx;

public class ProfesseursListe extends JFrame {
    private JTable table;
    private ProfesseurDAOImpl profDao;

    public ProfesseursListe() {
        setTitle("Liste des Professeurs");
        setSize(800, 600);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);

        Connection con = dbcnx.getConnection();
        profDao = new ProfesseurDAOImpl(con);

        table = new JTable();
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        JButton retourButton = new JButton("Retour");
        buttonPanel.add(retourButton);
        add(buttonPanel, BorderLayout.SOUTH);

        loadProfesseursData();

        retourButton.addActionListener(e -> retourToProjectButter());
        JButton addButton = new JButton("Ajouter Professeur");
        buttonPanel.add(addButton);

        addButton.addActionListener(e -> {
            AddProfessorDialog addDialog = new AddProfessorDialog(this, profDao);
            addDialog.setVisible(true);
            loadProfesseursData(); // Refresh the table to show the new entry
        });


        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    private void loadProfesseursData() {
        try {
            List<Professeur> professeurs = profDao.getAllProfesseurs();
            DefaultTableModel model = new DefaultTableModel(new Object[]{"ID", "Nom", "Prenom", "Email", "DepartementID", "Status", "Update", "Delete"}, 0) {
                @Override
                public boolean isCellEditable(int row, int column) {
                    // Only the "Update" and "Delete" button columns should be editable.
                    return column == 6 || column == 7;
                }
            };
            for (Professeur prof : professeurs) {
                model.addRow(new Object[]{prof.getProfesseurID(), prof.getNom(), prof.getPrenom(), prof.getEmail(), prof.getDepartementID(), prof.getstatus(), "Update", "Delete"});
            }
            table.setModel(model);

            // Adding custom renderers and editors for "Update" and "Delete" buttons
            table.getColumn("Update").setCellRenderer(new ButtonRenderer());
            table.getColumn("Update").setCellEditor(new ButtonEditor(new JCheckBox(), "Update", this, profDao, table));

            table.getColumn("Delete").setCellRenderer(new ButtonRenderer());
            table.getColumn("Delete").setCellEditor(new ButtonEditor(new JCheckBox(), "Delete", this, profDao, table));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error loading professors data.", "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

 

// Additional classes (ButtonRenderer and ButtonEditor) remain the same as previously defined.


    private void addProfesseur() {
        // Placeholder - Implement form to add a new professor
    }

    private void updateProfesseur() {
        // Placeholder - Implement form to update a selected professor
    }

    private void deleteProfesseur() {
        // Placeholder - Implement logic to delete a selected professor
    }

    private void retourToProjectButter() {
        this.dispose(); // Close the current window
        EventQueue.invokeLater(() -> {
            ProjectButter projectButter = new ProjectButter(); // Assuming you have a constructor like this
            projectButter.setVisible(true);
        });
    }
 // Button renderer class
    class ButtonRenderer extends JButton implements TableCellRenderer {
        public ButtonRenderer() {
            setOpaque(true);
        }
        
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value,
                                                       boolean isSelected, boolean hasFocus,
                                                       int row, int column) {
            setText((value == null) ? "" : value.toString());
            return this;
        }
    }
    

//    // Button editor class
//    class ButtonEditor extends DefaultCellEditor {
//        protected JButton button;
//        private String label;
//        private boolean isPushed;
//        private ProfesseurDAOImpl profDao;
//        private JTable table;
//
//        public ButtonEditor(JCheckBox checkBox, String string, ProfesseursListe professeursListe, ProfesseurDAOImpl profDao, JTable table) {
//            super(checkBox);
//            this.profDao = profDao;
//            this.table = table;
//            button = new JButton();
//            button.setOpaque(true);
//            button.addActionListener(e -> fireEditingStopped());
//        }
//        
//        @Override
//        public Component getTableCellEditorComponent(JTable table, Object value,
//                                                     boolean isSelected, int row, int column) {
//            label = (value == null) ? "" : value.toString();
//            button.setText(label);
//            isPushed = true;
//            return button;
//        }
//        
//        @Override
//        public Object getCellEditorValue() {
//            if (isPushed) {
//                int row = table.convertRowIndexToModel(table.getEditingRow());
//                try {
//                    int professeurID = Integer.parseInt(table.getModel().getValueAt(row, 0).toString());
//                    profDao.deleteProfesseur(professeurID);
//                    ((DefaultTableModel) table.getModel()).removeRow(row);
//                    JOptionPane.showMessageDialog(button, "Deleted successfully.");
//                } catch (SQLException ex) {
//                    ex.printStackTrace();
//                    JOptionPane.showMessageDialog(button, "Deletion failed.", "Error", JOptionPane.ERROR_MESSAGE);
//                }
//            }
//            isPushed = false;
//            return label;
//        }
//    }
 // Button editor class
    class ButtonEditor extends DefaultCellEditor {
        protected JButton button;
        private String label;
        private boolean isPushed;
        private ProfesseurDAOImpl profDao;
        private JTable table;
        private JFrame frame;

        public ButtonEditor(JCheckBox checkBox, String string, ProfesseursListe frame, ProfesseurDAOImpl profDao, JTable table) {
            super(checkBox);
            this.frame = frame;
            this.profDao = profDao;
            this.table = table;
            button = new JButton();
            button.setOpaque(true);
            button.addActionListener(e -> {
                if (isPushed) {
                    int row = table.convertRowIndexToModel(table.getEditingRow());
                    if ("Update".equals(label)) {
                        // Call update logic here
                        updateProfesseur(row);
                    } else if ("Delete".equals(label)) {
                        // Call delete logic here
                        deleteProfesseur(row);
                    }
                }
                fireEditingStopped(); // Make sure this is called to stop editing
            });
        }

        @Override
        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
            label = (value != null) ? value.toString() : "";
            button.setText(label);
            isPushed = true;
            return button;
        }

        @Override
        public Object getCellEditorValue() {
            isPushed = false;
            return label;
        }

        private void updateProfesseur(int row) {
            int professeurID = Integer.parseInt(table.getModel().getValueAt(row, 0).toString());
            ProfessorUpdateDialog updateDialog = new ProfessorUpdateDialog(frame, profDao, professeurID);
            updateDialog.setVisible(true);
            // Assuming you have a method to refresh the table data:
            ((ProfesseursListe)frame).loadProfesseursData();
        }


        private void deleteProfesseur(int row) {
            int professeurID = Integer.parseInt(table.getModel().getValueAt(row, 0).toString());
            try {
                profDao.deleteProfesseur(professeurID);
                ((DefaultTableModel) table.getModel()).removeRow(row);
                JOptionPane.showMessageDialog(frame, "Deleted successfully.");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(frame, "Deletion failed.", "Error", JOptionPane.ERROR_MESSAGE);
                ex.printStackTrace();
            }
        }
    }


    
}
