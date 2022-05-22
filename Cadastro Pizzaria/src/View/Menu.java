package View;

import javax.swing.*;

public class Menu extends JFrame {
    public Menu() {
        JFrame frame = new JFrame();
        JLabel label = new JLabel("Nome");
        //JLabel label1 = new JLabel("telefone");
        //JLabel label2 = new JLabel("cpf");
        //JLabel label3 = new JLabel("rua");
        //JLabel label4 = new JLabel("Numero");
        //JLabel label5 = new JLabel("Bairro");
        //JLabel label6 = new JLabel("Estado");
        //JLabel label7 = new JLabel("Cidade");
        frame.getContentPane().add(label);
        //frame.getContentPane().add(label1);
        //frame.getContentPane().add(label2);
        //frame.getContentPane().add(label3);
        //frame.getContentPane().add(label4);
        //frame.getContentPane().add(label5);
        //frame.getContentPane().add(label6);
        //frame.getContentPane().add(label7);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setSize(800, 600);
        //JPanel painel = new JPanel();
        JButton b = new JButton("Cadastrar Cliente");
        JButton b1 = new JButton("Cadastrar Produto");
        JButton b2 = new JButton("Procurar cliente");
        JButton b3 = new JButton("Enviar cupom de desconto");
    }

}