package View;

import javax.swing.*;

import javax.swing.border.Border;

import Controller.BusinessReport;
import Controller.EmpresaController;
import Model.empresa.Cliente;

import Model.empresa.Produto;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Menu extends JFrame {

    private static Menu frame;
    private static JPanel home;
    private static Font textFont;
    private static EditarCliente editar;

    public Menu(String titulo) {
        super(titulo);
        setResizable(false);
        setSize(800, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        addWindowListener(new Window());
    }

  

    public JPanel titulo() {
        JPanel header = new JPanel(new BorderLayout());
        JLabel titulo = new JLabel("Pizza's Delivery", JLabel.CENTER);
        textFont = new Font("Arial", Font.BOLD, 40);

        titulo.setFont(textFont);
        titulo.setForeground(Color.RED);
        titulo.setPreferredSize(new Dimension(800, 50));
        titulo.setOpaque(true);
        titulo.setBackground(Color.WHITE);
        header.add(titulo, BorderLayout.NORTH);

        return header;
    }

    private JPanel rodape() {
        JPanel footer = new JPanel(new BorderLayout());
        JLabel creditos = new JLabel("<html>Grupo VI - ED1 &copy; - <B>Luan - Muzan - Tiago</b></html>");
        textFont = new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 14);
        creditos.setFont(textFont);
        creditos.setForeground(Color.BLUE);
        creditos.setBorder(BorderFactory.createEmptyBorder(0, 5, 5, 0));
        footer.setBackground(Color.WHITE);
        footer.setPreferredSize(new Dimension(800, 50));
        footer.add(creditos, BorderLayout.SOUTH);

        return footer;
    }

    private JPanel rodapeVoltar(Cliente cliente) {

        JPanel footer = new JPanel(new BorderLayout());
        footer.setLayout(new GridLayout(1, 2));
        footer.setBackground(Color.WHITE);
        footer.setPreferredSize(new Dimension(800, 50));
        
        
        JLabel creditos = new JLabel("<html>Grupo VI - ED1 &copy; - <B>Luan - Muzan - Tiago</b></html>");
        textFont = new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 14);
        creditos.setFont(textFont);
        creditos.setForeground(Color.BLUE);
        creditos.setBackground(Color.WHITE);
        creditos.setBorder(BorderFactory.createEmptyBorder(0, 5, 5, 50));
        footer.add(creditos, BorderLayout.EAST);

        JButton back = new JButton("Voltar");
        back.setBounds(100, 200, 25, 25);
        back.setBackground(Color.WHITE);
        back.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
        back.setForeground(Color.RED);
        back.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(10, 50, 10, 50),
        BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK)));
        back.addActionListener(salvarClienteEditado);
        footer.add(back,BorderLayout.WEST);
        return footer;
    }

    private JPanel botoes() {

        JPanel content = new JPanel(new BorderLayout());
        content.setLayout(new GridLayout(4, 1));
        content.setBackground(Color.WHITE);
        content.setPreferredSize(new Dimension(800, 500));

        JButton createClient = new JButton("Cadastrar Cliente");
        createClient.setBounds(650, 400, 50, 50);
        createClient.setBackground(Color.DARK_GRAY);
        createClient.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
        createClient.setForeground(Color.WHITE);
        createClient.addActionListener(criarCliente);
        createClient.setBorder(BorderFactory.createMatteBorder(30, 25, 30, 575, Color.WHITE));
        content.add(createClient, BorderLayout.CENTER);

        JButton createProduct = new JButton("Cadastrar Produto");
        createProduct.setBounds(550, 400, 50, 50);
        createProduct.setBackground(Color.DARK_GRAY);
        createProduct.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
        createProduct.setForeground(Color.WHITE);
        createProduct.setBorder(BorderFactory.createMatteBorder(30, 25, 30, 575, Color.WHITE));
        createProduct.addActionListener(criarProduto);
        content.add(createProduct, BorderLayout.CENTER);

        JButton searchClient = new JButton("Procurar cliente");
        searchClient.addActionListener(editarCliente);
        searchClient.setBounds(450, 400, 50, 50);
        searchClient.setBackground(Color.DARK_GRAY);
        searchClient.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
        searchClient.setForeground(Color.WHITE);
        searchClient.addActionListener(editarCliente);
        searchClient.setBorder(BorderFactory.createMatteBorder(30, 25, 30, 575, Color.WHITE));
        content.add(searchClient, BorderLayout.CENTER);

        JButton discount = new JButton("Relat??rio de Vendas");
        discount.setBounds(350, 400, 50, 50);
        discount.setBackground(Color.DARK_GRAY);
        discount.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
        discount.setForeground(Color.WHITE);
        discount.addActionListener(createReport);
        discount.setBorder(BorderFactory.createMatteBorder(30, 25, 30, 575, Color.WHITE));
        content.add(discount, BorderLayout.CENTER);

        return content;
    }

    private JPanel cadastrarProduto() {
        JPanel content = new JPanel(new BorderLayout());
        GridBagConstraints c = new GridBagConstraints();

        content.setBorder(BorderFactory.createEmptyBorder(120, 0, 0, 0));
        content.setLayout(new GridLayout(5, 2));
        content.setBackground(Color.WHITE);
        content.setPreferredSize(new Dimension(800, 500));

        JLabel produto = new JLabel("Produto:", JLabel.CENTER);
        produto.setFont(new Font("Comic Sans MS", Font.BOLD, 40));
        produto.setForeground(Color.BLACK);
        produto.setBackground(Color.WHITE);
        produto.setOpaque(true);
        produto.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        produto.setPreferredSize(new Dimension(50, 50));

        content.add(produto);

        JTextField product = new JTextField(20);
        product.setBounds(350, 400, 50, 50);
        // discount.setBackground(Color.DARK_GRAY);
        product.setFont(new Font("Arial", Font.BOLD, 30));
        Border border = BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(10, 50, 10, 50),
                BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
        // discount.setForeground(Color.WHITE);
        product.setBorder(border);
        product.setMargin(new Insets(10, 100, 10, 100));

        content.add(product);

        JLabel valor = new JLabel("valor:", JLabel.CENTER);
        valor.setFont(new Font("Comic Sans MS", Font.BOLD, 40));
        valor.setForeground(Color.BLACK);
        valor.setBackground(Color.WHITE);
        valor.setOpaque(true);
        valor.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        valor.setPreferredSize(new Dimension(50, 50));
        content.add(valor);

        JTextField value = new JTextField(20);
        value.setBounds(350, 400, 50, 50);
        // discount.setBackground(Color.DARK_GRAY);
        value.setFont(new Font("Arial", Font.BOLD, 30));
        // discount.setForeground(Color.WHITE);
        value.setBorder(border);
        value.setMargin(new Insets(10, 100, 10, 100));
        content.add(value);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 5;

        JButton back = new JButton("Cancelar");
        back.setBounds(350, 400, 50, 50);
        back.setBackground(Color.WHITE);
        back.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
        back.setForeground(Color.RED);
        back.setBorder(border);
        back.addActionListener(voltarPrincipal);
        content.add(back, c);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 2;
        c.gridy = 5;

        JButton save = new JButton("Salvar");
        save.setBounds(350, 400, 50, 50);
        save.setBackground(Color.WHITE);
        save.setFont(new Font("Comic Sans MS", Font.BOLD, 14));

        save.setForeground(Color.BLUE);

        save.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                int result;
                try {
                    String produto = product.getText();
                    double valor = Double.parseDouble(value.getText());
                    System.out.println(produto + " " + valor);

                    try {
                        EmpresaController.empresa.setProduto(new Produto(valor, produto));
                        frame.setContentPane(Menu.home);
                        frame.setVisible(true);

                    } catch (Exception ee) {
                        result = JOptionPane.showConfirmDialog(null, "N??o foi possivel salvar o produto", "ERRO!",
                                JOptionPane.WARNING_MESSAGE);
                        if (result == JOptionPane.CANCEL_OPTION) {
                            frame.setContentPane(Menu.home);
                            frame.setVisible(true);
                        }
                    }

                    System.out.println(EmpresaController.empresa.getProdutos().toString());

                } catch (NullPointerException n) {

                    result = JOptionPane.showConfirmDialog(null, "Algum dos campos est??o vazios!", "ERRO!",
                            JOptionPane.WARNING_MESSAGE);
                    if (result == JOptionPane.CANCEL_OPTION) {
                        frame.setContentPane(Menu.home);
                        frame.setVisible(true);
                    }
                } catch (NumberFormatException f) {

                    result = JOptionPane.showConfirmDialog(null, "Pre??o invalido!", "ERRO!",
                            JOptionPane.WARNING_MESSAGE);
                    if (result == JOptionPane.CANCEL_OPTION) {
                        frame.setContentPane(Menu.home);
                        frame.setVisible(true);
                    }
                } catch (Exception exp) {

                    result = JOptionPane.showConfirmDialog(null, exp.getLocalizedMessage(), "ERRO!",
                            JOptionPane.WARNING_MESSAGE);
                    if (result == JOptionPane.CANCEL_OPTION) {
                        frame.setContentPane(Menu.home);
                        frame.setVisible(true);
                    }
                }

            }

        });
        save.setBorder(border);
        content.add(save, c);

        return content;
    }

    public JPanel buildHomeScreen() {
        JPanel main = new JPanel(new BorderLayout());

        main.add(titulo(), BorderLayout.NORTH);


        main.add(botoes(), BorderLayout.CENTER);
        main.add(rodape(), BorderLayout.SOUTH);

        return main;
    }

    public JPanel buildpesquisarCliente() {
        JPanel main = new JPanel(new BorderLayout());

        main.add(titulo(), BorderLayout.NORTH);
        main.add(new PesquisarCliente(frame), BorderLayout.CENTER);
        main.add(rodape(), BorderLayout.SOUTH);

        return main;
    }


    public JPanel buildCadastroProduto() {
        JPanel main = new JPanel(new BorderLayout());

        main.add(titulo(), BorderLayout.NORTH);

        main.add(cadastrarProduto(), BorderLayout.CENTER);
        main.add(rodape(), BorderLayout.SOUTH);

        return main;
    }

    public JPanel buildCadastroCliente() {
        JPanel main = new JPanel(new BorderLayout());

        main.add(titulo(), BorderLayout.NORTH);
        main.add(new CriarCliente(frame), BorderLayout.CENTER);
        main.add(rodape(), BorderLayout.SOUTH);

        return main;
    }

    public JPanel selecionaCliente() {
        JPanel main = new JPanel(new BorderLayout());
        
        main.add(titulo(), BorderLayout.NORTH);
        main.add(new PesquisarCliente(frame),BorderLayout.CENTER);
        main.add(rodape(), BorderLayout.SOUTH);

        return main;
    }

    public JPanel editaCliente(Cliente cliente) {
        JPanel main = new JPanel(new BorderLayout());
        editar = new EditarCliente(cliente, frame);

        main.add(titulo(), BorderLayout.NORTH);
        main.add(editar,BorderLayout.CENTER);
        main.add(rodapeVoltar(cliente), BorderLayout.SOUTH);

        return main;
    }

    public JPanel selecionaProduto(Cliente c) {
        JPanel main = new JPanel(new BorderLayout());
        
        main.add(titulo(), BorderLayout.NORTH);
        main.add(new AddProdutoView(c,frame),BorderLayout.CENTER);
        main.add(rodape(), BorderLayout.SOUTH);

        return main;
    }

    private ActionListener salvarClienteEditado = new ActionListener(){
        
        @Override
        public void actionPerformed(ActionEvent e) {
           editar.clienteAlterado();  
           frame.setContentPane(Menu.home);
        frame.setVisible(true);    
        }
    };

    private ActionListener criarProduto = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            frame.remove(buildHomeScreen());
            frame.setContentPane(buildCadastroProduto());
            frame.validate();
            frame.setVisible(true);
        }
    };


    private ActionListener createReport = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                BusinessReport br = new BusinessReport("./relatorio.csv");
                br.buildBusinessReport();
                
            } catch (Exception e1) {
                JOptionPane.showMessageDialog(null, "N??o foi possivel gerar o relatorio", "Erro", JOptionPane.OK_OPTION);
            }
        }
    };

    private ActionListener criarCliente = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            frame.remove(buildHomeScreen());
            frame.setContentPane(buildCadastroCliente());
            frame.validate();
            frame.setVisible(true);
        }
    };

    private ActionListener editarCliente = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            frame.remove(buildHomeScreen());
            frame.setContentPane(selecionaCliente());
            frame.validate();
            frame.setVisible(true);
        }
    };

    private ActionListener voltarPrincipal = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            frame.setContentPane(Menu.home);
            frame.setVisible(true);
        }
    };

    

    private static void createAndShowGUI() {

      
        frame = new Menu("Pizza's Delivery");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        home = frame.buildHomeScreen();
        frame.setContentPane(home);

        frame.setVisible(true);
    }

 

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}