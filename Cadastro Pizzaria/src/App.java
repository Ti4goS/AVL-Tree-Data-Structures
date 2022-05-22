import javax.swing.JOptionPane;

import Controller.*;
import Model.empresa.Cliente;
import Model.empresa.Empresa;
import Model.infos.Logradouro;

public class App {
    public static void main(String[] args) throws Exception {
        int op = 0;
        
        while (op!=100) {
            op = Integer.parseInt(JOptionPane.showInputDialog("op"));

            switch (op) {
                case 0:
                    String nomeFantasia = JOptionPane.showInputDialog("Nome fantasia");
                    String nomeRepresentante = JOptionPane.showInputDialog("nomeRepresentante");
                    String tipoDeEmpresa = JOptionPane.showInputDialog("tipoDeEmpresa");
                    String cnpj = JOptionPane.showInputDialog("cnpj");
                    Logradouro endereco = new Logradouro(JOptionPane.showInputDialog("endereço"), Integer.parseInt(JOptionPane.showInputDialog("numero")), JOptionPane.showInputDialog("bairro"), JOptionPane.showInputDialog("cidade"), JOptionPane.showInputDialog("estado"));
                    String email = JOptionPane.showInputDialog("email");
                    Tree tree = new Tree();
    
                    EmpresaController.empresa = new Empresa(nomeFantasia, cnpj, nomeRepresentante, tipoDeEmpresa, endereco, email, tree);
                    break;
                case 1:
                    String telefone = JOptionPane.showInputDialog("telefone");
                    String nome = JOptionPane.showInputDialog("Nome");
                    String cpf = JOptionPane.showInputDialog("cpf");
                    Logradouro log = new Logradouro(JOptionPane.showInputDialog("endereço"), Integer.parseInt(JOptionPane.showInputDialog("numero")), JOptionPane.showInputDialog("bairro"), JOptionPane.showInputDialog("cidade"), JOptionPane.showInputDialog("estado"));
                    if(EmpresaController.empresa!=null) EmpresaController.empresa.tree.root = EmpresaController.empresa.tree.insert(EmpresaController.empresa.tree.root, new Cliente(telefone, log, nome, cpf, 0, 0, "", 0));
                
                    break;
                case 2:
                    EmpresaController.empresa.toString();
                    EmpresaController.empresa.tree.preOrder(EmpresaController.empresa.tree.root);
                    break;
                
                
                case 3:
                    ReadFile.readDB();
                    break;
                case 100:
                    WriteFile wf = new WriteFile(EmpresaController.empresa);
                    return;
                default:
                    break;
            }
        }
        
    }
}
