/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.awt.GLCanvas;
import com.jogamp.opengl.util.FPSAnimator;

import java.awt.*;
import java.awt.event.*;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import javax.swing.JPanel;

/**
 *
 * @author Tiago
 */

public class Screen implements ActionListener {
    JFrame frame = new JFrame();
    private JButton bouton = new JButton("Voir l'orbite");
    private JButton bouton2 = new JButton("Quitter");


    //Icon of the application
    Image icone = Toolkit.getDefaultToolkit().getImage("img/icon_terre.png");


    public Screen() {

        frame.setTitle("Espace");
        frame.setSize(300, 80); //200 de large et 80 de hauteur
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setIconImage(icone);

        JPanel panel = new ImgPanel(new ImageIcon("img/interface.png").getImage()); ; //Nouveau panel PANEL
        panel.add(bouton, BorderLayout.WEST);
        panel.add(bouton2, BorderLayout.EAST);
        bouton.addActionListener(this);
        bouton2.addActionListener(this);
        frame.setContentPane(panel);
        frame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object  source = e.getSource();

        if  (source == bouton) {

            GLProfile profile = GLProfile.getDefault();
            GLCapabilities caps = new GLCapabilities(profile);
            GLCanvas canvas = new GLCanvas(caps);
            canvas.addGLEventListener(new Cube());

            FPSAnimator Anime = new FPSAnimator(canvas,30);
            Anime.start();
            Frame frame = new Frame("Cube3D JOGL");
            frame.setSize(550, 550);
            frame.setLocationRelativeTo(null);
            frame.add(canvas);
            frame.setIconImage(icone);
            frame.setVisible(true);



            frame.addWindowListener(new WindowAdapter() {
                public void windowClosing(WindowEvent e) {
                    System.exit(0);
                }
            });

        }

        else if (source == bouton2) {
            System.exit(0);
        }
    }


}
