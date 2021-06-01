package com.codebind;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Usuaris {
    private JTextField textField1;
    private JButton button1;
    private JPanel panel1;
    private JComboBox comboBox1;
    private JButton usarUsuarioButton;
    private JButton eliminarUsuarioButton;

    static JFrame frame = new JFrame("Usuarios");

    static AdminUsuaris a1;

    public Usuaris() {

        renovarcomboBox();

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //comprueba que se haya rellenado el campo
                if (textField1.getText().equals("")){
                    System.out.println("Por favor rellene el campo");
                }else if(a1.getList().contains(textField1.getText())){
                    System.out.println("Este usuario ya existe, por favor escoja otro nombre");
                }else{
                    a1 = new AdminUsuaris();
                    a1.registrarUser(textField1.getText());
                    textField1.setText("");
                    comboBox1.removeAllItems();
                    renovarcomboBox();
                }
            }
        });
        eliminarUsuarioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Selecciona el usuario escogido y lo manda eleminar a AdminUsuaris
                a1.borrarLinea(comboBox1.getSelectedItem().toString());
                comboBox1.removeAllItems();

                renovarcomboBox();
            }
        });
        usarUsuarioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EscogerLugar e1 = new EscogerLugar(comboBox1.getSelectedItem().toString());
                e1.iniciar();
                frame.dispose();
            }
        });
    }

    public static void iniciar() {
        ImageIcon img=new ImageIcon("pez.jpg");
        frame.setIconImage(img.getImage());
        frame.setContentPane(new Usuaris().panel1);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
        frame.setSize(400,200);
        frame.setResizable(false);
    }

    //Refresca la comboBox
    public void renovarcomboBox(){
        for (String i: a1.getList()){
            this.comboBox1.addItem(i);
        }
    }
}
