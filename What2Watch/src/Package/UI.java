package Package;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import static java.awt.Transparency.TRANSLUCENT;

public class UI {
    JFrame window;

    JPanel loginButtonPanel;
    JButton loginButton;
    JPanel signUpButtonPanel;
    JButton signUpButton;

    Font buttonFont = new Font("Montserrat", Font.PLAIN, 25);

    JPanel titleNamePanel;
    JLabel titleNameLabel, background;


    public void createUI() throws IOException, FontFormatException {

        // TODO window
        window = new JFrame("What2Watch");
        window.setSize(1650, 1080);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.pack();
        window.setLayout(null);
        window.setVisible(true);


        // TODO login/sign up buttons
        loginButtonPanel = new JPanel();
        loginButtonPanel.setBounds(800, 670, 100, 48);
        loginButtonPanel.setBackground(new Color(0,0,0,0));
        loginButton = new JButton("Login");
        //loginButton.setBounds(800, 670, 100, 48);
        loginButton.setOpaque(false);
        loginButton.setContentAreaFilled(false);
        loginButton.setBackground(new Color(0,0,0,0));
        loginButton.setForeground(Color.white);
        loginButton.setFont(buttonFont);
        loginButton.setFocusPainted(true);
        loginButtonPanel.add(loginButton);


        signUpButtonPanel = new JPanel();
        signUpButtonPanel.setBounds(1100, 670, 130, 48);
        signUpButtonPanel.setBackground(new Color(0,0,0,0));
        signUpButton = new JButton("Sign Up");
        //signUpButton.setBounds(1100, 670, 130, 48);
        signUpButton.setOpaque(false);
        signUpButton.setContentAreaFilled(false);
        signUpButton.setBackground(new Color(0,0,0,0));
        signUpButton.setForeground(Color.white);
        signUpButton.setFont(buttonFont);
        signUpButton.setFocusPainted(false);
        signUpButtonPanel.add(signUpButton);

        window.add(loginButtonPanel);
        window.add(signUpButtonPanel);
    }



    /*
    public UI(){


        loginButton = new JButton("Login");
        loginButton.setBounds(50,50,100,50);
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Successful log in");
            }
        });

        frame = new JFrame("What2Watch");
        frame.add(background);
        frame.setSize(1650,1080);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new GUI();
    }
     */
}