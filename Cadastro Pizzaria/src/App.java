import javax.swing.JOptionPane;

import Controller.*;
import Model.empresa.Cliente;
import Model.empresa.Empresa;
import Model.empresa.Produto;
import Model.infos.Logradouro;
import View.Menu;

public class App {
    public static void main(String[] args) throws Exception {
        int op = 0;
        Empresa empresa = null;

        while (op!=100) {
            op = Integer.parseInt(JOptionPane.showInputDialog("op"));

            switch (op) {
                case 0:
                    String nomeFantasia = JOptionPane.showInputDialog("Nome fantasia");
                    String nomeRepresentante = JOptionPane.showInputDialog("nomeRepresentante");
                    String tipoDeEmpresa = JOptionPane.showInputDialog("tipoDeEmpresa");
                    String cnpj = JOptionPane.showInputDialog("cnpj");
                    String newProduto = JOptionPane.showInputDialog(null, "Informe o nome do produto a ser cadastrado");
                    Double valor  = Double.parseDouble(JOptionPane.showInputDialog(null, "Informe o valor do produto cadastrado"));
                    Produto novoProduto = new Produto(valor, newProduto);
                    Logradouro endereco = new Logradouro(JOptionPane.showInputDialog("endereço"), Integer.parseInt(JOptionPane.showInputDialog("numero")), JOptionPane.showInputDialog("bairro"), JOptionPane.showInputDialog("cidade"), JOptionPane.showInputDialog("estado"));
                    String email = JOptionPane.showInputDialog("email");
                    Tree tree = new Tree();
    
                    empresa = new Empresa(nomeFantasia, cnpj, nomeRepresentante, tipoDeEmpresa, endereco, email, tree, novoProduto);
                    break;
                case 1:
                    String telefone = JOptionPane.showInputDialog("telefone");
                    String nome = JOptionPane.showInputDialog("Nome");
                    String cpf = JOptionPane.showInputDialog("cpf");
                    Logradouro log = new Logradouro(JOptionPane.showInputDialog("endereço"), Integer.parseInt(JOptionPane.showInputDialog("numero")), JOptionPane.showInputDialog("bairro"), JOptionPane.showInputDialog("cidade"), JOptionPane.showInputDialog("estado"));
                    if(empresa!=null) empresa.tree.root = empresa.tree.insert(empresa.tree.root, new Cliente(telefone, log, nome, cpf, 0, 0, "", 0));
                
                    break;
                case 2:
                    empresa.toString();
                    empresa.tree.preOrder(empresa.tree.root);
                    break;
                case 3:
                    Menu m = new Menu();
                    
                    
                    break;

                case 100:
                    WriteFile wf = new WriteFile(empresa);
                    return;
                default:
                    break;
            }
        }
        
    }
}
