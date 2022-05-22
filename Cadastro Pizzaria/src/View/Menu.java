package View;

import javax.swing.*;

import javax.swing.border.Border;

import java.awt.*;

public class Menu extends JFrame {

    private static Menu frame;
    private static JPanel home;
    private static Font textFont;

    public Menu(String titulo) {
        super(titulo);
        setResizable(false);
        setSize(800, 600);
        setLocationRelativeTo(null);
    }

    public static JPanel titulo(){
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

    private static JPanel rodape() {
        JPanel footer = new JPanel(new BorderLayout());
        JLabel creditos = new JLabel("<html>Grupo VI - ED1 &copy; - <B>Luan - Muzan - Tiago</b></html>");
        textFont = new Font("Comic Sans MS", Font.BOLD|Font.ITALIC, 14);
        creditos.setFont(textFont);
        creditos.setForeground(Color.BLUE);
        creditos.setBorder(BorderFactory.createEmptyBorder(0, 5, 5, 0));
        footer.setBackground(Color.WHITE);
        footer.setPreferredSize(new Dimension(800, 50));
        footer.add(creditos, BorderLayout.SOUTH);

        return footer;
    }

    private static JPanel botoes() {
        
        JPanel content = new JPanel(new BorderLayout());
        content.setLayout(new GridLayout(4,1));
        content.setBackground(Color.WHITE);
        content.setPreferredSize(new Dimension(800, 500));

        JButton createClient = new JButton("Cadastrar Cliente");
        createClient.setBounds(650, 400, 50, 50);
        createClient.setBackground(Color.DARK_GRAY);
        createClient.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
        createClient.setForeground(Color.WHITE);
        createClient.setBorder(BorderFactory.createMatteBorder(30, 25, 30, 575, Color.WHITE));
        content.add(createClient,BorderLayout.CENTER);

        JButton createProduct = new JButton("Cadastrar Produto");
        createProduct.setBounds(550, 400, 50, 50);
        createProduct.setBackground(Color.DARK_GRAY);
        createProduct.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
        createProduct.setForeground(Color.WHITE);
        createProduct.setBorder(BorderFactory.createMatteBorder(30, 25, 30, 575, Color.WHITE));
        content.add(createProduct,BorderLayout.CENTER);

        JButton searchClient = new JButton("Procurar cliente");
        searchClient.setBounds(450, 400, 50, 50);
        searchClient.setBackground(Color.DARK_GRAY);
        searchClient.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
        searchClient.setForeground(Color.WHITE);
        searchClient.setBorder(BorderFactory.createMatteBorder(30, 25, 30, 575, Color.WHITE));
        content.add(searchClient,BorderLayout.CENTER);

        JButton discount = new JButton("Enviar cupom de desconto");
        discount.setBounds(350, 400, 50, 50);
        discount.setBackground(Color.DARK_GRAY);
        discount.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
        discount.setForeground(Color.WHITE);
        discount.setBorder(BorderFactory.createMatteBorder(30, 25, 30, 575, Color.WHITE));
        content.add(discount,BorderLayout.CENTER);

        

        return content;
    }

    public JPanel buildHomeScreen() {
        JPanel main = new JPanel(new BorderLayout());

        main.add(titulo(),BorderLayout.NORTH);

        main.add(botoes(),BorderLayout.CENTER);
        main.add(rodape(), BorderLayout.SOUTH);

        return main;
    }

    

    private static void createAndShowGUI() {
        frame = new Menu("Operador de autômatos");
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