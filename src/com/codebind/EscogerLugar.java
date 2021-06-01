package com.codebind;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EscogerLugar {
    private JButton floridaButton;
    private JPanel panel1;
    private JButton marMediterraniaButton;

    static JFrame frame = new JFrame("Escoge donde quieres pescar.");

    String usuario;

    public EscogerLugar(String usuario) {

        this.usuario=usuario;

        floridaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                VentanaPesca v1 = new VentanaPesca(Zona.FLORIDA,frame,usuario);
                v1.iniciar();
                frame.dispose();
            }
        });
        marMediterraniaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                VentanaPesca v1 = new VentanaPesca(Zona.MEDITERRANIA,frame,usuario);
                v1.iniciar();
                frame.dispose();
            }
        });
    }

    public void iniciar(){
        ImageIcon img=new ImageIcon("pez.jpg");
        frame.setIconImage(img.getImage());
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setContentPane(new EscogerLugar(this.usuario).panel1);
        frame.setSize(400,100);
        frame.setVisible(true);
    }
}
