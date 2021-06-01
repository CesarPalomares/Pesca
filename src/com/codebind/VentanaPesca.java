package com.codebind;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaPesca {
    private JButton pescarButton;
    private JPanel panel1;
    private JLabel txt;
    private JButton atrásButton;
    private JLabel usr;

    static JFrame frame = new JFrame("Simulador Pesca");

    static JFrame frameEscoger;

    static Zona zona;

    String usuario;

    public VentanaPesca(Zona z,JFrame frameEscoger, String usuario) {
        this.usuario=usuario;
        this.frameEscoger=frameEscoger;
        zona=z;
        txt.setText("Zona: "+zona.toString());
        usr.setText("Usuario: "+usuario);

        pescarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double r = Math.random();

                Pescar p1 = new Pescar();

                if (zona.equals(Zona.FLORIDA)){
                    p1.sacarPezFlorida(r);
                }else{
                    p1.sacarPezMediterrania(r);
                }

            }
        });
        atrásButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EscogerLugar e1 = new EscogerLugar(usuario);
                e1.iniciar();
                frame.dispose();
            }
        });
    }

    public void iniciar() {
        ImageIcon img=new ImageIcon("pez.jpg");
        frame.setIconImage(img.getImage());
        frame.setContentPane(new VentanaPesca(zona,frameEscoger, this.usuario).panel1);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
        frame.setSize(280,180);
        frame.setResizable(true);

        System.out.println("Estás pescando en " + zona);
    }
}
