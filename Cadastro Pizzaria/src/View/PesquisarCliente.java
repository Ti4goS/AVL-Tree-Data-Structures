package View;

import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.Border;

public class PesquisarCliente extends JPanel {
    
    
    public PesquisarCliente() {
        super(new BorderLayout());
        pesquisarCliente();
    };

   private void pesquisarCliente(){
    GridBagConstraints c = new GridBagConstraints();
    Border border = BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(10, 2, 10, 20),
    BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
  

    //Labels e Text

    JLabel Name = new JLabel("Nome:", JLabel.CENTER);
    Name.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
    Name.setBackground(Color.WHITE);
    Name.setForeground(Color.BLACK);
    Name.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 0));
    Name.setPreferredSize(new Dimension(1, 10));
    Name.setOpaque(true);
    add(Name);

    c.fill = GridBagConstraints.HORIZONTAL;
    c.gridx = 1;
    c.gridy = 0;

    JTextField nameText = new JTextField(30);
    nameText.setPreferredSize(new Dimension(20, 10));
    nameText.setFont(new Font("Arial", Font.BOLD, 14));
    nameText.setBorder(border);
    nameText.setMargin(new Insets(10, 10, 10, 10));
    add(nameText,c);



    c.fill = GridBagConstraints.HORIZONTAL;
    c.gridx = 0;
    c.gridy = 1;

    JLabel CPF = new JLabel("CPF:", JLabel.CENTER);
    CPF.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
    CPF.setBackground(Color.WHITE);
    CPF.setForeground(Color.BLACK);
    CPF.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
    CPF.setPreferredSize(new Dimension(20, 15));
    CPF.setOpaque(true);
    add(CPF,c);

    c.fill = GridBagConstraints.HORIZONTAL;
    c.gridx = 1;
    c.gridy = 1;

    JTextField CadastroPessoaFisica = new JTextField(11);
    CadastroPessoaFisica.setPreferredSize(new Dimension(20, 10));
    CadastroPessoaFisica.setFont(new Font("Arial", Font.BOLD, 14));
    CadastroPessoaFisica.setBorder(border);
    CadastroPessoaFisica.setMargin(new Insets(10, 10, 10, 10));
    add(CadastroPessoaFisica,c);




    //

    //Buttons
  
    JButton back = new JButton("Cancelar");
    back.setBounds(100, 200, 25, 25);
    back.setBackground(Color.WHITE);
    back.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
    back.setForeground(Color.RED);
    back.setBorder(border);
    add(back, c);
    
    c.fill = GridBagConstraints.HORIZONTAL;
    c.gridx = 5;
    c.gridy = 9;

    JButton save = new JButton("Pesquisar");
    save.setBounds(100, 200, 25, 25);
    save.setBackground(Color.WHITE);
    save.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
    save.setForeground(Color.BLUE);
    save.setBorder(border);
    add(save, c);

    //


   }
}
