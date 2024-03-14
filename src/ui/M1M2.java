package ui;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class M1M2 extends JFrame {
    public M1M2() {
        setTitle("Master IG Options");
        setSize(300, 200);
        setLayout(new FlowLayout());
        setLocationRelativeTo(null); // Center on screen

        JButton m1Button = new JButton("M1");
        JButton m2Button = new JButton("M2");
        

//        m1Button.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                // Open M1 specific functionality/page
//                System.out.println("M1 Clicked"); // Placeholder action
//            }
//        });
        
        m1Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ProjectButter projectButter = new ProjectButter(); // Create and show ProjectButter frame
                dispose(); // Optionally close the current frame
            }
        });


        m2Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Open M2 specific functionality/page
                System.out.println("M2 Clicked"); // Placeholder action
            }
        });

        add(m1Button);
        add(m2Button);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
}
