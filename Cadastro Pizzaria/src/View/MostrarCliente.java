package View;

import java.awt.LayoutManager;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.*;
import javax.swing.border.Border;


public class MostrarCliente extends JPanel {
   
   public MostrarCliente(){
  super(new BorderLayout());
   };
   
   
    private void cadastrarCliente(){

        GridBagConstraints c = new GridBagConstraints();
        setLayout(new GridLayout(6,3));
        
             //Labels
 
         JLabel Name = new JLabel("Nome",JLabel.LEFT);
         Name.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
         Name.setBackground(Color.WHITE);
         Name.setForeground(Color.BLACK);
         Name.setBorder(BorderFactory.createMatteBorder(30, 25, 30, 575, Color.WHITE));
         Name.setPreferredSize(new Dimension(20,15));
         Name.setOpaque(true);
         add(Name);
 
 
 
         JLabel CPF = new JLabel("CPF",JLabel.LEFT);
         CPF.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
         CPF.setBackground(Color.WHITE);
         CPF.setForeground(Color.BLACK);
         CPF.setBorder(BorderFactory.createMatteBorder(30, 25, 30, 575, Color.WHITE));
         CPF.setPreferredSize(new Dimension(20,15));
         CPF.setOpaque(true);
         add(CPF);
 
 
 
 
         JLabel Telefone = new JLabel("Telefone",JLabel.LEFT);
         Telefone.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
         Telefone.setBackground(Color.WHITE);
         Telefone.setForeground(Color.BLACK);
         Telefone.setBorder(BorderFactory.createMatteBorder(30, 25, 30, 575, Color.WHITE));
         Telefone.setPreferredSize(new Dimension(20,15));
         Telefone.setOpaque(true);
         add(Telefone);
 
 
 
         JLabel Rua = new JLabel("Rua",JLabel.LEFT);
         Rua.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
         Rua.setBackground(Color.WHITE);
         Rua.setForeground(Color.BLACK);
         Rua.setBorder(BorderFactory.createMatteBorder(30, 25, 30, 575, Color.WHITE));
         Rua.setPreferredSize(new Dimension(20,15));
         Rua.setOpaque(true);
         add(Rua);
 
 
 
         JLabel numero = new JLabel("numero",JLabel.LEFT);
         numero.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
         numero.setBackground(Color.WHITE);
         numero.setForeground(Color.BLACK);
         numero.setBorder(BorderFactory.createMatteBorder(30, 25, 30, 575, Color.WHITE));
         numero.setPreferredSize(new Dimension(20,15));
         numero.setOpaque(true);
         add(numero);
 
 
 
 
 
         JLabel cidade = new JLabel("cidade",JLabel.LEFT);
         cidade.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
         cidade.setBackground(Color.WHITE);
         cidade.setForeground(Color.BLACK);
         cidade.setBorder(BorderFactory.createMatteBorder(30, 25, 30, 575, Color.WHITE));
         cidade.setPreferredSize(new Dimension(20,15));
         cidade.setOpaque(true);
         add(cidade);
 
 
 
         JLabel Bairro = new JLabel("Bairro",JLabel.LEFT);
         Bairro.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
         Bairro.setBackground(Color.WHITE);
         Bairro.setForeground(Color.BLACK);
         Bairro.setBorder(BorderFactory.createMatteBorder(30, 25, 30, 575, Color.WHITE));
         Bairro.setPreferredSize(new Dimension(20,15));
         Bairro.setOpaque(true);
         add(Bairro);
 
 
 
 
 
         JLabel Estado = new JLabel("Estado",JLabel.LEFT);
         Estado.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
         Estado.setBackground(Color.WHITE);
         Estado.setForeground(Color.BLACK);
         Estado.setBorder(BorderFactory.createMatteBorder(30, 25, 30, 575, Color.WHITE));
         Estado.setPreferredSize(new Dimension(20,15));
         Estado.setOpaque(true);
         add(Estado);
 
 
   
 
             //Botoes
             c.fill=GridBagConstraints.HORIZONTAL;
             c.gridx=6;
             c.gridy=3;
 
 
         JButton SaveButton = new JButton("Salvar");
         SaveButton.setBounds(60, 650, 25, 25);
         SaveButton.setBackground(Color.GREEN);
         SaveButton.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
         SaveButton.setForeground(Color.WHITE);
         SaveButton.setBorder(BorderFactory.createMatteBorder(50, 25, 50, 575, Color.WHITE));
        add(SaveButton,c);
 
 
         c.fill=GridBagConstraints.HORIZONTAL;
         c.gridx=6;
         c.gridy=2;
 
 
 
         JButton Cancel = new JButton("Cancelar");
         Cancel.setBounds(60, 700, 25, 25);
         Cancel.setBackground(Color.RED);
         Cancel.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
         Cancel.setForeground(Color.WHITE);
         Cancel.setBorder(BorderFactory.createMatteBorder(50, 25, 50, 575, Color.WHITE));
        add(Cancel,c);
         
 
        
 
        
         //textfields
 
         JTextField nameText = new JTextField(30);
         nameText.setBounds(650,400,25,25);
         nameText.setFont(new Font("Arial",Font.BOLD,14));
         nameText.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
         nameText.setMargin(new Insets(10,100,10,100));
         add(nameText);
 
          JTextField CadastroPessoaFisica = new JTextField(11);
          CadastroPessoaFisica.setBounds(625,400,25,25);
          CadastroPessoaFisica.setFont(new Font("Arial",Font.BOLD,14));
          CadastroPessoaFisica.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
          CadastroPessoaFisica.setMargin(new Insets(10,50,10,50));
          add(CPF);
 
 
          JTextField Phone = new JTextField(10);
          Phone.setBounds(625,400,25,25);
          Phone.setFont(new Font("Arial",Font.BOLD,14));
          Phone.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
          Phone.setMargin(new Insets(10,50,10,50));
          add(Phone);
 
 
 
          JTextField Street = new JTextField(10);
          Street.setBounds(625,400,25,25);
          Street.setFont(new Font("Arial",Font.BOLD,14));
          Street.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
          Street.setMargin(new Insets(10,50,10,50));
          add(Street);
 
 
 
 
          JTextField number = new JTextField(10);
          number.setBounds(625,400,25,25);
          number.setFont(new Font("Arial",Font.BOLD,14));
          number.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
          number.setMargin(new Insets(10,50,10,50));
          add(number);
 
 
 
 
          JTextField city = new JTextField(10);
          city.setBounds(625,400,25,25);
          city.setFont(new Font("Arial",Font.BOLD,14));
          city.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
          city.setMargin(new Insets(10,50,10,50));
          add(city);
 
 
 
          JTextField district = new JTextField(10);
          district.setBounds(625,400,25,25);
          district.setFont(new Font("Arial",Font.BOLD,14));
          district.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
          district.setMargin(new Insets(10,50,10,50));
        add(district);
 
        
 
 
          JTextField state = new JTextField(10);
          state.setBounds(625,400,25,25);
          state.setFont(new Font("Arial",Font.BOLD,14));
          state.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
          state.setMargin(new Insets(10,50,10,50));
         add(state);
          
 
     
 
 
     }
}
