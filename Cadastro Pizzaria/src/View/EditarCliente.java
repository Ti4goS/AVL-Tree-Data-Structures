package View;

import javax.swing.JPanel;

import Model.empresa.Cliente;
import Model.infos.Logradouro;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import javax.swing.border.Border;

import Controller.EmpresaController;

public class EditarCliente extends JPanel {

    private Cliente cliente;
    private Menu frame;

    JTextField nameText;
    JTextField cadastroPessoaFisica;
    JTextField phone;
    JTextField street;
    JTextField number;
    JTextField city;
    JTextField district;
    JTextField state;

    public EditarCliente(Cliente cliente, Menu frame) {
        super(new BorderLayout());
        this.cliente = cliente;
        this.frame = frame;
        nameText = new JTextField(cliente.getNome());
        cadastroPessoaFisica = new JTextField(cliente.getCpf());
        phone = new JTextField(cliente.getTelefone());
        street = new JTextField(cliente.getEndereco().getEndereço());
        number = new JTextField(cliente.getEndereco().getNumero().toString());
        city = new JTextField(cliente.getEndereco().getCidade());
        district = new JTextField(cliente.getEndereco().getBairro());
        state = new JTextField(cliente.getEndereco().getEstado());
        editarCliente();
    };

    private void editarCliente() {
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

        nameText.setPreferredSize(new Dimension(20, 10));
        nameText.setFont(new Font("Arial", Font.BOLD, 14));
        nameText.setBorder(border);
        nameText.setMargin(new Insets(10, 10, 10, 10));
        add(nameText, c);

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
        add(CPF, c);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridy = 1;

        cadastroPessoaFisica.setPreferredSize(new Dimension(20, 10));
        cadastroPessoaFisica.setFont(new Font("Arial", Font.BOLD, 14));
        cadastroPessoaFisica.setBorder(border);
        cadastroPessoaFisica.setMargin(new Insets(10, 10, 10, 10));
        add(cadastroPessoaFisica, c);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 2;
        c.gridy = 1;

        JLabel Telefone = new JLabel("Telefone:", JLabel.CENTER);
        Telefone.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
        Telefone.setBackground(Color.WHITE);
        Telefone.setForeground(Color.BLACK);
        Telefone.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        Telefone.setPreferredSize(new Dimension(30, 15));
        Telefone.setOpaque(true);
        add(Telefone, c);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 3;
        c.gridy = 2;

        phone.setPreferredSize(new Dimension(20, 10));
        phone.setFont(new Font("Arial", Font.BOLD, 14));
        phone.setBorder(border);
        phone.setMargin(new Insets(10, 10, 10, 10));
        add(phone, c);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 3;
        c.gridy = 1;

        JLabel Rua = new JLabel("Rua:", JLabel.CENTER);
        Rua.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
        Rua.setBackground(Color.WHITE);
        Rua.setForeground(Color.BLACK);
        Rua.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        Rua.setPreferredSize(new Dimension(40, 15));
        Rua.setOpaque(true);
        add(Rua);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 4;
        c.gridy = 2;

        street.setPreferredSize(new Dimension(20, 10));
        street.setFont(new Font("Arial", Font.BOLD, 14));
        street.setBorder(border);
        street.setMargin(new Insets(10, 10, 10, 10));
        add(street, c);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 5;
        c.gridy = 1;

        JLabel numero = new JLabel("numero:", JLabel.CENTER);
        numero.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
        numero.setBackground(Color.WHITE);
        numero.setForeground(Color.BLACK);
        numero.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        numero.setPreferredSize(new Dimension(50, 15));
        numero.setOpaque(true);
        add(numero);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 6;
        c.gridy = 2;

        number.setPreferredSize(new Dimension(20, 10));
        number.setFont(new Font("Arial", Font.BOLD, 14));
        number.setBorder(border);
        number.setMargin(new Insets(10, 10, 10, 10));
        add(number, c);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 7;
        c.gridy = 1;

        JLabel cidade = new JLabel("cidade:", JLabel.CENTER);
        cidade.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
        cidade.setBackground(Color.WHITE);
        cidade.setForeground(Color.BLACK);
        cidade.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        cidade.setPreferredSize(new Dimension(60, 15));
        cidade.setOpaque(true);
        add(cidade);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 8;
        c.gridy = 2;

        city.setPreferredSize(new Dimension(20, 10));
        city.setFont(new Font("Arial", Font.BOLD, 14));
        city.setBorder(border);
        city.setMargin(new Insets(10, 10, 10, 10));
        add(city, c);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 9;
        c.gridy = 1;

        JLabel Bairro = new JLabel("Bairro:", JLabel.CENTER);
        Bairro.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
        Bairro.setBackground(Color.WHITE);
        Bairro.setForeground(Color.BLACK);
        Bairro.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        Bairro.setPreferredSize(new Dimension(70, 15));
        Bairro.setOpaque(true);
        add(Bairro);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 10;
        c.gridy = 2;

        district.setPreferredSize(new Dimension(20, 10));
        district.setFont(new Font("Arial", Font.BOLD, 14));
        district.setBorder(border);
        district.setMargin(new Insets(10, 10, 10, 10));
        add(district, c);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 11;
        c.gridy = 1;
        JLabel Estado = new JLabel("Estado:", JLabel.CENTER);
        Estado.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
        Estado.setBackground(Color.WHITE);
        Estado.setForeground(Color.BLACK);
        Estado.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        Estado.setPreferredSize(new Dimension(80, 15));
        Estado.setOpaque(true);
        add(Estado);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 12;
        c.gridy = 2;

        state.setPreferredSize(new Dimension(20, 10));
        state.setFont(new Font("Arial", Font.BOLD, 14));
        state.setBorder(border);
        state.setMargin(new Insets(10, 10, 10, 10));
        add(state, c);

        // Buttons

        JButton back = new JButton("Excluir Cliente");
        back.setBounds(100, 200, 25, 25);
        back.setBackground(Color.WHITE);
        back.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
        back.setForeground(Color.RED);
        back.setBorder(border);
        back.addActionListener(voltarPrincipal);
        add(back, c);

        // Botoes
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 5;
        c.gridy = 9;

        JButton pedido = new JButton("Realizar pedido");
        pedido.setBounds(100, 200, 25, 25);
        pedido.setBackground(Color.WHITE);
        pedido.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
        pedido.setForeground(Color.BLUE);
        pedido.setBorder(border);
        pedido.addActionListener(selecionaProduto);
        add(pedido, c);

    }

