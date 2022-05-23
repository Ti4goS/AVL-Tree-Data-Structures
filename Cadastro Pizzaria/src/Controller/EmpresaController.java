package Controller;

import Model.empresa.Cliente;
import Model.empresa.Empresa;


public class EmpresaController {
    public static Empresa empresa;

    public static void setRoot(Cliente c) {
        empresa.tree.root = empresa.tree.insertNode(empresa.tree.root, c);
    }

    public static void deleteNode(Cliente c) {
        empresa.tree.root = empresa.tree.deleteNode(empresa.tree.root,c);
    }
}
