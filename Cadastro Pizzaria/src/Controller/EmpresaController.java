package Controller;

import Model.empresa.Cliente;
import Model.empresa.Empresa;


public class EmpresaController {
    public static Empresa empresa;

    public static void setRoot(Cliente c) {
        empresa.tree.insert(c);
    }

    public static void deleteNode(Cliente c) {
        empresa.tree.deleteKey(c);
    }
}
