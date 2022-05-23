package Controller;

import Model.Node;
import Model.empresa.Cliente;
import Model.empresa.Empresa;
import Model.empresa.Produto;

public class EmpresaController {
    public static Empresa empresa;

    public static void setRoot(Cliente c) {
        empresa.tree.root = empresa.tree.insert(empresa.tree.root, c);
    }


    public static Node procuraCliente(Node root,String nome,String CPF) {
        if (nome.equals("")) return null;
        if (CPF.equals("")) return null;
        
        if(root!=null){
            if(root.cliente.getNome().contains(nome) && root.cliente.getCpf().contains(CPF)){
                return root;
            }

            if(root.cliente.getNome().compareToIgnoreCase(nome)>0) return procuraCliente(root.right, nome, CPF);

            if(root.cliente.getNome().compareToIgnoreCase(nome)<0) return procuraCliente(root.left, nome, CPF);
        }

        return null;
    }
}
