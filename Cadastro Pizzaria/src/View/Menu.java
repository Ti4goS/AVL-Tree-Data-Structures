package View;

import javax.swing.*;

public class Menu {
    public Menu() {
        JFrame frame = new JFrame ("Lista de Produtos");
        JTextField label = new JTextField("Interface gráfica");
        JTextField field1 = new JTextField("Nome Fantasia");
        JTextField field2 = new JTextField("Nome do Representante");
        JTextField field3 = new JTextField("Tipo de empresa");
        JTextField field4 = new JTextField("Cnpj");
        JTextField field5 = new JTextField("Informe o produto a ser cadastrado");
        frame.getContentPane().add(label);
  
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setSize(640, 480);
    }

}