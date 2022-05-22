package View;

import java.awt.LayoutManager;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.*;
import javax.swing.border.Border;

public class MostrarCliente extends JPanel {

    public MostrarCliente() {
        super(new BorderLayout());
        cadastrarCliente();
    };

    private void cadastrarCliente() {
        setPreferredSize(new Dimension(800, 500));
        GridBagConstraints c = new GridBagConstraints();
        setLayout(new GridLayout(9, 2));
        Border border = BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(10, 2, 10, 20),
        BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
        // Labels

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

        JLabel Telefone = new JLabel("Telefone", JLabel.LEFT);
        Telefone.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
        Telefone.setBackground(Color.WHITE);
        Telefone.setForeground(Color.BLACK);
        Telefone.setBorder(BorderFactory.createMatteBorder(30, 25, 30, 575, Color.WHITE));
        Telefone.setPreferredSize(new Dimension(20, 15));
        Telefone.setOpaque(true);
        add(Telefone);

        JLabel Rua = new JLabel("Rua", JLabel.LEFT);
        Rua.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
        Rua.setBackground(Color.WHITE);
        Rua.setForeground(Color.BLACK);
        Rua.setBorder(BorderFactory.createMatteBorder(30, 25, 30, 575, Color.WHITE));
        Rua.setPreferredSize(new Dimension(20, 15));
        Rua.setOpaque(true);
        add(Rua);

        JLabel numero = new JLabel("numero", JLabel.LEFT);
        numero.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
        numero.setBackground(Color.WHITE);
        numero.setForeground(Color.BLACK);
        numero.setBorder(BorderFactory.createMatteBorder(30, 25, 30, 575, Color.WHITE));
        numero.setPreferredSize(new Dimension(20, 15));
        numero.setOpaque(true);
        add(numero);

        JLabel cidade = new JLabel("cidade", JLabel.LEFT);
        cidade.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
        cidade.setBackground(Color.WHITE);
        cidade.setForeground(Color.BLACK);
        cidade.setBorder(BorderFactory.createMatteBorder(30, 25, 30, 575, Color.WHITE));
        cidade.setPreferredSize(new Dimension(20, 15));
        cidade.setOpaque(true);
        add(cidade);

        JLabel Bairro = new JLabel("Bairro", JLabel.LEFT);
        Bairro.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
        Bairro.setBackground(Color.WHITE);
        Bairro.setForeground(Color.BLACK);
        Bairro.setBorder(BorderFactory.createMatteBorder(30, 25, 30, 575, Color.WHITE));
        Bairro.setPreferredSize(new Dimension(20, 15));
        Bairro.setOpaque(true);
        add(Bairro);

        JLabel Estado = new JLabel("Estado", JLabel.LEFT);
        Estado.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
        Estado.setBackground(Color.WHITE);
        Estado.setForeground(Color.BLACK);
        Estado.setBorder(BorderFactory.createMatteBorder(30, 25, 30, 575, Color.WHITE));
        Estado.setPreferredSize(new Dimension(20, 15));
        Estado.setOpaque(true);
        add(Estado);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridy = 9;

        JButton back = new JButton("Cancelar");
        back.setBounds(350, 400, 50, 50);
        back.setBackground(Color.WHITE);
        back.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
        back.setForeground(Color.RED);
        back.setBorder(border);
       // back.addActionListener(voltarPrincipal);
        add(back, c);
        
        // Botoes
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 2;
        c.gridy = 9;

        JButton save = new JButton("Salvar");
        save.setBounds(350, 400, 50, 50);
        save.setBackground(Color.WHITE);
        save.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
        save.setForeground(Color.BLUE);
        save.setBorder(border);
        add(save, c);


        // textfields





        JTextField Phone = new JTextField(10);
        Phone.setBounds(625, 400, 25, 25);
        Phone.setFont(new Font("Arial", Font.BOLD, 14));
        Phone.setBorder(border);
        Phone.setMargin(new Insets(10, 50, 10, 50));
        add(Phone);

        JTextField Street = new JTextField(10);
        Street.setBounds(625, 400, 25, 25);
        Street.setFont(new Font("Arial", Font.BOLD, 14));
        Street.setBorder(border);
        Street.setMargin(new Insets(10, 50, 10, 50));
        add(Street);

        JTextField number = new JTextField(10);
        number.setBounds(625, 400, 25, 25);
        number.setFont(new Font("Arial", Font.BOLD, 14));
        number.setBorder(border);
        number.setMargin(new Insets(10, 50, 10, 50));
        add(number);

        JTextField city = new JTextField(10);
        city.setBounds(625, 400, 25, 25);
        city.setFont(new Font("Arial", Font.BOLD, 14));
        city.setBorder(border);
        city.setMargin(new Insets(10, 50, 10, 50));
        add(city);

        JTextField district = new JTextField(10);
        district.setBounds(625, 400, 25, 25);
        district.setFont(new Font("Arial", Font.BOLD, 14));
        district.setBorder(border);
        district.setMargin(new Insets(10, 50, 10, 50));
        add(district);

        JTextField state = new JTextField(10);
        state.setBounds(625, 400, 25, 25);
        state.setFont(new Font("Arial", Font.BOLD, 14));
        state.setBorder(border);
        state.setMargin(new Insets(10, 50, 10, 50));
        add(state);

    }
}