    public void clienteAlterado() {
        int numeroCasa;
        try {
            numeroCasa = Integer.parseInt(number.getText());
        } catch (Exception e) {
           numeroCasa = cliente.getEndereco().getNumero();
        }

        Cliente novoCliente = new Cliente(phone.getText(), new Logradouro(street.getText(), numeroCasa, district.getText(), city.getText(), state.getText()), nameText.getText(), cadastroPessoaFisica.getText(), cliente.getTotalGasto(), cliente.getTotalPedidos(), cliente.getUltimoPedido(), cliente.getValorDoUltimoPedido());

        EmpresaController.deleteNode(cliente);
        EmpresaController.setRoot(novoCliente);
        this.cliente = novoCliente;
    }

    private ActionListener selecionaProduto = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            clienteAlterado();
            frame.setContentPane(frame.selecionaProduto(cliente));
            frame.setVisible(true);
        }
    };

    private ActionListener voltarPrincipal = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            int result = JOptionPane.showConfirmDialog(null, "Deseja excluir o cliente da lista de clientes?", "AVISO!",
                    JOptionPane.OK_OPTION);
            if (result == JOptionPane.OK_OPTION) {
                EmpresaController.deleteNode(cliente);
                System.out.println("passou");
                frame.setContentPane(frame.buildHomeScreen());
                frame.setVisible(true);
            }

        }
    };

}
