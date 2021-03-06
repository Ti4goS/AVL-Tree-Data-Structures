package View;

import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.Border;

import Controller.EmpresaController;
import Model.Node;

public class PesquisarCliente extends JPanel {
    private Menu frame;
    private JTextField nameText = new JTextField(30);
    private JTextField CadastroPessoaFisica = new JTextField(30);

    public PesquisarCliente(Menu frame) {
        super(new BorderLayout());
        this.frame = frame;
        pesquisarCliente();
    };

   private void pesquisarCliente(){
    Border border = BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(50, 2, 50, 20),
    BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));

    setPreferredSize(new Dimension(800, 250));
    setBackground(Color.WHITE);
    GridBagConstraints c = new GridBagConstraints();
    setLayout(new GridLayout(3, 2));

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

    
    CadastroPessoaFisica.setPreferredSize(new Dimension(20, 10));
    CadastroPessoaFisica.setFont(new Font("Arial", Font.BOLD, 14));
    CadastroPessoaFisica.setBorder(border);
    CadastroPessoaFisica.setMargin(new Insets(10, 10, 10, 10));
    add(CadastroPessoaFisica,c);

    JButton back = new JButton("voltar");
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

    JButton save = new JButton("Procurar");
    save.setBounds(100, 200, 25, 25);
    save.setBackground(Color.WHITE);
    save.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
    save.setForeground(Color.BLUE);
    save.setBorder(border);
    save.addActionListener(procurar);
    add(save, c);
   }


   private ActionListener voltarPrincipal = new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        frame.setContentPane(frame.buildHomeScreen());
        frame.setVisible(true);
    }
    };

    private ActionListener procurar = new ActionListener() {
        
    
        @Override
        public void actionPerformed(ActionEvent e) {
            Node found = EmpresaController.empresa.tree.search(nameText.getText(),CadastroPessoaFisica.getText());

            System.out.println(nameText.getText().toLowerCase() + CadastroPessoaFisica.getText().toLowerCase());
            if(found!=null){
                frame.setContentPane(frame.editaCliente(found.cliente));
                frame.setVisible(true);
            }else{
                int result = JOptionPane.showConfirmDialog(null, "Digite um valor valido nos campos","ERRO!",JOptionPane.OK_OPTION);
                
                if(result==JOptionPane.NO_OPTION){
                    frame.setContentPane(frame.buildHomeScreen());
                    frame.setVisible(true);
                }
            }
            
        }
    };
}
