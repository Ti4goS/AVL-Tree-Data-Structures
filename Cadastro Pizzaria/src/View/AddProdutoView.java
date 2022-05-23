package View;

import java.awt.BorderLayout;

import javax.swing.JComboBox;
import javax.swing.JPanel;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Controller.EmpresaController;
import Model.empresa.Cliente;
import Model.empresa.Produto;

public class AddProdutoView extends JPanel {
    private Cliente cliente;
    private Menu frame;
    private JComboBox seletor = new JComboBox(EmpresaController.empresa.getArrayStringProdutos());
    public AddProdutoView(Cliente cliente, Menu frame) {
        super(new BorderLayout());
        this.cliente = cliente;
        this.frame = frame;
        selectProduct();
    }

    private void selectProduct() {
        setPreferredSize(new Dimension(800, 250));
        setBackground(Color.WHITE);
        // setBorder(BorderFactory.createEmptyBorder(50, 25, 50, 25));
        GridBagConstraints c = new GridBagConstraints();
        setLayout(new GridLayout(2, 2));

        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridwidth = 1;
        c.gridx = 1;
        c.gridy = 1;

        JLabel valor = new JLabel("Produto:", JLabel.CENTER);
        valor.setFont(new Font("Comic Sans MS", Font.BOLD, 40));
        valor.setForeground(Color.BLACK);
        valor.setBackground(Color.WHITE);
        valor.setOpaque(true);
        valor.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 0));
        valor.setPreferredSize(new Dimension(10, 10));
        add(valor, c);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridwidth = 2;
        c.gridx = 1;
        c.gridy = 1;

        
        seletor.setBorder(BorderFactory.createEmptyBorder(80, 50, 80, 50));
        seletor.setBackground(Color.WHITE);
        seletor.setForeground(Color.BLACK);
        add(seletor, c);

        Border border = BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(80, 50, 80, 50),
                BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));

        JButton back = new JButton("Cancelar");
        back.setBackground(Color.WHITE);
        back.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
        back.setForeground(Color.RED);
        back.setBorder(border);
        back.addActionListener(voltarPrincipal);
        add(back);

        JButton save = new JButton("Salvar");
        save.setBackground(Color.WHITE);
        save.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
        save.setForeground(Color.BLUE);
        save.addActionListener(salvarCliente);
        save.setBorder(border);
        add(save);

    }

    private ActionListener voltarPrincipal = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            frame.setContentPane(frame.editaCliente(cliente));
            frame.setVisible(true);
        }
    };

    private ActionListener salvarCliente = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            String name = (String) seletor.getSelectedItem();

            for (Produto p : EmpresaController.empresa.getProdutos()) 
                if (p.getNome().equals(name)) {
                    cliente.setUltimoPedido(p);
                    JOptionPane.showConfirmDialog(null, "Venda Realizada com sucesso!","Sucesso",JOptionPane.OK_OPTION);
                    frame.setContentPane(frame.editaCliente(cliente));
                    frame.setVisible(true);
                }
                    
            
        }
    };
}
